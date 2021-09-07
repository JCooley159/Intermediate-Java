import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class InClassFinalTest {

    private static WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 300000;  // 300000 milliseconds = 5 minutes

    @BeforeClass
    public static void loadIn()
    {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("enable-popup-blocking");
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.setBinary("C:\\Users\\JCool\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JCool\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }





    @Test(timeout = DEFAULT_TIMEOUT)
    public void testInClassITEC4260() throws org.openqa.selenium.NoSuchElementException
    {

        driver.get("https://ggc.gabest.usg.edu/pls/B400/twbkwbis.P_WWWLogin");

        WebElement userID = driver.findElement(By.xpath("//*[@id=\"UserID\"]"));
        userID.sendKeys("900106475");


        WebElement pin = driver.findElement(By.xpath("//*[@id=\"PIN\"]/input"));
        pin.sendKeys("052996", Keys.ENTER);


        WebElement studentAndFinAid = driver.findElement(By.xpath("/html/body/div[3]/table[2]/tbody/tr[3]/td[2]/a"));
        studentAndFinAid.click();


        WebElement viewStudentRecord = driver.findElement(By.xpath("/html/body/div[3]/table[1]/tbody/tr[4]/td[2]/a"));
        viewStudentRecord.click();


        WebElement midtermGrades = driver.findElement(By.xpath("/html/body/div[3]/table[1]/tbody/tr[7]/td[2]/a"));
        midtermGrades.click();


        WebElement termSelector = driver.findElement(By.xpath("//*[@id=\"term_id\"]"));
        termSelector.sendKeys("Spring 2019");


        WebElement submitBttn = driver.findElement(By.xpath("/html/body/div[3]/form/input"));
        submitBttn.click();


        boolean inClass = false;
        if(driver.getPageSource().contains("4260"))
        {
            inClass = true;
            System.out.println("Yep, I'm in ITEC 4260!");
        }


        Assert.assertTrue("Checks to make sure that the page of this semester's classes contains ITEC 4260", inClass);
    }


//    @AfterClass
//    public static void breakDown() { driver.close(); }

}
