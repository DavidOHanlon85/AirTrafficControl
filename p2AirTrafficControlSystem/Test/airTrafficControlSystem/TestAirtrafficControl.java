package airTrafficControlSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAirtrafficControl {

	// Test Data

	ArrayList<Aircraft> aircrafts;

	ArrayList<Airline> airlines;

	Aircraft a1, a2, a3, a4, a5;

	Airline aa1, aa2, aa3, aa4, aa5;

	AirtrafficControl ac;

	@BeforeEach
	void setUp() throws Exception {

		aircrafts = new ArrayList<Aircraft>();

		a1 = new Airline(100, 100, "A12345", EngineType.JET);
		a2 = new Airline(200, 100, "A12345", EngineType.PROPELLER);
		a3 = new Airline(300, 100, "A12345", EngineType.JET);
		a4 = new Airline(400, 100, "A12345", EngineType.PROPELLER);
		a5 = new Airline(500, 100, "A12345", EngineType.JET);

		aircrafts.add(a1);
		aircrafts.add(a2);
		aircrafts.add(a3);
		aircrafts.add(a4);
		aircrafts.add(a5);

		airlines = new ArrayList<Airline>();

		aa1 = new Airline(100, 100, "A12345", EngineType.JET);
		aa2 = new Airline(200, 100, "A12345", EngineType.PROPELLER);
		aa3 = new Airline(300, 100, "A12345", EngineType.JET);
		aa4 = new Airline(400, 100, "A12345", EngineType.PROPELLER);
		aa5 = new Airline(500, 100, "A12345", EngineType.JET);

		airlines.add(aa1);
		airlines.add(aa2);
		airlines.add(aa3);
		airlines.add(aa4);
		airlines.add(aa5);

		ac = new AirtrafficControl();

	}

	@Test
	void testSearchBySpeedValid() {

		ArrayList<Aircraft> results = ac.searchBySpeed(aircrafts, 60, 360);

		assertTrue(results.size() == 3);
		assertTrue(results.contains(a1));
		assertTrue(results.contains(a2));
		assertTrue(results.contains(a3));

		results = ac.searchBySpeed(aircrafts, 360, 560);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(a4));
		assertTrue(results.contains(a5));

	}

	@Test
	void testSearchBySpeedInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchBySpeed(aircrafts, 360, 60);
		});

		assertEquals("INPUT ERROR", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchBySpeed(null, 60, 360);
		});

		assertEquals("AL IS NULL", exp.getMessage());

		aircrafts.clear();

		exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchBySpeed(aircrafts, 60, 360);
		});

		assertEquals("AL IS EMPTY", exp.getMessage());

	}

	@Test
	void testSearchAllByEngineTypeValid() {
		
		ArrayList<Airline> results = ac.searchAllByEngineType(airlines, EngineType.JET);

		assertTrue(results.size() == 3);
		assertTrue(results.contains(aa1));
		assertTrue(results.contains(aa3));
		assertTrue(results.contains(aa5));

		results = ac.searchAllByEngineType(airlines, EngineType.PROPELLER);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(aa2));
		assertTrue(results.contains(aa4));

	}
	
	@Test
	void testSearchAllByEngineTypeInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchAllByEngineType(airlines, null);
		});

		assertEquals("ENGINE TYPE IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchAllByEngineType(null, EngineType.PROPELLER);
		});

		assertEquals("AL IS NULL", exp.getMessage());
		
		airlines.clear();
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchAllByEngineType(airlines, EngineType.PROPELLER);
		});

		assertEquals("AL IS EMPTY", exp.getMessage());

	}

	@Test
	void testSearchForLandingListValid() {
		
		ArrayList<Airline> results = ac.searchForLandingList(airlines, 5, 30, EngineType.JET);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(aa3));
		assertTrue(results.contains(aa5));
		
		results = ac.searchForLandingList(airlines, 0, 29, EngineType.PROPELLER);

		assertTrue(results.size() == 1);
		assertTrue(results.contains(aa4));
		
	}
	
	@Test
	void testSearchForLandingListInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchForLandingList(airlines, 30, 29, EngineType.PROPELLER);
		});

		assertEquals("INPUT ERROR", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchForLandingList(airlines, 0, 29, null);
		});

		assertEquals("ENGINE TYPE IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchForLandingList(null, 0, 29, EngineType.PROPELLER);
		});

		assertEquals("AL IS NULL", exp.getMessage());
		
		airlines.clear();
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			ac.searchForLandingList(airlines, 0, 29, EngineType.PROPELLER);
		});

		assertEquals("AL IS EMPTY", exp.getMessage());
		
		
		
	}

}
