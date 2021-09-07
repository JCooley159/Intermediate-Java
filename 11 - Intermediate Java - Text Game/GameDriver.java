import java.util.Random;
import java.util.Scanner;


/** Class: GameDriver
 * 
 * @author JCool
 * @version 1.0
 * Course: ITEC 2150 Summer 2018
 * Written May 24, 2018
 * 
 * This class - interacts with the user and allows the user to enter data to assign to 
 * player and armor classes, as well as decide when they are ready to "enter the boss' 
 * room and start the fight.
 */
public class GameDriver {

	
	private static Scanner input = new Scanner(System.in);
	private static Armor frankArmor = new Armor("chainmail", 4, 75, "fireResistance");
	private static Player Frank = new Player("FRANK", "fighter", 90, frankArmor);
	private static Armor lizArmor = new Armor("robes", 1, 25, "LuckUP");
	private static Player Lizzie = new Player("LIZZIE", "mage", 40, lizArmor);
	private static Player[] playerArray = {Frank, Lizzie};
	
	/** Method: setName
	 * @param charNum - the position of the player in the player array
	 * @return player - the created player object with the entered fields
	 */
	public static Player CreatePlayer(int charNum) 
	{
		System.out.println("Start by describing the player's armor. Its Type:");
		String armorType = input.next();
		System.out.println("Armor Class: (1-5)");
		int armorClass = input.nextInt();
		System.out.println("Durability: (up to 100)");
		int durability = input.nextInt();
		System.out.println("and any Special Property it might have: (MakeSureItsOneWordLikeThis)");
		String sp_properties = input.next();
		Armor thisArmor = new Armor(armorType, armorClass, durability, sp_properties);
		
		
		
		System.out.println("Now, Please enter your player's name:");
		String name = input.next();
		System.out.println("Class:");
		String char_class = input.next();		
		System.out.println("and Starting Health:");
		int HP = input.nextInt();		
		playerArray[charNum] = new Player(name, char_class, HP, thisArmor);
		
		
		System.out.println("Wonderful!!! Now check to see that all of the info you've entered is correct:");
		System.out.println(playerArray[charNum].toString());
		return playerArray[charNum];
	}
	
	/** Method: getPlayerInfo
	 * @return player - the created player object with the entered fields
	 */
	public String getPlayerInfo() 
	{
		System.out.println("Choose which player's info you want to retrieve, 1 or 2.");
		int charNum = input.nextInt() - 1;
		Player thisPlayer = playerArray[charNum];
		return thisPlayer.toString();
	}
	
	/** Method: getArmorInfo
	 * @return player - the created player object with the entered fields
	 */
	public String getArmorInfo() 
	{
		System.out.println("Choose which player's armor information you want to retrieve, 1 or 2.");
		int charNum = input.nextInt() - 1;
		Player thisPlayer = playerArray[charNum];
		return thisPlayer.getArmor().toString();
	}
	
	/** Method: main
	 *  
	 * this method - interacts with the user and allows the user to enter data to assign 
	 * to player and armor classes, as well as decide when they are ready to "enter the boss' 
	 * room and start the fight.
	 */
	public static void main(String[] args) {
		
		
		System.out.println("Do you want to create a new character? (Y/N)");
		if (input.next().equalsIgnoreCase("Y")) {
			System.out.println("Great! This game starts with two preloaded characters, "
					+ "Which player do you want to replace? (1/2)");
			int charNum = input.nextInt() - 1;
			playerArray[charNum] = CreatePlayer(charNum);
			
			System.out.println("Do you want to create another character? (Y/N)");
			if (input.next().equalsIgnoreCase("Y")) {
				if (charNum == 0) {
					charNum++;
				} else if (charNum == 1) {
					charNum--;
				}
				playerArray[charNum] = CreatePlayer(charNum);
			}
		
		} else {
			System.out.println("Okay! Starting with Frank and Lizzie...");
		}
		
		
		
		
		
		System.out.println("If you've prepared and read all of your information, are you ready to head into the minotaur' lair?");
		System.out.println("Remember, you can't go back after this point. Y/N");
		String optionSentinel = input.next();
		if (optionSentinel.equalsIgnoreCase("N")) {
			return;
		}
		
		
		
		
		System.out.println("Which player should tank the minotaur' damage first, 1 or 2?");
		int charNum = input.nextInt() - 1;
		Player thisPlayer = playerArray[charNum];
		
		
		
		
		// iterates through until the first player is dead 
		
		while (thisPlayer.isAlive()) {
			
			Random rand = new Random();
			int generatedDmg = rand.nextInt(100) + 1;	
			
			if (generatedDmg >= 0 && generatedDmg <= 10) {
				System.out.print("The minotaur tries to punch you, but you barely dodge out of the way.");
			} else if (generatedDmg > 10 && generatedDmg <= 30) {
				System.out.print("The minotaur lands a deep cut into your thigh. You howl in pain!");
			} else if (generatedDmg > 30 && generatedDmg <= 50) {
				System.out.print("Your head connects with the back of the minotaur' axe. Blood clouds your vision.");
			} else if (generatedDmg > 50 && generatedDmg <= 70) {
				System.out.print("A burst of air escapes from your lungs as the minotaur violently knocks you down onto the floor!");
			} else if (generatedDmg > 70 && generatedDmg <= 90) {
				System.out.print("With an earsplitting roar, the minotaur rips one of your limbs off. 'Tis only a flesh wound!");
			} else if (generatedDmg > 90 && generatedDmg <= 100) {
				System.out.print("Summoning all its strength, the minotaur charges you, goring your intestines with its massive horns. You *might* just have blood in your stool later, if you even live, that is.");
			}
				
			System.out.println( thisPlayer.takeDamage(generatedDmg) );
			
			try {
				java.lang.Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		
		
		
		
		
		
		System.out.println("Oh no!!! " + thisPlayer.name + " is bleeding out on the floor!");
		
		if (charNum == 0) {
			charNum++;
			thisPlayer = playerArray[charNum];
		} else if (charNum == 1) {
			charNum--;
			thisPlayer = playerArray[charNum];
		}
		
		System.out.println("Now it's " + thisPlayer.name + "'s turn to fight... or just "
				+ "die like all the others.");
		
		
		
		
		
		
		
		// iterates through until the second player is dead
		
		while (thisPlayer.isAlive()) {
			
			int generatedDmg = (int) Math.floor(Math.random() * 100);			
			if (generatedDmg >= 0 && generatedDmg <= 10) {
				System.out.print("The minotaur tries to scratch you, but you barely dodge out of the way.");
			} else if (generatedDmg > 10 && generatedDmg <= 30) {
				System.out.print("The minotaur lands a deep cut into your thigh. You howl in pain!");
			} else if (generatedDmg > 30 && generatedDmg <= 50) {
				System.out.print("A burst of air escapes from your lungs as the minotaur violently knocks you down onto the floor!");
			} else if (generatedDmg > 50 && generatedDmg <= 70) {
				System.out.print("Blood is clouding your vision and you can only hope your armor is holding up...");
			} else if (generatedDmg > 70 && generatedDmg <= 90) {
				System.out.print("With an earsplitting roar, the minotaur rips one of your limbs off. 'Tis only a flesh wound!");
			} else if (generatedDmg > 90 && generatedDmg <= 100) {
				System.out.print("Summoning all its strength, the minotaur charges you, goring your intestines with its massive horns. You *might* just have blood in your stool later, if you even live, that is.");
			}
			
			System.out.println( thisPlayer.takeDamage(generatedDmg) );
			
			try {
				java.lang.Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} 
		
		
		
		
		// Prints a message to confirm the end of the battle 
		if (playerArray[0].getHP() <= 0 && playerArray[1].getHP() <= 0) {
			System.out.println("You tried so hard, and got so far; But in the end, it never even mattered. Maybe try adding a method to actually deal damage to the minotaur next time, loser. ;)");
		} else {
			System.out.println("Players not dead; there's a problem.");
		}
		
		
		
		
		
		// Allows the user to check if the fight was carried out correctly 
		System.out.println("Do you want to print the player and armor info one last time to check everything worked correctly? Y/N");
		optionSentinel = input.next();
		if (optionSentinel.equalsIgnoreCase("Y")) {
			playerArray[0].toString();
			playerArray[1].toString();
		} else {
			System.out.println("okay, bye <3");
		}
		
		
	}

}
