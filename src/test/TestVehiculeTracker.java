package test;

import java.util.Date;

import entities.Position;
import entities.VehiculeGPSTracker;
import service.TrackerService;
import service.VehiculeGPSTrakerService;
import service.VehiculeService;

public class TestVehiculeTracker {
	public static void main(String[] args) {
		
                                VehiculeGPSTrakerService vgt = new VehiculeGPSTrakerService();
		VehiculeService vs = new VehiculeService();
		TrackerService gts = new TrackerService();
		
		vgt.create(new VehiculeGPSTracker(new Date("2021/09/09"), new Date("2021/10/09"), vs.findById(1), gts.findById(2)));
		vgt.create(new VehiculeGPSTracker(new Date("2021/08/08"), new Date("2021/09/09"), vs.findById(2), gts.findById(3)));
		
		
		vgt.delete(vgt.findById(1));
		
		VehiculeGPSTracker VGPSTracker = vgt.findById(2);
		VGPSTracker.setDateDebut(new Date("2021/08/25"));
		VGPSTracker.setDateFin(new Date("2021/07/23"));
		vgt.update(VGPSTracker);
		
		System.out.println();
		System.out.println("Vehicule GPS Tracker");
		for(VehiculeGPSTracker gpst : vgt.findAll()) {
			System.out.println(gpst);
		}
		
	}
	
	

}
