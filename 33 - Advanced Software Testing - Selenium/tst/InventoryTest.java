import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InventoryTest
{
    private Inventory inv = null;

    @BeforeClass
    public static void connectToDatabase()
    {
        System.out.println("Connecting to database..... (runs only once!)");
    }




    @Before
    public void setUp()
    {
        System.out.println("Setting things up!");
        inv = new Inventory();
        Vehicle v1 = new Vehicle("toyota", "land cruiser", 2019, true, 10000, 5);
        inv.add(v1);
        Vehicle v2 = new Vehicle("bmw", "m4", 2019, true, 500000, 10);
        inv.add(v2);
        Vehicle v3 = new Vehicle("bentley", "420W", 2019, false, 2000000, 7);
        inv.add(v3);
    }


    @Test
    public void testAdd()
    {
        Vehicle v4 = new Vehicle("bentley", "M2020", 2020, false, 3000000, 7);
        inv.add(v4);
        Assert.assertEquals(4,inv.getSize());
    }


    @Test
    public void testRemove()
    {
        Vehicle v4 = new Vehicle("bentley", "M2020", 2020, false, 3000000, 7);
        inv.add(v4);
        inv.remove(v4);
        Assert.assertEquals( 3,inv.getSize() );
    }


    @Test
    public void testFindCheapestVehicle()
    {
        Vehicle cheapest = inv.findCheapestVehicle();
        Assert.assertEquals("toyota", cheapest.getMake());
        Assert.assertEquals("land cruiser", cheapest.getModel());
    }

    @Test
    public void testFindMostExpensiveVehicle()
    {
        Vehicle cheapest = inv.findMostExpensiveVehicle();
        Assert.assertEquals("bentley", cheapest.getMake());
        Assert.assertEquals("420W", cheapest.getModel());
    }


    @Test
    public void testFindAveragePriceOfAllVehicles()
    {
        double avg = (10000 + 500000 + 2000000) / 3.0;
        Assert.assertEquals(avg, inv.findAveragePriceOfAllVehicles(), 0.1);
    }



}
