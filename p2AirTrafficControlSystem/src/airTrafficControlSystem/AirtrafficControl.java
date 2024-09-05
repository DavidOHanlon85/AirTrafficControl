/**
 * 
 */
package airTrafficControlSystem;

import java.util.ArrayList;

/**
 * David O'Hanlon - 15621049
 */
public class AirtrafficControl {

	/**
	 * This method searches an ArrayList of type Aircraft and returns an ArrayList
	 * of those aircraft travelling between minSpeed and maxSpeed (inclusive)
	 * IllegalArgumeent Exceptions with relevant messages are thrown if there is an
	 * input error or the input AL is null or empty.
	 * 
	 * @param aircrafts
	 * @param minSpeed
	 * @param maxSpeed
	 * @return
	 * @throws IllegalArgumentException
	 */

	public static ArrayList<Aircraft> searchBySpeed(ArrayList<Aircraft> aircrafts, int minSpeed, int maxSpeed)
			throws IllegalArgumentException {

		ArrayList<Aircraft> results = new ArrayList<Aircraft>();

		if (minSpeed > maxSpeed) {
			throw new IllegalArgumentException("INPUT ERROR");
		}

		if (aircrafts == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (aircrafts.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		for (Aircraft a : aircrafts) {
			if (a.getCurrentSpeed() >= minSpeed && a.getCurrentSpeed() <= maxSpeed) {
				results.add(a);
			}
		}

		return results;
	}

	/**
	 * This method searches an ArrayList of type Airline and returns an ArrayList of
	 * those Airlines with the desired Engine Type IllegalArgumeent Exceptions with
	 * relevant messages are thrown if there is an Engine Type input error or the
	 * input AL is null or empty.
	 * 
	 * @param aircrafts
	 * @param minSpeed
	 * @param maxSpeed
	 * @return
	 * @throws IllegalArgumentException
	 */

	public static ArrayList<Airline> searchAllByEngineType(ArrayList<Airline> airlines, EngineType engineType)
			throws IllegalArgumentException {

		ArrayList<Airline> results = new ArrayList<Airline>();

		if (engineType == null) {
			throw new IllegalArgumentException("ENGINE TYPE IS NULL");
		}

		if (airlines == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (airlines.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		for (Airline a : airlines) {
			if (a.getEngineType() == engineType) {
				results.add(a);
			}
		}

		return results;

	}

	/**
	 * This method returns and ArrayList of results of all airlines within the
	 * minTimeFromAirfield and maxTimeFromAirfield (inclusive) with the specified
	 * Engine Type. IllegalArgumeent Exceptions with relevant messages are thrown if there is an Min and MaxTimeFromAirfield Input Error, an Engine Type input error
	 * or the input AL is null or empty.
	 * 
	 * @param airlines
	 * @param minTimeFromAirfield
	 * @param maxTimeFromAirfield
	 * @param engineType
	 * @return
	 * @throws IllegalArgumentException
	 */

	public static ArrayList<Airline> searchForLandingList(ArrayList<Airline> airlines, int minTimeFromAirfield,
			int maxTimeFromAirfield, EngineType engineType) throws IllegalArgumentException {

		ArrayList<Airline> results = new ArrayList<Airline>();

		if (minTimeFromAirfield > maxTimeFromAirfield) {
			throw new IllegalArgumentException("INPUT ERROR");
		}

		if (engineType == null) {
			throw new IllegalArgumentException("ENGINE TYPE IS NULL");
		}

		if (airlines == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (airlines.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		for (Airline a : airlines) {
			if (a.timeToAirfield() >= minTimeFromAirfield && a.timeToAirfield() <= maxTimeFromAirfield
					&& a.getEngineType() == engineType) {
				results.add(a);
			}
		}

		return results;

	}

}
