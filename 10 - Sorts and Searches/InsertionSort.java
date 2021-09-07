package sorts;

/**Class: InsertionSort
* @author Rick Price
* @version 1.0
* Course : ITEC 2140 Summer 2018
* Written: July 8, 2018
*
*
* This class Implementation of the Insertion Sort algorithm
* 
* Insertion sort works by assuming the previous items are already sorted.  Once you find an item that
* is less than the current number, insert the item.  Rest of items have been moved down.  Works through 
* the list forward in the other loop and backwards in the outer loop
*
* Purpose: Demonstrate insertion sort
*/

public class InsertionSort
{
	private int[] unsorted;

	/** Method: InsertionSort
	 * Constructor for InsertionSort demonstration
	 * @param int[] the array to be sorted
	 */
	public InsertionSort(int[] inArray)
	{
		unsorted = inArray;
	}
	
	/** Method: sort
	 * Public interface for InsertionSort
	 * @param none
	 * @return void
	 */
	public int[] sort()
	{
		for (int index = 1; index < unsorted.length; index++)
		{
			int curNum = unsorted[index];
			int inner = index;
			while (inner > 0 && unsorted[inner - 1] > curNum)
			{
				unsorted[inner] = unsorted[inner-1];
				inner--;
			}
			unsorted[inner] = curNum;
		}
		
		return unsorted;
	}

}
