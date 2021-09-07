import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;



/**Class: Aquarium
 * 
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: July 15, 2018
 *
 * This class – Contains a LinkedList of Fish
 */
public class Aquarium implements Iterable<Fish> {

	LinkedList<Fish> fishes;
	Iterator<Fish> iter = null;
	
	
	public Aquarium() {
		super();
		fishes = new LinkedList<Fish>();
		iter = fishes.iterator();
	}
	

	public Iterator<Fish> iterator() {
	     return new fishIterator();
	}

	
	public void addFish(Fish fishy)
	{
		fishes.add(fishy);
	}
	
	
	public void nextDay() /////////////////////next day for each fish////////////////
	{
			iter = fishes.iterator();
			while (iter.hasNext())////////////////steps thru iterator////////////////////
			{
				Fish f = iter.next();
				//////// three errors could possibly be produced separately //////
				////////     so is this the correct syntax???     ///////
				if (f.getCurrentAge() < f.getMaxAge()) 
				{
					/////////// Adds 1 to currentAge if currentAge is < maxAge /////////
					try 
					{
						f.setCurrentAge(f.getCurrentAge() + 1);						
					} 
					catch (FishNotValidException fnve) 
					{
						System.out.println(fnve.getLocalizedMessage());
					} 
					
					/////////// Adds 1 to daysInTank if currentAge is < maxAge /////////
					/// This way, the DaysInTank can't increase if the fish is already "dead" ////
					try 
					{
						f.setDaysInTank(f.getDaysInTank() + 1);						
					} 
					catch (FishNotValidException fnve) 
					{
						System.out.println(fnve.getLocalizedMessage());
					} 
					
				
				
				//////// Adds 1 inch to size every 30 days if fish is aggressive /////////
				///////// is the correct syntax because only one of these statements will run/produce an error?//////
					try 
					{
						if (f.isAggressive() && (f.getDaysInTank() % 30) == 0) 
						{
							f.setSize(f.getSize() + 1.00);
						} 
						else if (!f.isAggressive() && (f.getDaysInTank() % 30) == 0)
						{
							f.setSize(f.getSize() + 0.10);
						}
					}
					catch (FishNotValidException fnve) 
					{
						System.out.println(fnve.getLocalizedMessage());
					} 
				}		
			}   ///// end of WHILE loop ///////
	}   ///// end of nextDay() method ////////


	public ArrayList<Fish> getAllFish()
	{
		//////////////////// for some reason, I found that the problem is residing in this method
		/////////////// it refuses to add each fish to the array list
		/////////// maybe I need to make the iterator go in reverse order to go back thru all the fish?
		ArrayList<Fish> fishAL = new ArrayList<Fish>();
		while (iter.hasNext())
		{
			Fish f = iter.next();
			fishAL.add(f);			
		}
		return fishAL;
	}
	
	

				///////////////////////////////////////////////
			    private class fishIterator implements Iterator<Fish> 
			    {
			        private int cursor;

			        public fishIterator() {
			            this.cursor = 0;
			        }

			        public boolean hasNext() {
			            return this.cursor < Aquarium.this.fishes.size();
			        }

			        public Fish next() 
			        {
			        		if (fishes.isEmpty()) 
			        		{
			        			throw new NoSuchElementException();
			        		}
			        		return fishes.get(cursor++);
			        }

			    }
			    //////////////////////////////////////////////////
	
	
}
