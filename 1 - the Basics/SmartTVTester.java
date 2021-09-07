import java.util.ArrayList;
import java.util.Scanner;


public class SmartTVTester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		SmartTV samsung = new SmartTV("Samsung", 1000.0);
		SmartTV lg = new SmartTV("LG", 10, 5, true, 900.0);
		SmartTV sony = new SmartTV("Sony", 800.0);
		
		ArrayList<SmartTV> tvList = new ArrayList<SmartTV>();
		tvList.add(samsung);
		tvList.add(lg);
		tvList.add(sony);
		
		System.out.println(Utilities.pickExpensive(tvList));
		
		SmartTV selected = null;
		System.out.println("1: Samsung, 2: LG, 3: Sony");
		System.out.print("Please select a TV that you are interested in:");
		int option = input.nextInt();
		if (option == 1){
			selected = samsung;
		}else if (option == 2){
			selected = lg;
		}else{
			selected = sony;
		}
		System.out.println(selected.toString());
		
		System.out.println("Please select one function you want to test:");
		System.out.println("1: turn on");
		System.out.println("2: turn off");
		System.out.println("3: volume up");
		System.out.println("4: volume down");
		System.out.println("5: channel up");
		System.out.println("7: channel down");
		
	    option = input.nextInt();
	    
	    if (option == 1){
	    		selected.turnOn();
	    }else if (option == 2){
	    		selected.turnOff();
	    } 
	    // please finish up 

	    System.out.println(selected.toString());


	}

}
