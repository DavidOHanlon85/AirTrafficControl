package airTrafficControlSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAirline {

	// test Data

	int validCurrentSpeedLow, validCurrentSpeedMid, validCurrentSpeedHigh;
	int invalidCurrentSpeedLow, invalidCurrentSpeedHigh;

	int validDistancetoAirfieldLow, validDistancetoAirfieldMid, validDistancetoAirfieldHigh;
	int invalidDistancetoAirfieldLow, invalidDistancetoAirfieldHigh;

	String validAircraftCode1, validAircraftCode2, validAircraftCode3;
	String invalidAircraftCode1, invalidAircraftCode2, invalidAircraftCode3;

	EngineType JET, PROPELLER;

	Airline a;

	@BeforeEach
	void setUp() throws Exception {

		validCurrentSpeedLow = 0;
		validCurrentSpeedMid = 400;
		validCurrentSpeedHigh = 800;

		invalidCurrentSpeedLow = -1;
		invalidCurrentSpeedHigh = 801;

		validDistancetoAirfieldLow = 0;
		validDistancetoAirfieldMid = 10000;
		validDistancetoAirfieldHigh = 20000;

		invalidDistancetoAirfieldLow = -1;
		invalidDistancetoAirfieldHigh = 20001;

		validAircraftCode1 = "A12345";
		validAircraftCode2 = "Asdefr";
		validAircraftCode3 = "Ap2pe3";

		invalidAircraftCode1 = "A1234";
		invalidAircraftCode2 = "a12345";
		invalidAircraftCode3 = "A 1234";

		JET = EngineType.JET;
		PROPELLER = EngineType.PROPELLER;

		a = new Airline(validCurrentSpeedMid, validDistancetoAirfieldLow, validAircraftCode1, JET);

	}

	@Test
	void testAirlineConstructorValid() {

		assertNotNull(a);
		assertEquals(validCurrentSpeedMid, a.getCurrentSpeed());
		assertEquals(validDistancetoAirfieldLow, a.getDistanceToAirfield());
		assertEquals(validAircraftCode1, a.getAircraftCode());
		assertEquals(EngineType.JET, a.getEngineType());

	}

	@Test
	void testAirlineConstructorInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			Airline a = new Airline(invalidCurrentSpeedLow, validDistancetoAirfieldLow, validAircraftCode1, JET);
		});

		assertEquals("INVALID CURRENT SPEED", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			Airline a = new Airline(validCurrentSpeedLow, invalidDistancetoAirfieldHigh, validAircraftCode1, JET);
		});

		assertEquals("INVALID DISTANCE TO AIRFIELD", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			Airline a = new Airline(validCurrentSpeedLow, validDistancetoAirfieldHigh, invalidAircraftCode1, JET);
		});

		assertEquals("INVALID AIRCRAFT CODE", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			Airline a = new Airline(validCurrentSpeedLow, validDistancetoAirfieldHigh, validAircraftCode1, null);
		});

		assertEquals("INVALID ENGINE TYPE - NULL", exp.getMessage());

	}

	@Test
	void testGetSetEngineTypeValid() {
		a.setEngineType(JET);
		assertEquals(EngineType.JET, a.getEngineType());

		a.setEngineType(PROPELLER);
		assertEquals(EngineType.PROPELLER, a.getEngineType());
	}

	@Test
	void testGetSetEngineTypeInvalid() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setEngineType(null);
		});

		assertEquals("INVALID ENGINE TYPE - NULL", exp.getMessage());

	}

	@Test
	void testGetSetCurrentSpeedValid() {
		a.setCurrentSpeed(validCurrentSpeedLow);
		assertEquals(validCurrentSpeedLow, a.getCurrentSpeed());

		a.setCurrentSpeed(validCurrentSpeedMid);
		assertEquals(validCurrentSpeedMid, a.getCurrentSpeed());

		a.setCurrentSpeed(validCurrentSpeedHigh);
		assertEquals(validCurrentSpeedHigh, a.getCurrentSpeed());
	}

	@Test
	void testGetSetCurrentSpeedInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setCurrentSpeed(invalidCurrentSpeedLow);
		});

		assertEquals("INVALID CURRENT SPEED", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setCurrentSpeed(invalidCurrentSpeedHigh);
		});

		assertEquals("INVALID CURRENT SPEED", exp.getMessage());
	}

	@Test
	void testGetSetDistanceToAirfieldValid() {
		a.setDistanceToAirfield(validDistancetoAirfieldLow);
		assertEquals(validDistancetoAirfieldLow, a.getDistanceToAirfield());

		a.setDistanceToAirfield(validDistancetoAirfieldMid);
		assertEquals(validDistancetoAirfieldMid, a.getDistanceToAirfield());

		a.setDistanceToAirfield(validDistancetoAirfieldHigh);
		assertEquals(validDistancetoAirfieldHigh, a.getDistanceToAirfield());

	}

	@Test
	void testGetSetDistanceToAirfieldInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setDistanceToAirfield(invalidDistancetoAirfieldLow);
		});

		assertEquals("INVALID DISTANCE TO AIRFIELD", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setDistanceToAirfield(invalidDistancetoAirfieldHigh);
		});

		assertEquals("INVALID DISTANCE TO AIRFIELD", exp.getMessage());
	}

	@Test
	void testGetSetAircraftCodeValid() {
		a.setAircraftCode(validAircraftCode1);
		assertEquals(validAircraftCode1, a.getAircraftCode());

		a.setAircraftCode(validAircraftCode2);
		assertEquals(validAircraftCode2, a.getAircraftCode());

		a.setAircraftCode(validAircraftCode3);
		assertEquals(validAircraftCode3, a.getAircraftCode());
	}

	@Test
	void testGetSetAircraftCodeInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setAircraftCode(invalidAircraftCode1);
		});

		assertEquals("INVALID AIRCRAFT CODE", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setAircraftCode(invalidAircraftCode2);
		});

		assertEquals("INVALID AIRCRAFT CODE - CODE DOES NOT BEGIN WITH A", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setAircraftCode(invalidAircraftCode3);
		});

		assertEquals("INVALID AIRCRAFT CODE - CODE CONTAINS WHITESPACE", exp.getMessage());

	}

	@Test
	void testTimeToAirfieldValid() {

		Airline a = new Airline(100, 100, validAircraftCode1, JET);

		int estimatedTimeToAirfield = 60;

		assertEquals(estimatedTimeToAirfield, a.timeToAirfield());

		a = new Airline(100, 200, validAircraftCode1, JET);

		estimatedTimeToAirfield = 120;

		assertEquals(estimatedTimeToAirfield, a.timeToAirfield());
		
		a = new Airline(200, 100, validAircraftCode1, JET);

		estimatedTimeToAirfield = 30;

		assertEquals(estimatedTimeToAirfield, a.timeToAirfield());

	}
	
	// No test for invalid as getters and setters catch all invalid inputs - negative numbers and nulls

}
