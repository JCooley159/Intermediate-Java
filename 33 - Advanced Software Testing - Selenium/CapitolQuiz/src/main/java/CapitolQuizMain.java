import java.util.Scanner;

public class CapitolQuizMain
{


    public static void main(String[] args)
    {
        CapitolQuiz quiz = new CapitolQuiz();



        boolean loopVar = true;
        do
        {
            quiz.generateQuiz();
            quiz.askQuestions();
            Scanner input = new Scanner(System.in);

            System.out.println("Would you like to play again? Y/N");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("N"))
            {
                loopVar = false;
                System.out.println("Okay! Thanks for playing!");
            }

        } while( loopVar );


    }





}