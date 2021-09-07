package sorts;
/**Class: BinarySearch
* @author Rick Price
* @version 1.0
* Course : ITEC 2140 Summer 2018
* Written: July 8, 2018
*
*
* This class Implements binary search for integers
*
* Purpose: Demonstrate a binary search
*/

public class BinarySearch
{
	private int[] sortArray;
	
	/** Method: BinarySearch
	 * Constructor for the BinarySearch class 
	 * @param Array of ints,  the list to search 
	 */
	public BinarySearch(int[] list)
	{
		sortArray = new int[list.length];
		for (int index = 0; index < list.length; index++)
		{
			sortArray[index] = list[index];
		}
	}

	/** Method: search
	 * Code implementing the binary search
	 * @param int the value to find 
	 * @return int the number of times the algorithm executed
	 */
	public int search(int value)
	{
		int count = 0;
		int mid = sortArray.length/2 + 1;
		int lowIndex = 0;
		int highIndex = sortArray.length -1;
		
		while(sortArray[mid] != value)
		{
			count++;
			if (value < sortArray[mid])
			{
				highIndex = mid - 1;
				mid = lowIndex + (highIndex - lowIndex)/2;
			}
			else if (value > sortArray[mid])
			{
				lowIndex = mid + 1;
				mid = lowIndex + (highIndex - lowIndex)/2 ;
			}
			if (mid == 0 && sortArray[mid] != value)
			{
				return -count;
			}
			if (mid == sortArray.length -1 && sortArray[mid] != value)
			{
				return -count;
			}
			if (lowIndex > highIndex)
			{
				return -count;
			}
		}
		
		return count;
	}

	/** Method: search
	 * Code implementing the binary search
	 * @param int the value to find 
	 * @return int the number of times the algorithm executed
	 */
	public int search(int value, int[] inArray)
	{
		sortArray = inArray;
		int count = 1;
		int mid = sortArray.length/2 - 1;
		int lowIndex = 0;
		int highIndex = sortArray.length -1;
		
		while(sortArray[mid] != value)
		{
			count++;
			if (value < sortArray[mid])
			{
				highIndex = mid - 1;
				mid = lowIndex + (highIndex - lowIndex)/2;
			}
			else if (value > sortArray[mid])
			{
				lowIndex = mid + 1;
				mid = lowIndex + (highIndex - lowIndex)/2;
			}
			if (mid == 0 && sortArray[mid] != value)
			{
				return -count;
			}
			if (mid == sortArray.length -1 && sortArray[mid] != value)
			{
				return -count;
			}
		}
		
		return count;
	}

}
