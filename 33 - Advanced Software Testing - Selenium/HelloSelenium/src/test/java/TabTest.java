import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class TabTest
{
    private static WebDriver driver;
    private static ChromeOptions options;
    private static final int DEFAULT_TIMEOUT = 43200000;  // 43200000 milliseconds = twelve ( 12 ) Hours

    @BeforeClass
    public static void loadIn()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JCool\\Downloads\\chromedriver_win32y\\chromedriver.exe");

        options = new ChromeOptions()
                .addArguments("enable-popup-blocking")
                .addArguments("disable-infobars")
                .addArguments("test-type");
        driver = new ChromeDriver(options);
    }

    @Test (timeout = DEFAULT_TIMEOUT)
    public void reloadTabForACause()
    {
        int count = 0;
        driver.get("https://tab.gladly.io/newtab/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        for (count = 0; count < 5; count++)
        {
            cycle();
        }
//            Set<String> AllWindowHandles = driver.getWindowHandles();
//            String window1 = (String) AllWindowHandles.toArray()[0];
//            System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
//            String window2 = (String) AllWindowHandles.toArray()[1];
//            System.out.print("\n\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);

            //Switch to window2(child window) and performing actions on it.
//            driver.switchTo().window(window2);
//
//            driver.switchTo().window(window1);

//            String newWindow = driver.getWindowHandle();



//        WebElement body = driver.findElement(By.cssSelector("body"));
//        for (int i = 0; i < 5; i++)
//        {
//            body.sendKeys(Keys.CONTROL+"t");
//            Actions builder = new Actions(driver);
//            Action clicker = builder
//                    .keyDown(Keys.CONTROL).sendKeys(Keys.TAB)
//                    .build();
//            clicker.perform();
//            body.sendKeys(Keys.CONTROL+"w");
//        }
        driver.close();
        Assert.assertEquals("checks that program runs X times.", 5, count);
    }

    private static void cycle()
    {
        // Email Login Button
        WebElement emailLoginButton = null;
        try {
            emailLoginButton = driver.findElement(By.xpath("//*[@id=\"firebaseui_container\"]/div/div[1]/form/ul/li[3]/button"));
            emailLoginButton.click();
        }
        catch (NoSuchElementException nse) { } //System.out.println(nse.getMessage()); }

        if (emailLoginButton != null)
        {
            // USERNAME
            driver.findElement(By.xpath("//*[@id=\"firebaseui_container\"]/div/form/div[2]/div/div[1]/input")).sendKeys("jcooley159@gmail.com", Keys.ENTER);

//                // Next Button
//            driver.findElement(By.xpath("//*[@id=\"firebaseui_container\"]/div/form/div[3]/div/button[2]")).click();

//                try { Thread.sleep(2000); } // Wait for that Password field
//                catch (InterruptedException ie) {System.out.println(ie.getMessage());}

            // PASSWORD
            WebElement password = null;
            while (password == null)
            {
                password = driver.findElement(By.xpath("//*[@id=\"firebaseui_container\"]/div/form/div[2]/div[3]/input"));
            }
            password.sendKeys("Seether159", Keys.ENTER);
            try { Thread.sleep(2500);} // Wait for that Heart Total
            catch (InterruptedException ie) { } //System.out.println(ie.getMessage());}
            
        }

        try { Thread.sleep(2500);
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);} // Wait for that Heart Total
        catch (InterruptedException ie) { } //System.out.println(ie.getMessage());}
        catch (NoSuchElementException e) { } //System.out.println(e.getMessage()); }
        catch (NoSuchWindowException nsw) { } //System.out.println(nsw.getMessage()); }
        driver.navigate().refresh();
    }

}