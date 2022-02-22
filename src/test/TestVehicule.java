package test;

import entities.Position;
import entities.Vehicule;
import service.VehiculeService;

public class TestVehicule {
	public static void main(String[] args) {
		VehiculeService vs = new VehiculeService();
		
		vs.create(new Vehicule("256", "Santafee", "voiture"));
		vs.create(new Vehicule("256", "Corolla", "voiture"));
		vs.create(new Vehicule("256", "trafic", "transit"));
		vs.create(new Vehicule("256", "kawazaki", "moto"));
		
		vs.delete(vs.findById(3));
		
		Vehicule ves = vs.findById(2);
		ves.setMarque("nissan");
		ves.setMatricule("698");
		ves.setType("moto");
		vs.update(ves);
		
		System.out.println();
		System.out.println("les Vehicules");
		for(Vehicule ves1 : vs.findAll()) {
			System.out.println(ves1);
		}
	}

}
