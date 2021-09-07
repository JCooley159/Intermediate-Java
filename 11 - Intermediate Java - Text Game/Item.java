/**
 * Class: Item
 * 
 * @author: ITEC 2150
 * @version 1.0 
 * Course: ITEC 2150 June 14, 2016
 * Inheritance
 * Purpose - class used to test understanding of inheritance
 */
public class Item {
	private String name;
	private boolean weapon;

	/** Method Item
	 * Constructor
	 * 
	 * @param name - String representing the item name
	 */
	public Item(String name) {
		this.name = name;
		weapon = false;
	}

	/** Method getName
	 * gets the name of the item
	 * 
	 * @param none
	 * @return String - the name of the item
	 */
	public String getName() {
		return name;
	}

	/** Method setWeapon
	 * sets the item to a weapon
	 * 
	 * @param none
	 * @return void
	 */
	public void setWeapon() {
		weapon = true;
	}

	/** Method isWeapon
	 * determines if an item is a weapon
	 * 
	 * @param none
	 * @return boolean - true if it is a weapon, false if not
	 */
	public boolean isWeapon() {
		return weapon;
	}
	
	public String toString()
	{
		return name + " " + weapon;
	}

	@Override
	/** Method equals
	 * determines if an item is the same as the implicit item
	 * 
	 * @param Object - item to be compared
	 * @return boolean - true if they have the same name, false if different
	 */
	public boolean equals(Object obj) {
		if (name.equals(((Item) obj).getName())) {
			return true;
		} else {
			return false;
		}
	}
}