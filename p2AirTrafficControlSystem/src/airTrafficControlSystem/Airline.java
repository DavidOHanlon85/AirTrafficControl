/**
 * 
 */
package airTrafficControlSystem;

import java.util.Objects;

/**
 * @author David O'Hanlon - 15621049
 */
public class Airline extends Aircraft {

	// Instance Variables

	private EngineType engineType;

	/**
	 * This is the Airline default constructor
	 */
	public Airline() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This is the Arline contructor with args
	 * 
	 * @param currentSpeed
	 * @param distanceToAirfield
	 * @param aircraftCode
	 * @param engineType
	 */
	public Airline(int currentSpeed, int distanceToAirfield, String aircraftCode, EngineType engineType) {
		super(currentSpeed, distanceToAirfield, aircraftCode);
		this.setEngineType(engineType);
	}

	// Getters and setters

	/**
	 * @return the engineType
	 */
	public EngineType getEngineType() {
		return engineType;
	}

	/**
	 * Sets the EngineType according to ENUM - will throw IllegalArgumentException
	 * if null
	 * 
	 * @param engineType
	 * @throws IllegalArgumentException
	 */
	public void setEngineType(EngineType engineType) throws IllegalArgumentException {
		if (engineType == null) {
			throw new IllegalArgumentException("INVALID ENGINE TYPE - NULL");
		} else {
			this.engineType = engineType;
		}
	}
	
	// methods
	
	public double timeToAirfield() {
		
		if (getDistanceToAirfield() < 0 || getCurrentSpeed() <0) {
			throw new IllegalArgumentException("INVALID INPUTS");
		}
		
		double estimastedTimeToAirfield = (((double)getDistanceToAirfield() / getCurrentSpeed()) * 60);
		
		return estimastedTimeToAirfield;
	}

	// hashCode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(engineType);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airline other = (Airline) obj;
		return engineType == other.engineType;
	}

}
