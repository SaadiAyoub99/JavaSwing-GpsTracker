package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.Connexion;

public class Test {
	
	public static void main(String[] args) {
		try {
                    
                                                String TAdmin = " create table admin ("
                                                                                + "id int primary key auto_increment,"
                                                                                + "username varchar(30),"
                                                                                + "password varchar (30));";
			String TTracker = "create table tracker ("
					+ "id int primary key auto_increment,"
					+ "simNumber varchar(20));";
			String TPosition = "create table position ("
					+ "id int primary key auto_increment,"
					+ "latitude double,"
					+ "longitude double,"
					+ "date date, "
					+ "idTracker int);";
			String fk = "alter table position add "
					+ "constraint fk foreign key (idTracker) "
					+ "references tracker(id);";
			
			String TVehicule = "create table vehicule ("
					+"id int primary key auto_increment,"
					+"matricule varchar(20),"
					+"marque varchar(20),"
					+"type varchar(20));";
			String TVehiculeTracker = "create table vehicule_tracker ("
                                                                                +"id int primary key auto_increment,"
					+"date_debut date,"
					+"date_fin date,"
					+"vehicule int,"
					+"tracker int);";
			
			String fkV = "alter table vehicule_tracker add "
					+ "constraint fk_V foreign key (vehicule) "
					+ "references vehicule(id);";
			String fkT = "alter table vehicule_tracker add "
					+ "constraint fk_T foreign key (tracker) "
					+ "references tracker(id);";
			
			Statement st = Connexion.getConnection().createStatement();
                                                st.execute("drop table if exists admin");
			st.execute("drop table if exists vehicule_tracker");
			st.execute("drop table if exists position");
			st.execute("drop table if exists tracker");
			st.execute("drop table if exists vehicule");
                        
                                                st.executeUpdate(TAdmin);
			st.executeUpdate(TTracker);
			st.executeUpdate(TPosition);
			st.executeUpdate(TVehicule);
			st.executeUpdate(TVehiculeTracker);
			st.executeUpdate(fk);
			st.executeUpdate(fkV);
			st.executeUpdate(fkT);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
