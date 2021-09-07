package sorts;

/**Class: SelectionSort
* @author Rick Price
* @version 1.0
* Course : ITEC 2140 Summer 2018
* Written: July 8, 2018
*
*
* This class Implementation of the Selection Sort algorithm
*
* Purpose: Demonstrate selection sort
*/

public class SelectionSort
{
	private int[] sortArray;

	/** Method: SelectionSort
	 * Constructor for SelectionSort demonstration
	 * @param int[] the array to be sorted
	 */
	public SelectionSort(int[] inArray)
	{
		sortArray = inArray;
	}
	
	/** Method: sort
	 * Public interface for SelectionSort
	 * @param none
	 * @return void
	 */
	public int[] sort()
	{
		for (int outer = 0; outer < sortArray.length - 1; outer++)
		{
			int min = outer;
			for (int inner = outer + 1; inner < sortArray.length; inner++)
			{
				if (sortArray[inner] < sortArray[min])
				{
					min = inner;
				}

			}
			changeNum(min, outer);
		}
		return sortArray;
	}
	
	/** Method: changeNum
	 * private method for changing the order of the elements
	 * @param int min - the index of the lower number
	 * @param int index - the index of the higher number
	 * @return none
	 */
	private void changeNum(int min, int index)
	{
		int temp = sortArray[min];
		sortArray[min] = sortArray[index];
		sortArray[index] = temp;
	}

}
