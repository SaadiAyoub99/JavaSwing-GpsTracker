package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Position;
import entities.Tracker;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehiculeGPSTrakerService implements IDao<VehiculeGPSTracker> {

    TrackerService ts = new TrackerService();
    VehiculeService vs = new VehiculeService();

    @Override
    public boolean create(VehiculeGPSTracker o) {
        try {
            String req = "insert into vehicule_tracker values (null,?,?,?,?)";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setDate(1, new Date(o.getDateDebut().getTime()));
            pr.setDate(2, new Date(o.getDateFin().getTime()));
            pr.setInt(3, o.getV().getId());
            pr.setInt(4, o.getT().getId());

            if (pr.executeUpdate() != 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(VehiculeGPSTracker o) {
        try {
            String req = "update vehicule_tracker set  date_debut = ?, date_fin = ?, vehicule = ?, tracker=? where id = ? ";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setDate(1, new Date(o.getDateDebut().getTime()));
            pr.setDate(2, new Date(o.getDateFin().getTime()));
            pr.setInt(3, o.getV().getId());
            pr.setInt(4, o.getT().getId());
            pr.setInt(5, o.getId());

            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(VehiculeGPSTracker o) {
        try {
            String req = "delete from vehicule_tracker where id =?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getId());
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public VehiculeGPSTracker findById(int id) {
        try {
            String req = "select * from vehicule_tracker where id =?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new VehiculeGPSTracker(rs.getInt("id"), rs.getDate("date_debut"), rs.getDate("date_fin"), vs.findById(rs.getInt("vehicule")), ts.findById(rs.getInt("tracker")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int findbyPK(int v, int t, Date d) {
        try {
            String req = "select count(*) from vehicule_tracker where tracker= ? and vehicyule=? and date_debut=?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, t);
            pr.setInt(2, v);
            pr.setDate(3, new Date(d.getTime()));
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<VehiculeGPSTracker> findAll() {
        List<VehiculeGPSTracker> vehiculeTrackers = new ArrayList<VehiculeGPSTracker>();

        try {
            String req = "select * from vehicule_tracker";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                vehiculeTrackers.add(new VehiculeGPSTracker(rs.getInt("id"), rs.getDate("date_debut"), rs.getDate("date_fin"),
                        vs.findById(rs.getInt("vehicule")), ts.findById(rs.getInt("tracker"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculeTrackers;
    }

    public List<Position> findPositionsBetweenDates(Tracker tracker, String dateDebut, String dateFin) throws ParseException {

        List<Position> Positions = new ArrayList<Position>();

        try {
            String req = "SELECT id , latitude , longitude , date "
                    + "FROM position "
                    + "WHERE idTracker = ? "
                    + "AND date >= ? "
                    + "AND date <= ? ";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date dD = sdf.parse(dateDebut);
            java.sql.Date dDSql = new java.sql.Date(dD.getTime());

            java.util.Date dF = sdf.parse(dateFin);
            java.sql.Date dFSql = new java.sql.Date(dF.getTime());

            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, tracker.getId());
            pr.setDate(2, dDSql);
            pr.setDate(3, dFSql);

            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                Positions.add(new Position(rs.getInt("id"), rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getDate("date")));
            } else {
                System.out.println("non ");
            }
        } catch (SQLException e) {
            System.out.println("Erreur :: VehiculeGPSTracker : findGPSTrackersBetweenDates");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Positions;
    }

    public List<Position> PosVecBetweenDate(Vehicule vehicule, String dateDebut, String dateFin) {
        List<Position> positions = new ArrayList<Position>();
        
        try {
            String req = "select p.*  "
                    + "from position p , vehicule_tracker vt "
                    + "WHERE p.idTracker = vt.tracker "
                    + "and vt.vehicule = ? "
                    + "and vt.date_debut >= ? "
                    + "and vt.date_fin <= ? ";


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date dD = sdf.parse(dateDebut);
            java.sql.Date dDSql = new java.sql.Date(dD.getTime());

            java.util.Date dF = sdf.parse(dateFin);
            java.sql.Date dFSql = new java.sql.Date(dF.getTime());
            
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, vehicule.getId());
            pr.setDate(2, dDSql);
            pr.setDate(3, dFSql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                positions.add(new Position(rs.getInt("id"), rs.getDouble("latitude"), rs.getDouble("longitude"),
                        rs.getDate("date"), ts.findById(rs.getInt("idTracker"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(VehiculeGPSTrakerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return positions;
    }
}
