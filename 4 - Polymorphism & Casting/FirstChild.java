package Polymorphism;
/**Class: FirstChild
* @author Rick Price
* @version 1.0
* Course : ITEC 2150 Summer 2018
* Written: June 2, 2018
*
*
* This class the first derived class for the classroom demonstration of polymorphism
*
* Purpose: Demonstrates polymorphism
*/

public class FirstChild extends BaseClass
{
	/** Method: getDescription
	 * FirstChild implementation of getDescription
	 * @param none
	 * @return String - the string specific to the FirstChild
	 */

   public String getDescription()
   {
     return "I am the oldest.";
   }
}
