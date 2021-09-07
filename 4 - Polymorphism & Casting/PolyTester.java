package Polymorphism;

import java.util.Random;

/**Class: PolyTester
* @author Rick Price
* @version 1.0
* Course : ITEC 2150 Summer 2018
* Written: June 2, 2018
*
*
* This class the driver class for the classroom demonstration of polymorphism
*
* Purpose: Demonstrates polymorphism
*/
public class PolyTester
{
	/** Method: main
	 * Entry point for polymorphism demonstration
	 * @param String[] args - command line arguments
	 * @return void
	 */
	
	public static void main(String[] args)
	{
		BaseClass[] bc = new BaseClass[21];
//		FirstChild[] fc = new FirstChild[7];
	//	SecondChild[] sc = new SecondChild[7];
		
		//initialize the classes
		int type = 0;
		Random rnd = new Random();
		for (int index = 0; index < 21; index++)
		{
			type = (rnd.nextInt(3));
			if (type == 0)
				bc[index] = new BaseClass();
			else if (type == 1)
				bc[index] = new FirstChild();
			else 
				bc[index] = new SecondChild();
		}
		//display the return from gettDescription
		for (int index = 0; index < 21; index++)
		{
			System.out.println((index + 1) + "   "  + bc[index].getDescription());
		}
		System.out.println(new SecondChild());
		BaseClass newBase = new BaseClass();
		
		if (newBase instanceof FirstChild)
		{
			FirstChild f = (FirstChild) newBase;
			System.out.println(f);
		}
		else
		{
			BaseClass f = new BaseClass();
			System.out.println(f);
		}
	}

}
