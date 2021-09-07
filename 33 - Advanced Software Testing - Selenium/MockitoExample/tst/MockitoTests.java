import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoTests
{
    @Test
    public void testMostExpensiveVehicle()
    {
        Dealership ggc = Mockito.mock(Dealership.class);
        Mockito.when(ggc.mostExpensiveCar()).thenReturn("Bugatti Veron");
        Assert.assertEquals("Bugatti Veron", ggc.mostExpensiveCar());
    }
}
