/**Class: Fish
 * 
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: July 15, 2018
 *
 * This class – contains information about each fish, its lifespan and time in the aquarium,
 *  as well as methods to get and set values for each fish object.
 */
public class Fish implements Comparable<Fish> {
	
	private String type;
	private double size;
	private int currentAge;
	private int maxAge;
	private boolean aggressive;
	private int daysInTank;
	
	
	/////////////////// CONSTRUCTORS ///////////////////////
	public Fish() {
		super();
		this.type = "Blue tang";
		this.size = 30;
		this.currentAge = 30;
		this.maxAge = 500;
		this.aggressive = false;
		this.daysInTank = 0;
	}

	public Fish(String type, double size, int currentAge, int maxAge, boolean aggressive, int daysInTank) {
		super();
		try {
			setType(type);
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		}
		
		setSize(size);
		
		try {
			setCurrentAge(currentAge);
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		}
		
		try {
			setMaxAge(maxAge);
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		}
		
		setAggressive(aggressive);
		
		try {
			setDaysInTank(daysInTank);
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		}
	}
	
	public Fish(String lineOfInfo) {
		super();
		
		////// parses the line by the commas and stores them in a String array //////
		String[] info = lineOfInfo.split(",");
		
		////// tries to set each field for the fish, throwing FishNotValidExceptions where needed //////	
		try {
			setType(info[0]); 
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		}
		
		try {
			setSize(Double.parseDouble(info[1]));
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		} catch (NumberFormatException nfe) {
			System.out.println("Not a valid Size.");
			size = 3.00;
		}
		
		try {
			setCurrentAge(Integer.parseInt(info[2]));
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		} catch (NumberFormatException nfe) {
			System.out.println("Not a valid CurrentAge.");
			currentAge = 30;
		}
		
		try {
			setMaxAge(Integer.parseInt(info[3]));
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		} catch (NumberFormatException nfe) {
			System.out.println("Not a valid MaxAge.");
			maxAge = 500;
		}
		
		try {
			setAggressive(Boolean.parseBoolean(info[4]));
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		} catch (IllegalArgumentException iae) {
			System.out.println("Not a valid isAggressive boolean.");
			aggressive = false;
		}
		
		try {
			setDaysInTank(Integer.parseInt(info[5]));
		} catch (FishNotValidException fnve) {
			System.out.println(fnve.getLocalizedMessage());
		} catch (NumberFormatException nfe) {
			System.out.println("Not a valid DaysInTank.");
			daysInTank = 0;
		}
	}
	////////////////////////////////////////////////////////
	
	
	
	
	
	/**Method: toString()
	 * 
	 * @return String - Returns a string of the Fish's info
	 */
	@Override
	public String toString() {
		String fishStr = "Type: " + this.getType() + "\n";
		String sizeStr = String.format("Size - %.2f inches. ", this.getSize());
		String ageStr = "Current Age - " + this.getCurrentAge() + " days. The maximum age "
				+ "for this type of fish is " + this.getMaxAge() + " days. ";
		String aggroStr = "";
		if (this.isAggressive() == true)
		{
			aggroStr = "This fish is aggressive; watch out. ";
		}
		else if (this.isAggressive() == false)
		{
			aggroStr = "This fish is not aggressive. ";
		}
		String inTankStr = "This fish has been in the tank for " + this.getDaysInTank() + "days.\n";
		
		
		fishStr = fishStr + sizeStr + ageStr + aggroStr + inTankStr;
		return fishStr;
	}
	
	
	
	
	
	/**Method: compareTo()
	 * 
	 * @param Fish otherFish - the other fish to compare types with. 
	 *
	 * @return int - Returns a negative int if the type of otherFish comes before the one 
	 * this method is called on, 0 if it's the same, and a positive int if the type of 
	 * otherFish comes after.
	 */
	public int compareTo(Fish otherFish) {
		return type.compareTo(otherFish.getType());
	}
	
	
	
	
	
	/**Method: getType()
	 * 
	 * @return name - the String type of the fish object.
	 */
	public String getType() {
		return type;
	}
	/**Method: setType()
	 * 
	 * @param type - the String type of the fish object to be set. Will throw an error if 
	 * the name is not between 1 and 20 chars.
	 */
	public void setType(String type) throws FishNotValidException {
		if (type.length() >= 1 && type.length() <= 20) {
			this.type = type;   
		} else if (type.isEmpty()) {
			throw new FishNotValidException("You must enter a type.");
		} else if (type.length() > 20) {
			throw new FishNotValidException("" + type + " is not a valid Type. Type needs to be less than 20 characters.");
		}
		
	}
	
	
	
	


	/** Method: getSize()
	 * @return size - length of the fish in inches
	 */
	public double getSize() {
		return size;
	}
	/** Method: setSize()
	 * @param size - length of the fish in inches
	 */
	public void setSize(double size) throws FishNotValidException {
		try 
		{
			this.size = size;
		} 
		catch (IllegalArgumentException e)
		{
			throw new FishNotValidException("Size must be a double.");
		}
	}

	
	
	
	
	/** Method: getCurrentAge()
	 * @return currentAge - the age of the fish in days
	 */
	public int getCurrentAge() {
		return currentAge;
	}
	/** Method: setCurrentAge()
	 * @param currentAge - the age of the fish in days
	 */
	public void setCurrentAge(int currentAge) {
		if (currentAge > 0 && currentAge < 10000) 
		{
			this.currentAge = currentAge;
		} 
		else if (currentAge < 0)
		{
			throw new FishNotValidException("Age cannot be negative.");
		}
		else if (currentAge > 10000)
		{
			throw new FishNotValidException("Age cannot be over 10,000.");
		}
	}

	
	
	
	
	
	/** Method: getMaxAge()
	 * @return maxAge - How long the fish will live in days.  
	 */
	public int getMaxAge() {
		return maxAge;
	}
	/** Method: setMaxAge()
	 * @param maxAge - the maxAge to set, How long the fish will live in days.  
	 */
	public void setMaxAge(int maxAge) {
		if (maxAge > 0 && maxAge < 15000) 
		{
			this.maxAge = maxAge;
		} 
		else if (maxAge < 0)
		{
			throw new FishNotValidException("MaxAge cannot be negative.");
		}
		else if (maxAge > 15000)
		{
			throw new FishNotValidException("MaxAge cannot be over 15,000.");
		}
	}

	
	
	
	
	
	/** Method: isAggressive()
	 * @return aggressive - is the fish aggressive or not
	 */
	public boolean isAggressive() {
		return aggressive;
	}
	/** Method: setAggressive()
	 * @param aggressive - the boolean "is aggressive or not" to be set
	 */
	public void setAggressive(boolean aggressive) {
		try
		{
			this.aggressive = aggressive;
		}
		catch (IllegalArgumentException e)
		{
			throw new FishNotValidException("Aggressive must be a boolean.");
		}
	}

	
	
	
	
	
	/** Method: getyDaysInTank()
	 * @return the daysInTank
	 */
	public int getDaysInTank() {
		return daysInTank;
	}
	/** Method: setDaysInTank()
	 * @param daysInTank - How many whole days has the fish been in the tank
	 */
	public void setDaysInTank(int daysInTank) {
		if (daysInTank > 0 && daysInTank < 1000) 
		{
			this.daysInTank = daysInTank;
		} 
		else if (daysInTank < 0)
		{
			throw new FishNotValidException("daysInTank cannot be negative.");
		}
		else if (daysInTank > 1000)
		{
			throw new FishNotValidException("daysInTank cannot be over 1,000.");
		}
	}
	
	
}
