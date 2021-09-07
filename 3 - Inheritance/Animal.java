/**Class: Animal
 * 
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: June 20, 2018
 *
 * This class – Is an abstract holder of the name and #ofPaws fields, and the methods 
 * associated with them, as well as an abstract speak() method that can be overwritten 
 * by subclasses.
 */
public abstract class Animal implements Comparable<Animal> {
	
	private String name;
	private int paws;
	
	

	public Animal() {
		super();
		name = "Not set";
		paws = 0;
	}

	public Animal(String name, int paws) {
		super();
		setName(name);
		setPaws(paws);
	}
	
	/**Method: compareTo()
	 * 
	 * @param Animal otherAnimal - the other animal to compare names with. 
	 *
	 * @return int - Returns a negative
	 * int if the name of otherAnimal comes before the one this method is called on, 0 if it's
	 * the same, and a positive int if the name of otherAnimal comes after.
	 */
	public int compareTo(Animal otherAnimal) {
		return name.compareTo(otherAnimal.getName());
	}
	
	
	/**Method: getName()
	 * 
	 * @return name - the String name of the object.
	 */
	public String getName() {
		return name;
	}
	/**Method: setName()
	 * 
	 * @param name - the String name of the object to be set. Will throw an error if 
	 * the name is not between 1 and 10 chars.
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name.length() >= 1 && name.length() <= 10) {
			this.name = name;   
		} else if (name.isEmpty()) {
			throw new IllegalArgumentException("You must enter a name.");
		} else if (name.length() > 10) {
			throw new IllegalArgumentException("" + name + " is not a valid name.");
		}
		
	}
	
	/**Method: getPaws()
	 * 
	 * @return paws - the number of paws the Animal object has. Will throw an error if 
	 * the number of paws is not between 1 and 4.
	 */
	public int getPaws() {
		return paws;
	}
	/**Method: setPaws()
	 * 
	 * @param paws - the number of paws the Animal object has. 
	 */
	public void setPaws(int paws) throws IllegalArgumentException {
		
		if (paws >= 0 && paws <= 4) {  // Throws an error if # of paws is not between 1 and 4
			this.paws = paws;
		} else {
			throw new IllegalArgumentException("An animal must have between 0 and 4 paws.");
		}
	}
	
	
	/** Method: speak()
	 */
	public abstract String speak();
	
	
	/**Method: toString()
	 * 
	 * @return String - Returns a string of the Animal's name and number of paws.
	 */
	@Override
	public String toString() {
		return name + "; " + paws;
	}
	
	
}
