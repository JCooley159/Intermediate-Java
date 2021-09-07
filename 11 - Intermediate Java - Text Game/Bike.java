/**
 * Class: 
 * @author Your Name
 * @version 1.0
 * Course : ITEC 2150 Summer 2018
 * Written: July 24, 2018
 *
 * This class is an abstract class representing the base class for each type of Bike. 
 */
public abstract class Bike
{
	private String[] powerTypes = {"pedal", "gas", "electric"};
	private String type;
	public abstract int getMaxSpeed();
	public abstract String getPowerType();
	
	public Bike(String type)
	{
		this.type = type;
	}
	
	public String getPowerTypes(int num)
	{
		return powerTypes[num];
	}
	
	public void validatePowerType(String type) throws UnknownPowerTypeException
	{
		boolean found = false;
		for (int index = 0; index < powerTypes.length && !found; index++)
		{
			if (type.equalsIgnoreCase(powerTypes[index]))
			{
				found = true;
			}
		}
		
		if (!found)
		{
			throw new UnknownPowerTypeException("Invalid power type " + type + " encountered.");
		}
	}
	
	public String getType()
	{
		return type;
	}

	
	public String toString()
	{
		return "Your bike is a " + type + " with a max speed of " + getMaxSpeed() 
				+ "\n\t It is powered by " + getPowerType() + "."; 
	}

}
