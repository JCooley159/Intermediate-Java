/**Class: Dog
 * 
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: June 20, 2018
 *
 * This class – Is a subclass of Animal, used for determining specific behaviors, like the 
 * speak() method, even though the name and number of paws might be the same.
 */
public class Dog extends Animal {

	public Dog() {}
	
	
	public Dog(String name, int paws) {
		super(name, paws);
	}

	/** Method: speak()
	 * 
	 * @return String - When called on a Dog object, speak() returns the String "Woof Woof!"
	 */
	@Override
	public String speak() {
		
		return "Woof, woof!";
	}

	/**Method: toString()
	 * 
	 * @return String - Returns a string of the Dog's name, number of paws, and the noise a dog makes, "Woof, Woof!"
	 */
	@Override
	public String toString() {
		return "Dog [" + super.toString() + "; " + this.speak() + "]";
	}
	
	
	
	
}
