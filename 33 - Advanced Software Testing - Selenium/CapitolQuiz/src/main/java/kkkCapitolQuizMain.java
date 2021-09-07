import java.util.Scanner;


public class kkkCapitolQuizMain
{
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        CapitolQuiz quiz = new CapitolQuiz();
        String repeat = "Y";
        do {
            quiz.generateQuiz();
            quiz.askQuestions();
            repeat = input.nextLine().toUpperCase();
        }
        while (!repeat.equals("N"));
    }
}

