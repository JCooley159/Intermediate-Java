import java.util.ArrayList;
import java.util.Scanner;

public class HW1_KitchenSink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Everything but the Kitchen Sink.");
		System.out.println("First let me ask how many days your upcoming vacation is, so we can pack accordingly:");
		short numDays = input.nextShort();
		
		System.out.println("Please enter a number according to what you would like to pack into your suitcase: ");
		System.out.println("1. Underwear \n2. Socks \n3. Changes of Clothes \n4. Sunscreen \n5. Bathing Suit \n6. Books \n7. Laptop \n8. Stuff everything down and zip the suitcase!");
		
		int optionSentinel = input.nextInt();		
		ArrayList<String> suitcase = new ArrayList<String>();
		
		while (optionSentinel != 8) {
		
			switch (optionSentinel) {
				case 1: suitcase.add("Underwear" + " x " + numDays);
					break;
				case 2: suitcase.add("Socks" + " x " + numDays*2);
					break;
				case 3: System.out.println("What season are you packing for? We don't want you to be too hot or too cold!");
					String season = input.next();
					suitcase.add("Changes of Clothes, " + season + " x " + numDays);
					break;
				case 4: System.out.println("What SPF would you like?");
					float spf = input.nextFloat();
					suitcase.add("Sunscreen, SPF " + spf);
					break;
				case 5: suitcase.add("Bathing Suit");
					break;
				case 6: System.out.println("I don't know how much of an avid reader you are; please enter the number of books you think you'll read on the trip.");
					long numBooks = input.nextLong();
					String[] bookArray = new String[(int) numBooks];
					System.out.println("Okay, go ahead and start typing the names of the books, separated by enters.");
					for (int i = 0; i < numBooks; i++) {
						String title = input.nextLine();
						bookArray[i] = title;
					}
					suitcase.add("Books: " + bookArray);
					break;
				case 7: suitcase.add("Laptop, charger, and wireless mouse");
					break;
					
			}
			
		
		}
		System.out.println(suitcase.toString());
		input.close();
		
	}

}
