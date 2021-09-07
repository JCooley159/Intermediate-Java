import edu.ggc.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
    private Game g;

    @Before
    public void setUp() {
        g = new Game();
    }

    @Test
    public void testGutterGame() {
        int n = 20;
        int pins = 0;
        rollMany(n,pins);
        Assert.assertEquals(0,g.score());
    }
    @Test
    public void testAllOnes() {
        int n = 20;
        int pins = 1;
        rollMany(n,pins);
        Assert.assertEquals(20,g.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++)
            g.roll(pins);
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17,0);
        Assert.assertEquals(16,g.score());
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    @Test
    public void testOneStrike() {
        rollStrike(10);
        g.roll(3);
        g.roll(4);
        rollMany(16,0);
        Assert.assertEquals(24,g.score());
    }

    private void rollStrike(int pins) {
        g.roll(pins);
    }

    @Test
    public void testPerfectGame() {
        rollMany(12,10);
        Assert.assertEquals(300,g.score());
    }

    @Test
    public void testTwoSpares() {
        g.roll(7);
        g.roll(3);
        g.roll(5);
        g.roll(5);
        rollMany(16,0);
        Assert.assertEquals(25,g.score());
    }

    @Test
    public void testTwoStrikes() {
        g.roll(10);
        g.roll(0);
        g.roll(10);
        rollMany(17,0);
        Assert.assertEquals(30,g.score());
    }
}
