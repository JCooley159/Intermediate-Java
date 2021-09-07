import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CapitalQuizTest
{
    private CapitolQuiz CapQuiz = new CapitolQuiz();
    private CapitolQuizMain CQM;
    private String[][] stateCapitals;

    @Before
    public void setUP() throws Exception{
        CapQuiz.generateQuiz();
        stateCapitals = CapQuiz.createReferenceArray();
    }

    @Test
    public void randomizeList(){
        //should print a randomized list of 0-49
        System.out.println(CapQuiz.getQuizArray().toString());
        System.out.println();
    }

    @Test
    public void getFiveAnswers(){
        ArrayList answers = CapQuiz.getAnswers(3);
        Assert.assertEquals(5, answers.size());
    }

    @Test
    public void referenceArrayImputed(){
        //should not be null
        for (int i = 0; i < stateCapitals.length; i++)
        {
            System.out.print(stateCapitals[i][0] + ", " + stateCapitals[i][1]+" | ");
        }
        System.out.println();
        Assert.assertEquals(50, stateCapitals.length);
        Assert.assertEquals(2, stateCapitals[0].length);
    }

    @Test
    public void getState(){
        Assert.assertEquals(stateCapitals[CapQuiz.getQuizArray().get(1)][0], CapQuiz.getState(CapQuiz.getQuizArray().get(1)));
    }

    @Test
    public void getCity(){
        Assert.assertEquals(stateCapitals[CapQuiz.getQuizArray().get(1)][1], CapQuiz.getCapitol(CapQuiz.getQuizArray().get(1)));
    }


//    Runs an infinite loop and does not take user input in the
//    testing framework. To run quiz, Use main method instead.
//
//    @Test
//    public void testTakeQuiz()
//    {
//        String[] args = null;
//        CQM.main(args);
//    }


}
