import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MyMathTest
{
    @Test
    public void testAddition()
    {
        // test adding 1 and 1
        // test with 1 positive num and 1 negative num
        // test with two negative nums
        //  "edge cases"

        // System.out.println(Integer.MAX_VALUE + 1);
        // System.out.println(Integer.MAX_VALUE + 1000);
        Assert.assertEquals("adding two positive numbers", 7, MyMath.add(1, 6));


        // Nothing is perfect, so at least just specify undefined behavior in the documentation
        // Dr. Im is hilarious and brings up undefined behaviors in Python 2/3 and Ruby
        // Asian countries hate the # 4, the Chinese love the number 8
        // People are irrational, and that makes developing software difficult!!!

        // Had a cool short discussion about Black Mirror: Bandersnatch; I need to try
        // jumping out the therapist's window
    }



}
