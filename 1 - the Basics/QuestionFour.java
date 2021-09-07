
import java.util.Scanner;

public class QuestionFour {
    public static void main(String args[]) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is your age? ");
        int age = userInput.nextInt();

        if(checkTwenty(age)){
        		System.out.println("Your are older than 20");
        }else{
        		System.out.println("You are not older than 20");
        }

    }
    public static boolean checkTwenty(int a){
        if (a > 20) {
            return true;
        } else {
            return false;
        }
    }
}
