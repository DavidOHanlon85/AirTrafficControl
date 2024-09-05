package airTrafficControlSystem;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
		
		Aircraft a1 = new Airline(100, 100, "AF3244", EngineType.PROPELLER);
		Aircraft a2 = new Airline(200, 100, "AF3244", EngineType.PROPELLER);
		Aircraft a3 = new Airline(300, 100, "AF3244", EngineType.PROPELLER);
		Aircraft a4 = new Airline(400, 100, "AF3244", EngineType.PROPELLER);
		Aircraft a5 = new Airline(500, 100, "AF3244", EngineType.PROPELLER);
		
		AirtrafficControl a = new AirtrafficControl();
		
		aircrafts.add(a1);
		aircrafts.add(a2);
		aircrafts.add(a3);
		aircrafts.add(a4);
		aircrafts.add(a5);
		
		ArrayList<Airline> airlines = new ArrayList<Airline>();
		
		Airline aa1 = new Airline(100, 100, "AF3244", EngineType.PROPELLER);
		Airline aa2 = new Airline(100, 150, "AF3244", EngineType.PROPELLER);
		Airline aa3 = new Airline(100, 200, "AF3244", EngineType.PROPELLER);
		Airline aa4 = new Airline(100, 100, "AF3244", EngineType.JET);
		Airline aa5 = new Airline(100, 300, "AF3244", EngineType.PROPELLER);
		
		airlines.add(aa1);
		airlines.add(aa2);
		airlines.add(aa3);
		airlines.add(aa4);
		airlines.add(aa5);
		
		ArrayList<Aircraft> results = a.searchBySpeed(aircrafts, 100, 102);
		
		System.out.println(results.size());
		
		
		ArrayList<Airline> results2 = a.searchForLandingList(airlines, 30, 90, EngineType.PROPELLER);
		
		System.out.println(results2.size());

	}

}
