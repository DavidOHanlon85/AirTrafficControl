/**
 * 
 */
package airTrafficControlSystem;

import java.util.Objects;

/**
 * @author David O'Hanlon - 15621049
 */
public abstract class Aircraft {

	// Constants

	private static final int MAX_CURRENT_SPEED = 800;
	private static final int MIN_CURRENT_SPEED = 0;

	private static final int MIN_DISTANCE_TO_AIRFIELD = 0;
	private static final int MAX_DISTANCE_TO_AIRFIELD = 20000;

	private static final int AIRCRAFT_CODE_LENGTH = 6;

	// Instance variables

	private int currentSpeed;
	private int distanceToAirfield;
	private String aircraftCode;

	// Constructors

	/**
	 * This is the default constructor for Aircraft
	 * 
	 */

	Aircraft() {

	}

	/**
	 * Aircraft constructor with args
	 * 
	 * @param currentSpeed
	 * @param distanceToAirfield
	 * @param aircraftCode
	 */
	public Aircraft(int currentSpeed, int distanceToAirfield, String aircraftCode) {
		super();
		this.setCurrentSpeed(currentSpeed);
		this.setDistanceToAirfield(distanceToAirfield);
		this.setAircraftCode(aircraftCode);
	}

	// Getters and setters
	/**
	 * @return the speed
	 */
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * Sets currentSpeed according to business rules that speed must be between 0 -
	 * 800 (inclusive), otherwise an IllegalArgumentException is thrown
	 * 
	 * @param currentSpeed
	 * @throws IllegalArgumentException
	 */
	public void setCurrentSpeed(int currentSpeed) throws IllegalArgumentException {
		if (currentSpeed >= MIN_CURRENT_SPEED && currentSpeed <= MAX_CURRENT_SPEED) {
			this.currentSpeed = currentSpeed;
		} else {
			throw new IllegalArgumentException("INVALID CURRENT SPEED");
		}

	}

	/**
	 * @return the distanceToAirfield
	 */
	public int getDistanceToAirfield() {
		return distanceToAirfield;
	}

	/**
	 * Sets distancetoAirfield according to business rules that the distance must be
	 * between 0 = 20000 (inclusive), otherwise an IllegalArgumentException is
	 * thrown
	 * 
	 * @param distanceToAirfield
	 * @throws IllegalArgumentException
	 */
	public void setDistanceToAirfield(int distanceToAirfield) throws IllegalArgumentException {
		if (distanceToAirfield >= MIN_DISTANCE_TO_AIRFIELD && distanceToAirfield <= MAX_DISTANCE_TO_AIRFIELD) {
			this.distanceToAirfield = distanceToAirfield;
		} else {
			throw new IllegalArgumentException("INVALID DISTANCE TO AIRFIELD");
		}
	}

	/**
	 * @return the aircraftCode
	 */
	public String getAircraftCode() {
		return aircraftCode;
	}

	/**
	 * @param aircraftCode the aircraftCode to set
	 */
	public void setAircraftCode(String aircraftCode) {
		if (aircraftCode.length() != AIRCRAFT_CODE_LENGTH) {
			throw new IllegalArgumentException("INVALID AIRCRAFT CODE");
		} else if (aircraftCode.charAt(0) != 'A') {
			throw new IllegalArgumentException("INVALID AIRCRAFT CODE - CODE DOES NOT BEGIN WITH A");
		} else if (aircraftCode.contains(" ")) {
			throw new IllegalArgumentException("INVALID AIRCRAFT CODE - CODE CONTAINS WHITESPACE");
		} else {
			this.aircraftCode = aircraftCode;
		}
	}

// hashCode and equals

	@Override
	public int hashCode() {
		return Objects.hash(aircraftCode, currentSpeed, distanceToAirfield);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aircraft other = (Aircraft) obj;
		return Objects.equals(aircraftCode, other.aircraftCode) && currentSpeed == other.currentSpeed
				&& distanceToAirfield == other.distanceToAirfield;
	}

}
