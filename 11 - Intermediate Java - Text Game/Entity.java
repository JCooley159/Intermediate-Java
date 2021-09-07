/**
 * Class: Entity
 * 
 * @author: ITEC 2150
 * @version 1.0 
 * Course: ITEC 2150 June 14, 2016
 * Inheritance
 * Purpose - class used to test understanding of inheritance
 */

import java.util.ArrayList;

public abstract class Entity {
	private String name;
	private int healthPoints;
	private ArrayList<Item> inventory;
	private final int MAX_HEALTH = 100;

	/** Method Entity
	 * Constructor
	 * 
	 * @param name - String representing the entity name
	 */
	public Entity(String name) {
		this.name = name;
		inventory = new ArrayList<Item>();
		healthPoints = MAX_HEALTH;
	}

	public Entity() {
		// TODO Auto-generated constructor stub
	}

	/** Method getName
	 * gets the name of the entity
	 * 
	 * @param none
	 * @return String - the name of the entity
	 */
	public String getName() {
		return name;
	}

	/** Method getHealthPoints
	 * gets the health points of the entity
	 * 
	 * @param none
	 * @return int - the health points of the entity
	 */
	public int getHealthPoints() {
		return healthPoints;
	}

	/** Method addItem
	 * adds an item to an entity
	 * 
	 * @param Item - the item to be added
	 * @return void
	 */
	public void addItem(Item item) {
		inventory.add(item);
	}

	/** Method removeItem
	 * removes an item from an entity
	 * 
	 * @param Item - the item to be removed
	 * @return void
	 */
	public void removeItem(Item item) {
		inventory.remove(item);
	}

	/** Method isItemAvailable
	 * determines if an item is in the entity inventory
	 * 
	 * @param Item - the item to be checked
	 * @return boolean - true if there, false if not
	 */
	public boolean isItemAvailable(Item item) {
		if (inventory.contains(item)) {
			return true;
		} else {
			return false;
		}
	}

	/** Method takeDamage
	 * tracks damage an entity takes
	 * 
	 * @param int - amount of damage taken
	 * @return void
	 */
	public void takeDamage(int hit) {
		healthPoints -= hit;
	}

	/** Method takeHealing
	 * tracks healing for an entity
	 * 
	 * @param int - amount of healing received
	 * @return void
	 */
	public void takeHealing(int heal) {
		healthPoints += heal;
	}

	@Override
	/** Method toString
	 * formats a String with the entity name and items associated with entity
	 * 
	 * @param none
	 * @return void
	 */
	public String toString() {
		String items = name + " with " + healthPoints + " of health has the following items: \n";
		for (Item i : inventory) {
			items = items + i.toString() + "\n";
		}
		return items;
	}

	/** Method abstract getGreeting
	 * provides method contract for character greeting
	 * Must be implemented by inheriting classes
	 * 
	 * @param none
	 * @return String - will be the greeting for the character
	 */
	public abstract String getGreeting();
}
