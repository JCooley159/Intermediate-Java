package sorts;

/**Class: myTimer
* @author Rick Price
* @version 1.0
* Course : ITEC 2140 Summer 2018
* Written: July 8, 2018
*
*
* This class Implementation of a stop watch class to be used to time sorting algorithms
*
* Purpose: Timer for sorting
*/

public class MyTimer
{
	private long start;
	private long end;

	/** Method: MyTimer
	 * Constructor for MyTimer class
	 * @param none
	 */
	public MyTimer()
	{
		reset();
	}
	
	/** Method: reset
	 * resets the variables in the MyTimer class
	 * @param none
	 * @return none
	 */
	public void reset()
	{
		start = 0;
		end = 0;
	}
	
	/** Method: startTimer
	 * starts the timer, records the start time
	 * @param none
	 * @return none
	 */
	public void startTimer()
	{
		start = System.currentTimeMillis();
	}
	
	/** Method: stop
	 * stops the timer, records the stop time
	 * @param none
	 * @return none
	 */
	public void stop()
	{
		end = System.currentTimeMillis();
	}
	
	/** Method: getElapsedTime
	 * Calculates how long the timer ran
	 * @param none
	 * @return long - the number of milliseconds the timer ran
	 */
	public long getElapsedTime()
	{
		return end - start;
	}
}
