import java.util.Scanner;

public class QuestionThree {
    public static void main(String args[]) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please type a sentence: ");
        String senOne = userInput.next();
        System.out.println("Please type a sentence: ");
        String senTwo = userInput.next();

        System.out.println(sameSize(senOne, senTwo));
    }
    public static boolean sameSize(String first, String second) {
        if (first.length() == second.length()) {
            return true;
        } else {
            return false;
        }
    }
}
