package sorts;
/**Class: LinearSearch
* @author Rick Price
* @version 1.0
* Course : ITEC 2140 Summer 2018
* Written: July 8, 2018
*
*
* This class Implements linear search for integers
*
* Purpose: Demonstrate a linear search
*/

public class LinearSearch
{
	private int[] sortArray;
	
	/** Method: LinearSearch
	 * Constructor for the LinearSearch class 
	 * @param int[] list to search 
	 */
	public LinearSearch(int[] inArray)
	{
		sortArray = new int[inArray.length];
		for (int index = 0; index < inArray.length; index++)
		{
			sortArray[index] = inArray[index];
		}
	}
	
	/** Method: search
	 * Code implementing the linear search
	 * @param int the value to find 
	 * @return int the number of times the algorithm executed
	 */
	public int search(int value)
	{
		int count = 0;
		int index;
		for (index = 0; index < sortArray.length; index++)
		{
			count++;
			if (sortArray[index] == value)
			{
				return count;
			}
		}
		
		return -count;
	}

	/** Method: search
	 * Code implementing the linear search
	 * @param int the value to find 
	 * @param int[] containing the list to be searched
	 * @return int the number of times the algorithm executed
	 */
	public int search(int value, int[] inArray)
	{
		sortArray = inArray;
		int count = 0;
		int index;
		for (index = 0; index < sortArray.length; index++)
		{
			count++;
			if (sortArray[index] == value)
			{
				return count;
			}
		}
		return -count;
	}

}
