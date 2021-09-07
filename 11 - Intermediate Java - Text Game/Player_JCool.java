
/**Class: Player
 * @author Jeremy Cooley
 * @version 1.0
 * Course: ITEC 2150 Summer 2018
 * Written May 24, 2018
 */
public class Player_JCool {

	
	String name;
	String char_class;
	int HP;
	Armor armor;
	
	/** Constructor: Player()
	 * Default constructor that initializes standard fields of a player instance
	 */
	public Player_JCool() 
	{
		this.name = "Fred";
		this.char_class = "Fighter";
		this.HP = 100;
		this.armor = new Armor();	
	}
	
	/** Constructor: Player(String name, String char_class, int HP)
	 * @param name - The name of the player
	 * @param char_class - the class of the character
	 * @param HP - the health of the character
	 */
	public Player_JCool(String name, String char_class, int HP) 
	{
		this.name = name;
		this.char_class = char_class;
		this.HP = HP;
		this.armor = new Armor();	
	}
	
	/** Constructor: Player(String name, String char_class, int HP, Armor armor)
	 * @param name
	 * @param char_class
	 * @param HP
	 * @param armor
	 */
	public Player_JCool(String name, String char_class, int HP, Armor armor) 
	{
		this.name = name;
		this.char_class = char_class;
		this.HP = HP;
		this.armor = armor;	
	}

	/** Method: getName
	 * @return name of the player
	 */
	public String getName() {
		return name;
	}
	/** Method: setName
	 * @param name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	/** Method: getChar_class
	 * @param class type of the player
	 */
	public String getChar_class() {
		return char_class;
	}
	/** Method: setChar_class
	 * @param char_class 
	 */
	public void setChar_class(String char_class) {
		this.char_class = char_class;
	}
	/** Method: getHP
	 * @return HP Player's HP 
	 */
	public int getHP() {
		return HP;
	}
	/** Method: setHP
	 *  @param HP
	 */
	public void setHP(int hp) {
		HP = hp;
	}
	/** Method:getArmor
	 *  @return armor 
	 */
	public Armor getArmor() {
		return armor;
	}
	/** Method: setArmor
	 *  @param armor;
	 */
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	/** Method: toString
	 * @return returns a String of the Player's name, class, HP, and armor 
	 */
	@Override
	public String toString() {
		return "Name: " + name + ", Character Class: " + char_class + ", HP: " + HP
				+ ". " + armor.toString();
	}
	
	/** Method: takeDamage
	 *  Allows the player to take damage, modified by the player's remaining armor
	 *  durability.
	 *  
	 *  If the damage would leave the durability above 0, then the armor takes the 
	 *  full hit.
	 *  If the damage would leave the durability at 0, then the player's armor breaks, 
	 *  and the player's HP takes the remaining damage, if any.
	 *  If the player's armor is already broken, then the player's HP takes the full hit
	 *  and the player dies if their HP reaches 0.
	 *  
	 *  @param incomingDamage - The damage the player is about to take
	 *  @return returnString
	 */
	public String takeDamage(int incomingDamage)
	{
		int remDmg = armor.takeDamage(incomingDamage);
				
		if (remDmg > 0) 
		{
			return "Your armor has " + remDmg + " durability left.";
		}
		else if (remDmg == 0) 
		{
			return "Your armor thankfully blocked all of the " + incomingDamage 
					+ " damage this turn, but it's broken now. " + name + "is at " 
					+ HP + " HP.";
		} 
		else if (remDmg < 0) 
		{	
			remDmg = 0 - remDmg;		
			HP = HP - remDmg;
			
			if (isAlive()) {
				return "Though " + name + "'s armor is broken, they're alive!"
						+ " They take " + remDmg + " direct damage, leaving them at " + 
						HP + " HP.";
			} else {
				return name + "'s armor is broken and so is their spirit. " + 
						name + " is dead. READY NEXT PLAYER.";
			}
			
		}
		return "Error\n\n";
		
		
	}

	/** Method: isAlive
	 *  Used to determine whether the plyer's HP is positive. If not, they are dead.
	 */
	public boolean isAlive() {
		if (HP > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
