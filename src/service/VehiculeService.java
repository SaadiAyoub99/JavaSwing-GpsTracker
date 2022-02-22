package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Vehicule;
import entities.Vehicule;

public class VehiculeService implements IDao<Vehicule> {
	
	

	@Override
	public boolean create(Vehicule o) {
		try {
			String req = "insert into vehicule values (null, ?,?,?)";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setString(1, o.getMatricule());
			pr.setString(2, o.getMarque());
			pr.setString(3, o.getType());
			if (pr.executeUpdate() != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Vehicule o) {
		try {
			String req = "update vehicule set matricule = ?, marque = ?, type = ? where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setString(1, o.getMatricule());
			pr.setString(2, o.getMarque());
			pr.setString(3, o.getType());
			pr.setInt(4, o.getId());
			if (pr.executeUpdate() != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Vehicule o) {
		try {
			String req = "delete from vehicule where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, o.getId());
			if (pr.executeUpdate() != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Vehicule findById(int id) {
		try {
			String req = "select * from vehicule where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs.next())
				return new Vehicule(rs.getInt("id"), rs.getString("matricule"), rs.getString("marque"),
						rs.getString("type"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Vehicule> findAll() {
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		try {
			String req = "select * from vehicule";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			ResultSet rs = pr.executeQuery();
			while (rs.next())
				vehicules.add(new Vehicule(rs.getInt("id"), rs.getString("matricule"), rs.getString("marque"),
						rs.getString("type")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicules;
	}

}
