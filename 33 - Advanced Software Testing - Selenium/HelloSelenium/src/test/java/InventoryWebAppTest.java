import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;

public class InventoryWebAppTest
{


    private static WebDriver driver;
    private static ArrayList<String> items;
    private static final int DEFAULT_TIMEOUT = 43200000;  // 43200000 milliseconds = twelve ( 12 ) Hours

    @BeforeClass
    public static void loadIn()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JCool\\Downloads\\chromedriver_win32y\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaise\\Documents\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("enable-popup-blocking");
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://cupcakegram.jocelyn-rose.dev/");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     // this is optional because of our while loops
//        driver.manage().window().maximize();

        //  Click "Enter If Ye Dare, Arrrgh"
        WebElement enterIfYeDare = driver.findElement(By.className("signIn"));
        enterIfYeDare.click();

        //  Click "Forgot Password"
        WebElement forgotPassword = null;
        while (forgotPassword == null)
        {
            try
            {
                // Heads up, this one is being annoying
                forgotPassword =driver.findElement(By.xpath("/html/body/div/div[2]/form/a"));
            }
            catch (NoSuchElementException nse)
            {
                nse.getMessage();
            }
        }
        forgotPassword.click();

        //  Click Inventory Nav Button
        WebElement inventoryNavButton = driver.findElement(By.xpath("/html/body/nav/li[2]/a"));
        inventoryNavButton.click();

    }


//    @AfterClass
//    public static void breakDown() { driver.close(); }

    @Test
    public void testFindRoom()
    {

    }

    @Test
    public void testFindInventoryItem()
    {

    }

    @Test
    public void testFindQuantity()
    {

    }


}