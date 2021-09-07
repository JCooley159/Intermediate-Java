import org.junit.*;

public class SeleniumTest
{



    @Test
    public void pricelineTest()
    {
        driver.get("https://www.priceline.com/?tab=flights");
        WebElement from = driver.findElement(By.xpath("//*[@id=\"flight-departure-airport0\"]"));
        from.clear();
        from.sendKeys("Atlanta");


    }

}
