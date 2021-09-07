import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class kkkCapitalQuizTest
{

    CapitolQuiz quiz = new CapitolQuiz();
    String[][] stateCapitals;
    @Before
    public void setUP() throws Exception{
        quiz.generateQuiz();
        stateCapitals = quiz.createReferenceArray();
    }

    @Test
    public void randomizeList(){
        //should print a randomized list of 0-49
        System.out.println(quiz.getQuizArray().toString());
    }

    @Test
    public void getFiveAnswers(){
        ArrayList answers = quiz.getAnswers(3);
        Assert.assertEquals(5, answers.size());
    }

    @Test
    public void referenceArrayImputed(){
        //should not be null
        for (int i = 0; i < stateCapitals.length; i++)
        {
            System.out.print(stateCapitals[i][0] + ", " + stateCapitals[i][1]+" | ");
        }
        Assert.assertEquals(50, stateCapitals.length);
        Assert.assertEquals(2, stateCapitals[0].length);
    }

    @Test
    public void getState(){
        Assert.assertEquals(stateCapitals[quiz.getQuizArray().get(1)][0], quiz.getState(quiz.getQuizArray().get(1)));
    }

    @Test
    public void getCity(){
        Assert.assertEquals(stateCapitals[quiz.getQuizArray().get(1)][1], quiz.getCapitol(quiz.getQuizArray().get(1)));
    }
}
