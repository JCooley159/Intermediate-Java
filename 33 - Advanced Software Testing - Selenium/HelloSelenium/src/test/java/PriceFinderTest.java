import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PriceFinderTest
{
    private static WebDriver driver;
    private static ChromeOptions options;
    private static String itemName;
    private static final int DEFAULT_TIMEOUT = 300000;
    // 300000 milliseconds = 5 minutes

    @BeforeClass
    public static void loadIn()
    {

        options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("enable-popup-blocking");
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.setBinary("C:\\Users\\JCool\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JCool\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");



        Scanner scanner = new Scanner(System.in);
        boolean sentinel = true;
        while (sentinel)
        {
            System.out.println("\n\nHiya! Please type the name of the item you want me to search Amazon and Ebay for! (type \"quit\" to exit)\n\n");
            String itemName = "";
            while (itemName.equalsIgnoreCase(""))
            {
                itemName = scanner.nextLine();
            }

            if (itemName.equalsIgnoreCase("quit"))
            {
                sentinel = false;
            }
            else
            {
                findPriceOnAmazon(itemName);
                findPriceOnEbay(itemName);
            }

        }
        scanner.close();

    }





    @Test(timeout = DEFAULT_TIMEOUT)
    public void testFindPriceOnAmazon() throws org.openqa.selenium.NoSuchElementException
    {
        double price = findPriceOnAmazon(itemName);
        String priceStr = "$" + price + "";


        Assert.assertNotNull("Checks to make sure a price is found", priceStr);
    }

    private static double findPriceOnAmazon(String itemName)
    {
        driver = new ChromeDriver(options);
        setWindowToSide("left");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://smile.amazon.com/");
        double lowestPrice = 1000.0;
        String lowestPriceURL = null;



        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBar.sendKeys(itemName, Keys.ENTER);

        WebElement sortDropDown = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
        sortDropDown.click();
        WebElement sortLowToHigh = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_1\"]"));
        sortLowToHigh.click();


        for (int i = 0; i <= 3; i++)
        {
                switch(i)
                {
                        case 1 :
                            WebElement usedAndNewLink1 = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[3]/div/div[3]/div/a"));
                            usedAndNewLink1.click();
                        case 2 :
                            WebElement usedAndNewLink2 = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div[3]/div/a"));
                            usedAndNewLink2.click();                                   //    ^-----    The difference in XPaths is HERE
                        case 3 :
                            WebElement usedAndNewLink3 = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[3]/div/div/div/div[2]/div[3]/div/div[3]/div/a"));
                            usedAndNewLink3.click();
                }

                WebElement firstPrice = driver.findElement(By.xpath("//*[@id=\"olpOfferList\"]/div/div/div[2]/div[1]/span"));
                String firstPriceText = firstPrice.getText().trim().substring(1);
                double firstPriceDouble = Double.valueOf(firstPriceText);

                if (firstPriceDouble < lowestPrice)
                {
                        lowestPrice = firstPriceDouble;
                        lowestPriceURL = driver.getCurrentUrl();
                }

                driver.navigate().back();
        }

        if (lowestPriceURL != null)
        {
                driver.get(lowestPriceURL);
        }

        System.out.println("The cheapest price of the first three elements on Amazon is: \n\n$" + lowestPrice + "\n\n");
        return lowestPrice;
    }



    @Test(timeout = DEFAULT_TIMEOUT)
    public void testFindPriceOnEbay() throws org.openqa.selenium.NoSuchElementException
    {
        double price = findPriceOnEbay(itemName);
        String priceStr = "$" + price + "";

        Assert.assertNotNull("Checks to make sure a price is found", priceStr);
    }

    private static double findPriceOnEbay(String itemName)
        {
            driver = new ChromeDriver(options);
            setWindowToSide("right");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://ebay.com/");



            WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
            searchBar.sendKeys(itemName, Keys.ENTER);
    //        WebElement sortDropDown = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
            WebElement sortLowToHigh = driver.findElement(By.xpath("//*[@id=\"w12-w3\"]/div/div/ul/li[4]/a"));
            sortLowToHigh.click();

            double lowestPrice = 1000.0;
            WebElement pricePageLink = null;
            for (int i = 1; i <= 3; i++)
                {
                    WebElement priceWE;
                    String priceText;

                    if (i == 1)
                        {
                                                                                                //    v-----    The difference in XPaths is HERE
                            priceWE = driver.findElement(By.xpath("//*[@id=\"srp-river-results-listing1\"]/div/div[2]/div[3]/div[1]/span"));
                            priceText = priceWE.getText().trim().substring(1);
                            pricePageLink = driver.findElement(By.xpath("//*[@id=\"srp-river-results-listing1\"]/div/div[2]/a"));
                        }
                    else if (i == 2)
                        {
                            priceWE = driver.findElement(By.xpath("//*[@id=\"srp-river-results-listing2\"]/div/div[2]/div[3]/div[1]/span"));
                            priceText = priceWE.getText().trim().substring(1);
                        }
                    else
                        {
                            priceWE = driver.findElement(By.xpath("//*[@id=\"srp-river-results-listing3\"]/div/div[2]/div[3]/div[1]/span"));
                            priceText = priceWE.getText().trim().substring(1);
                        }

                    double priceDouble = Double.valueOf(priceText);

                    if (priceDouble < lowestPrice)
                        {
                            lowestPrice = priceDouble;
                        }

                }

            if (pricePageLink != null)
                {
                    pricePageLink.click();
                }

            System.out.println("The cheapest price of the first three elements on Ebay is: \n\n$" + lowestPrice + "\n\n");
            return lowestPrice;
        }



    private static void setWindowToSide(String leftOrRight)
    {
        //Maximise the window size to determine the height and width available
        driver.manage().window().maximize();

        //Retrieve the size of the maximised window as a dimension
        Dimension windowSize = driver.manage().window().getSize();

        //Determine the desired height and width of the window and store it as a dimension
        int desiredHeight = windowSize.height;
        int desiredWidth = windowSize.width/2;   //Half the screen width
        Dimension desiredSize = new Dimension(desiredWidth, desiredHeight);

        //Set the size of the window to the dimension determined above
        driver.manage().window().setSize(desiredSize);

        if (leftOrRight.equalsIgnoreCase("left"))
        {
            //Set the position of the window relative the upper left corner of the screen
            driver.manage().window().setPosition(new Point(0, 0));            //Left side of screen
        }
        else
        {
            //Set the position of the window relative the upper middle of the screen
            driver.manage().window().setPosition(new Point(desiredWidth, 0));  //Right side of screen
        }

    }




    @AfterClass
    public static void breakDown() { driver.close(); }


}
