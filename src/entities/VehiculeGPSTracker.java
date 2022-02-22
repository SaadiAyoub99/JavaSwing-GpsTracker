package entities;

import java.util.Date;

public class VehiculeGPSTracker {
        private int id;
	private Date dateDebut;
	private Date dateFin;
	private Vehicule v;
	private Tracker t;
	
	public VehiculeGPSTracker(Date dateDebut, Date dateFin, Vehicule v, Tracker t) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.v = v;
		this.t = t;
	}
        
        public VehiculeGPSTracker(int id,Date dateDebut, Date dateFin, Vehicule v, Tracker t) {
                this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.v = v;
		this.t = t;
	}
        
        public int getId(){
            return id;
        }
        
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Vehicule getV() {
		return v;
	}

	public void setV(Vehicule v) {
		this.v = v;
	}

	public Tracker getT() {
		return t;
	}

	public void setT(Tracker t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "VehiculeGPSTracker [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", v=" + v + ", t=" + t + "]";
	}
	
	
	
	

}
