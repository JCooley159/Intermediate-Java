
/**Class: Armor
 * @author Jeremy Cooley
 * @version 1.0
 * Course: ITEC 2150 Summer 2018
 * Written May 24, 2018
 */
public class Armor {

	private int armorClass;
	private int durability;
	private String sp_properties;
	private String armorType;
	
	/** Constructor: Armor()
	 * 
	 * Default constructor that initializes standard fields of an armor instance
	 */
	public Armor() 
	{
		this.armorClass = 1;
		this.durability = 10;
		this.sp_properties = null;
		this.armorType = null;	
	}
	/** Constructor: Armor(String ArmType, int AC, int Dur, String Prop)
	 * 
	 * @param ArmType - the type or material of the armor
	 * @param AC - the rank, between 1-5, of the armor, which divides the damage
	 * @param Dur - the remaining durability of the armor
	 * @param Prop - any special properties the armor might have
	 */
	public Armor(String ArmType, int AC, int Dur, String Prop) 
	{
		this.armorType = ArmType;
		this.armorClass = AC;
		this.durability = Dur;
		this.sp_properties = Prop;
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int Durability) {
		durability = Durability;
	}
	public String getSp_properties() {
		return sp_properties;
	}
	public void setSp_properties(String sp_properties) {
		this.sp_properties = sp_properties;
	}
	public String getArmorType() {
		return armorType;
	}
	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}
	public String toString() {
		return " Armor Type: " + armorType + ", Armor Class: " + armorClass + ", Durability: " + durability + ", and Properties: " + sp_properties + ". \n";
	}
	
	/* Method: takeDamage
	 * 
	 * Allows an Armor object to take damage, divided by its armor class, and then 
	 * returns an int based on the remaining durability
	 * 
	 * Armor class levels:
	 * 1 - Takes full dmg
	 * 2 - Takes 1/2 dmg
	 * 3 - Takes 1/3 dmg	 
	 * 4 - Takes 1/4 dmg
	 * 5 - Takes 1/5 dmg
	 *
	 * @param imcomingDamage - the damage to be absorbed by the player's armor
	 * @return int - the remaining durability if > 0, if == 0, the armor is broken, 
	 * and if < 0, then the player takes the rest of the damage.
	 */
	
	public int takeDamage(int incomingDamage) 
	{
		
		int remDur = durability - (incomingDamage / armorClass);
		
		
		 if (durability > 0 && remDur == 0)            //armor takes all dmg but breaks
		{
			this.setDurability(0);
			return 0;
		} 
		 else if (durability > 0 && remDur > 0)       //armor takes all damage and doesn't break
		{
			this.setDurability(remDur);
			return remDur;
		} 
		else if (durability == 0 && remDur < 0)       //armor is already @ 0, full dmg comes thru
		{
			this.setDurability(0);
			return 0 - incomingDamage;
		}
		else if (durability > 0 && remDur < 0)        //armor starts above 0, but breaks, and some dmg comes thru unprotected
		{
			int remainingUnmitigatedDamage = remDur * armorClass;  //will be negative
			
			this.setDurability(0);
			return remainingUnmitigatedDamage;
		} else {
			return -1;
		}
		
	}
	
	
	
	
	
	
	
	
}
