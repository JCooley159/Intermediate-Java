import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CircleCreator {

	public static void main(String[] args) {
		

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of the function you want to perform: 1. Create a new Circle in an array list. 2. Print a toString list of your circles. "
				+ "3. Enter a list of names into an arraylist 4. Return the size of your list. 5. Sort your list of names descending alphabetically.");
		int optionSentinel = input.nextInt();
		ArrayList<MyCircleClass> circleArrayList = new ArrayList<MyCircleClass>();
		ArrayList<String> names = new ArrayList<String>();
		
		
		if (optionSentinel == 1) 
		{	
			System.out.println("What size?");
			double radius = input.nextDouble();
			System.out.println("What color?");
			String color = input.next();
			
			circleArrayList.add(new MyCircleClass(radius, color));
			
			System.out.println("Okey dokey, your " + color +" circle of radius" + radius + " has been created!");
			
		} 
		else if (optionSentinel == 2) 
		{
			for (int i = 0; i < circleArrayList.size(); i++) {
				if (circleArrayList != null) {
					System.out.println(circleArrayList.toString());
				}
			}
		} 
		else if (optionSentinel == 3) 
		{
			System.out.println("Okay, start typing names separated by a new line/enter. When you are finished, type 'stop'.");
			while (input.next() != "stop") 
			{
				names.add(input.next());
			}
		}
		else if (optionSentinel == 4) 
		{
			System.out.println(names.size());
		}
		/*
		else if (optionSentinel == 5) 
		{
			int n;
	        String temp;
	        Scanner s = new Scanner(System.in);
	        System.out.print("Enter number of names you want to enter:");
	        n = s.nextInt();
	        
	        Scanner s1 = new Scanner(System.in);
	        System.out.println("Enter all the names:");
	        for(int i = 0; i < n; i++)
	        {
	            names[i] = s1.nextLine();
	        }
	        for (int i = 0; i < n; i++) 
	        {
	            for (int j = i + 1; j < n; j++) 
	            {
	                if (names[i].compareTo(names[j])>0) 
	                {
	                    temp = names[i];
	                    names[i] = names[j];
	                    names[j] = temp;
	                }
	            }
	        }
	        System.out.print("Names in Sorted Order:");
	        for (int i = 0; i < n - 1; i++) 
	        {
	            System.out.print(names[i] + ",");
	        }
	        System.out.print(names[n - 1]);
		} */
		else 
		{
			System.out.println("Okay, bye bye! <3");
		}
		
		
		
	}

}
