package Polymorphism;
/**Class: SecondChild
* @author Rick Price
* @version 1.0
* Course : ITEC 2150 Summer 2018
* Written: June 2, 2018
*
*
* This class the second derived class for the classroom demonstration of polymorphism
*
* Purpose: Demonstrates polymorphism
*/

public class SecondChild extends BaseClass
{
	/** Method: getDescription
	 * SecondChild implementation of getDescription
	 * @param none
	 * @return String - the string specific to the SecondChild
	 */
   public String getDescription()
   {
      return "I am the second child.";
    }
}
