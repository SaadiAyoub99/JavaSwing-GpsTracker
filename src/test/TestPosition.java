package test;

import java.util.Date;

import entities.Position;
import service.PositionService;
import service.TrackerService;

public class TestPosition {

	public static void main(String[] args) {
		TrackerService ts = new TrackerService();
		PositionService ps = new PositionService();
		
		ps.create(new Position(41, -9, new Date(), ts.findById(2)));
		ps.create(new Position(71, -8, new Date(), ts.findById(3)));
		//ps.create(new Position(91, -2, new Date("1999/02/01"), ts.findById(1)));
		
		ps.delete(ps.findById(1));
                
                                Position position = ps.findById(2);
		position.setLatitude(11.32256332);
		position.setLongitude(8.2563225);
		position.setDate(new Date("1999/06/11"));
		ps.update(position);

                                System.out.println();
		System.out.println("les Positions ");
		for(Position p : ps.findAll()) {
			System.out.println(p);
		}
	}

}
