import java.util.Scanner;
import java.lang.Iterable;

public class Apr9InClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[][] distances = {
				{0, 983, 787, 714, 1375, 967, 1087}, 
				{983, 0, 214, 1102, 1763, 1723, 1842}, 
				{787, 214, 0, 888, 1549, 1548, 1627}, 
				{714, 1102, 888, 0, 661, 781, 810}, 
				{1375, 1763, 1549, 661, 0, 1426, 1187}, 
				{967, 1723, 1548, 781, 1426, 0, 239}, 
				{1087, 1842, 1627, 810, 1187, 239, 0},
		};

		String [] cities = {"Chicago", "New York", "Atlanta", "L.A.", "Orlando", "Detroit", "Nashville"};
		
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your two cities to find the mileage between the two:");
		String city1 = input.next();
		String city2 = input.next(); 
		
		if cities.equals(city1) {
			boolean mask = new boolean[7] cities.equals(city1);
			double i = cities[mask];	
		}
		
		*/
		
		
		for (int i = 0; i <= distances.length; i++) {
			
			for (int j = 0; j <= distances[i].length; j++) {
				System.out.println("The distance between " + cities[i] + " and " + cities[j] + " is " + distances[i][j] + " miles.");
				
				double avg = avg + distances[i][j]
						
				if (distances[i][j] >= distances[i][j-1] ) {
					double max = distances[i][j];
				}
				
				
				
			}
		}
		System.out.println(avg);
		System.out.println(max);
		
		
	}

}
