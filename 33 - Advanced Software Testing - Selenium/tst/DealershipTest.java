import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class DealershipTest
{

    private Dealership dealership = new Dealership();
    private String url = "https://goo.gl/phaEbQ";


    @Before
    public void setUp() throws Exception
    {
        dealership = new Dealership();

        dealership.loadInventoryFromWeb(Dealership.url);
    }


    @Test
    public void testFindMostExpensive()
    {
        Assert.assertEquals("Bugatti Chiron", dealership.getInv().findMostExpensiveVehicle().getMakeModel());
    }

    @Test
    public void testFindCheapest()
    {
        Assert.assertEquals("Genesis G90", dealership.getInv().findCheapestVehicle().getMakeModel());
    }


    @Test
    public void testFindAverage()
    {
        Assert.assertEquals(495666.0, dealership.getInv().findAveragePriceOfAllVehicles(), 1);
    }

    @Test
    public void testLoadInventoryFromWeb() throws Exception
    {
        dealership.loadInventoryFromWeb(url);


        dealership.getInv().printSize();

        Vehicle expectedCheapest = new Vehicle("Genesis", "G90", 2017, 70000.0,false);
        Assert.assertEquals("The cheapest should be the Genesis G90", expectedCheapest, dealership.getInv().findCheapestVehicle());

        Vehicle expectedExpensivest = new Vehicle("Bugatti", "Chiron", 2017, 3000000.0,false);
        Assert.assertEquals("The most expensive should be the Bugatti Chiron", expectedExpensivest, dealership.getInv().findMostExpensiveVehicle());

        Assert.assertEquals("Average price", 495666, dealership.getInv().findAveragePriceOfAllVehicles(), 0.1);
        dealership.getInv().printAveragePriceOfAllVehicles();
    }


    @Test
    public void testStoreInventoryAsJSONFile() throws IOException {
        dealership.storeInventoryAsJSONFile();
        File file = new File("inventory.json");
        Assert.assertTrue("The createNewFile method should return false", !file.createNewFile());
    }


    @Test
    public void testLoadInventoryFromJSONFile() throws IOException {
        dealership.loadInventoryFromJSONFile();
        Assert.assertNotNull(dealership.getInv());
    }



}
