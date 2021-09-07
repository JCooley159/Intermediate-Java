import javax.swing.JOptionPane;
public class JOptPaneTest2 {

// So I'm gonna comment out your lines of code that are wrong and re-type them 
//	along with notes for you!

		 

//		public static void main(String) [] args {
//									  ^ a parenthesis in the wrong place will 
//										prevent your main method from ever running!
		public static void main(String[] args)	{


		//Declare variables
		String name;
//			   ^ variable names need to start with lowercase
		String noOfMonths;
		int months;
		int days;
		String message;

		 

		//Get the user's info

//		str Name = JOptionPane.showInputDialog ("Enter your name: ");
//		^ so because your variable "name" is already initialized, there is no 
//		  need to put "String" in front of it again when we are assigning the 
//		  String we get from showInputDialog() to the already existing field of 
//		  "name". Also, "str" is bad syntax in the first place.
		name = JOptionPane.showInputDialog("Enter your name: ");
		 

//		Str Message = JOptionPane.showInputDialog(<message>);
//													^ I don't understand why 
//				you're trying to prompt for the message instead of putting it
//				together after you get the name and months. Oh, and no < > are 
//				needed.
		 

		noOfMonths = JOptionPane.showInputDialog("How many months have you been programming?");
		 

//		int month = Integer.parseInt(monthStr);
		months = Integer.parseInt(noOfMonths);
//		^ this takes noOfMonths and converts it to an int so we can multiply it
		if (months < 1)
		{
			months = 1;
		}
//			  ^ this is to make sure that anything less than 1 gets treated as a 1 
		days = months *30;
//		 ^ this is to multiply the months by 30 to get the total # of days
		
		
		message = "Hello " + name + ". You have been programming for " + String.valueOf(days) +  " days";
//		   ^ This builds or concatenates the strings into a message that we can 
//			 then display with --v
		JOptionPane.showMessageDialog(null, message);
			
	}

}
