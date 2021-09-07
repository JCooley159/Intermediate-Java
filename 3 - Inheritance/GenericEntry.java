import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**Class: GenericEntry
 * 
 * @author Jeremy Cooley
 * @version 1.0
 * 
 * Course: ITEC 2150 Summer 2018
 * Last Updated: July 3, 2018
 *
 * This class - Allows the user to create an ArrayList of Player objects, and enter the name,
 * hit points, armor, PlayerClass, and weapon if a Fighter, and spell if a Wizard.
 */
public class GenericEntry  {

//	
	public GenericEntry() {
		
	}
//	
	
	
//	MAIN
	public static void main(String[] args) {
		
			String name = "";
			int HP = 0;
			String armor = "";
			String WeaponSpell = "";
			String classType = "";
			GenericEntry ge = new GenericEntry();
			
			
			System.out.println("Hello and Welcome to IC 6! Let's create some players.");
			System.out.println("How many players would you like to create? You'll need at least 3 to survive this dungeon.");
			Scanner input = new Scanner(System.in);
			int numPlayers = Integer.parseInt(input.nextLine());
			ArrayList<Player> playerAL = new ArrayList<>(numPlayers);
			System.out.println("Array created!");
				if (numPlayers < 3) 
				{
					numPlayers = 3;
					playerAL.ensureCapacity(numPlayers);
				} 
				else
				{
					playerAL.ensureCapacity(numPlayers);
				}
			
			
			
			
			
			
			for (int i= 0; i <= numPlayers - 1; i++) 
			{			
				int playerNum = i + 1;
				System.out.println("\nPlease enter player number " + playerNum + "'s Name.");
				name = input.nextLine();
				System.out.println("Please enter " + name + "'s HP.");
				HP = Integer.parseInt(input.nextLine());
				System.out.println("Please enter " + name + "'s armor.");
				armor = input.nextLine();
				
				
					try
					{
					//				WIZARD or FIGHTER			
								
								System.out.println("What class is " + name + "? Fighter or Wizard?");
								classType = input.nextLine();
								
								if (classType.equalsIgnoreCase("Wizard")) 
								{
											System.out.println("What is this Wizard's readied spell?");
											WeaponSpell = input.nextLine();
											Wizard plyr = new Wizard(name, HP, armor, WeaponSpell);
											playerAL.add(plyr);
											
			//								The alternative way of setting the spell, besides in the constructor:
			//								Player plyr = new Player(name, HP, armor);
			//								((Wizard) plyr).setSpell(spell);
								} 
								else if (classType.equalsIgnoreCase("Fighter")) 
								{						
											System.out.println("What is this Fighter's preferred weapon?");
											WeaponSpell = input.nextLine();
											Fighter plyr = new Fighter(name, HP, armor, WeaponSpell);
											playerAL.add(plyr);
								} 
								else
								{
											throw new IllegalArgumentException("Sorry, Fighter and Wizard are the only available classes right now.");							
								}
					
							// end of TRY block
					}
					catch (IllegalArgumentException iae)
					{
							System.out.println(iae.getMessage());
							classType = input.nextLine();
					}			
					
				
			}    // end of FOR loop
			
			
			
			
			
			
			System.out.println("All players entered!\n");
			System.out.println("Your party:");
			ge.GenericPrint(playerAL);
			System.out.println("Good luck as you venture forth!");
			input.close();
	}	// end of MAIN method
	
	
	
	
	
	

	
	
	/** Method: GenericPrint
	 * @param <T>
	 *  
	 *  @param al - the ArrayList<?> to be cycled thru and printed.
	 *  @return totalString - the String of each object in the array sewn 
	 *  	together with New Lines in between
	 */
	public <T> void GenericPrint(ArrayList<T> arraylist) 
	{
				
				Iterator<T> playerIterator = arraylist.iterator();
				
			      while(playerIterator.hasNext()) {
			         System.out.printf("%s\n", playerIterator.next().toString());
			      }
					
				
	}
	

}
