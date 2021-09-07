import org.jetbrains.annotations.NotNull;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class TravelocityTest
{


    private static WebDriver driver;
    private static ArrayList<String> destinations;
    private static ArrayList<Ticket> tickets;

    private static final int DEFAULT_TIMEOUT = 43200000;  // 43200000 milliseconds = twelve ( 12 ) Hours

    @BeforeClass
    public static void loadIn()
    {
        destinations = new ArrayList<String>();
        tickets = new ArrayList<Ticket>();
        ChromeOptions options = new ChromeOptions();
        FileWriter fw;

        ///////////////////////////////      JUST FOR TESTING
        destinations.add("Miami");
//        destinations.add("Cancun");
//        destinations.add("Las Vegas");
//        destinations.add("Denver");
//        destinations.add("Rome");
//        destinations.add("Milan");
//        destinations.add("Paris");
//        destinations.add("Madrid");
//        destinations.add("Amsterdam");
//        destinations.add("Singapore");

//        destinations.add("St. Thomas, U.S. Virgin Islands (STT-Cyril E. King)");
//        destinations.add("Tortola, British Virgin Islands (EIS-Terrance B. Lettsome Intl.)");
//        destinations.add("Spanish Town, British Virgin Islands (VIJ-Virgin Gorda)");
//        destinations.add("Anegada Island, British Virgin Islands (NGD-Auguste George)");
                             //////////////  No flights from ATL to NGD --  Need to Account for Null Case!  /////////
//        destinations.add("West End, Tortola, British Virgin Islands (TOV-All Airports)");
//        destinations.add("Christiansted, U.S. Virgin Islands (STX-Henry E. Rohlsen)");
//        destinations.add("Christiansted, U.S. Virgin Islands (SSB-St. Croix Seaplane Base)");
//        destinations.add("St. Thomas, U.S. Virgin Islands (SPB-St. Thomas Seaplane Base)");

//        destinations.add("San Juan, Puerto Rico (SJU-All Airports)");
//        destinations.add("Aguadilla, Puerto Rico (BQN-Rafael Hernandez)");
//        destinations.add("Ponce, Puerto Rico (PSE-Mercedita)");
//        destinations.add("Vieques, Puerto Rico (VQS-Antonio Rivera Rodriguez)");


        options.addArguments("disable-infobars");
        options.addArguments("disable-extensions");
        options.addArguments("enable-popup-blocking");
        options.addArguments("test-type");
        options.addArguments("start-maximized");


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JCool\\Downloads\\chromedriver_win32y\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaise\\Documents\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver(options);



        ///////////////      DESTINATION  LOOP        /////////////////////
        try
        {

            // Create an PrintWriter for file CheapestTickets.dat
            fw = new FileWriter("CheapestTickets - Miami.txt");


            for (String dest : destinations)
            {
                dateRangeLoop(dest, fw);
                //  Pass the destination and the FileWriter to dateRangeLoop() to
                //  find the cheapest Ticket, print it, and write it to the file.
            }


            // Close the FileWriter & Driver once each destination has a ticket
            fw.close();
//            driver.close();

        }
        catch (IOException e)
        {
            System.out.println("Problem saving ticket to file!");
        }


    }





    @Test (timeout = DEFAULT_TIMEOUT)
    public void testTicketsExist()
    {
        Assert.assertTrue("Checks to make sure the list of cheapest tickets is not empty", tickets.size() > 0);
    }

    @Test (timeout = DEFAULT_TIMEOUT)
    public void testEachDestinationHasTicket()
    {
        Assert.assertEquals("Tests to make sure a cheapest ticket is found for each destination. " +
                 "Automatically fails if the program never completes the loops through the destinations",
                 destinations.size(), tickets.size());
    }

    @Test (timeout = DEFAULT_TIMEOUT)
    public void testPrintTickets()
    {
        for ( Ticket t : tickets )
        {
            // Print the best destination Ticket to the console
            String str = "\n" + t.toString() + "\n";
            System.out.println(str);
        }
    }

    @Test (timeout = DEFAULT_TIMEOUT)
    public void testReadTicketsFromFile()
    {
        String result = readTicketsFromFile();
        Assert.assertEquals("Should return a string once it hits an error or all lines in the file have been read",
                "File printed to console!", result);
    }

    @NotNull
    private String readTicketsFromFile()
    {
        try
        {
            Scanner scan = new Scanner(new File("C:\\Users\\JCool\\Documents\\___GGC\\Soft Testing & QA\\HelloSelenium\\CheapestTickets.txt"));
            while (scan.hasNext())
            {
                System.out.println(scan.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            return "File Not Found!";
        }

        return "File printed to console!";
    }



    /**
     * @param dest              Destination for the Flight in question
     * @param fw                File Writer to record the cheapest Ticket with
     * @throws IOException      If the FileWriter cannot write the ticket for some reason.
     */
    private static void dateRangeLoop(String dest, FileWriter fw) throws IOException {
        //  currentCheapestPrice gets initialized as an unrealistically large number
        double currentCheapestPrice = 10000;
        double cheapestPrice = 9999;
        Ticket cheapestTicketForDest = new Ticket();



        ////////////////////////      MONTH LOOP        ////////////////////////
        for (int startMonth = 6; startMonth <= 8; startMonth++)
        {


            int monthMax;


            // sets the # of days in each month and thus, the day loop's # of iterations
//            if(startMonth == 5 || startMonth == 7) { monthMax = 31; }
            if(startMonth == 7) { monthMax = 31; }
            else { monthMax = 30; }



            /////////////////////       DAY LOOP        /////////////////////////
            for (int startDay =1; startDay <= monthMax; startDay++)
            {

                int endMonth;
                int endDay;
                if (startDay + 6 >= monthMax)
                {
                    endDay = (startDay + 6) - monthMax;
                    endMonth = startMonth + 1;
                }
                else
                {
                    endDay = startDay + 6;
                    endMonth = startMonth;
                }

                ///////// Break when the endDate is the 15th of August
                ///////// Set to the end of May for Testing
                if(endMonth == 8 && endDay == 12) { break; }


                ///////////////       Finds cheapest price for a given range        /////////////////////
                try
                {

                    cheapestPrice = getPriceForRange(dest, startMonth, startDay, endMonth, endDay);

                }
                catch (org.openqa.selenium.NoSuchElementException e)
                {
                    ///////////  Catches Element Timeout and Writes the last ticket to the File  ////////
                    String lastTicketStr = "\n\nThe dates I was looking for before I crashed were  " + startMonth + "/" + startDay + "/2019" +
                            "  to  " + endMonth + "/" + endDay + "/2019\n\n";

                    System.out.println( lastTicketStr );
                    fw.write( lastTicketStr );
                    // e.printStackTrace();
                }


                //////////////   Test to see if the price for the given range is cheaper than or equal to the currentCheapestPrice

                if (cheapestPrice <= currentCheapestPrice)
                {
                    currentCheapestPrice = cheapestPrice;

                    cheapestTicketForDest = new Ticket(dest, cheapestPrice, startMonth, startDay, endMonth, endDay);

                    System.out.println(
                            "Boo-yah! I found you a flight to  " + dest +
                            "  for $" + currentCheapestPrice +
                            "  from " + startMonth + "/" + startDay + "/2019" +
                            "  to  " + endMonth + "/" + endDay + "/2019");
                }



            } ///////////////       END of DAY LOOP              /////////////////////

        } ///////////////       END of MONTH LOOP            /////////////////////


        saveTicket(cheapestTicketForDest, fw);

    }


    /**
     * @param dest          Destination
     * @param startMonth    Start Month
     * @param startDay      Start Day
     * @param endMonth      End Month
     * @param endDay        End Day
     * @return              the Cheapest Price found for the given date range
     * @throws org.openqa.selenium.NoSuchElementException   Can time out and throw this exception if a web element is not found.
     */
    private static double getPriceForRange(String dest, int startMonth, int startDay, int endMonth, int endDay) throws org.openqa.selenium.NoSuchElementException, InterruptedException {

        //////////////////////////   Search  Travelocity  Once per Date Range   //////////////////////////////
        driver.get("https://www.travelocity.com/");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     // this is optional because of our while loops
        driver.manage().window().maximize();



        ////////////////////////////////////   Flights Tab   /////////////////////////////////////////
        WebElement airlineSelect = null;
        while (airlineSelect == null)
        {
            airlineSelect = driver.findElement(By.xpath("//*[@id=\"tab-flight-tab-hp\"]"));
        }
        if ( !airlineSelect.isSelected() )
        {
            airlineSelect.click();
        }




        ///////////////////////////////
        ////////////////////////////////////  From Atlanta  ////////////////////////////////////
        ///////////////////////////
        WebElement fromAirport = null;
        while (fromAirport == null)
        {
            fromAirport = driver.findElement(By.xpath("//*[@id=\"flight-origin-hp-flight\"]"));
        }


        fromAirport.click();
        driver.manage().window().maximize();
//        try
//        {
//            Thread.sleep(500);
//        } catch (InterruptedException ie) {}
        fromAirport.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        fromAirport.sendKeys("ATL");
        fromAirport.sendKeys(Keys.DOWN, Keys.ENTER);



        ///////////////////////////////
        ////////////////////////////////////  To Destination  ////////////////////////////////////
        ///////////////////////////
        WebElement toAirport = null;
        while (toAirport == null)
        {
            toAirport = driver.findElement(By.xpath("//*[@id=\"flight-destination-hp-flight\"]"));
        }

        toAirport.click();
//        try
//        {
//            Thread.sleep(500);
//        } catch (InterruptedException ie) {}
        toAirport.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        toAirport.sendKeys(dest);
        Thread.sleep(100);
        toAirport.sendKeys(Keys.DOWN, Keys.ENTER);



        ///////////////////////////////
        ////////////////////////////////////   Start Date   ////////////////////////////////////
        ///////////////////////////
        WebElement startDateInput = null;
        while (startDateInput == null)
        {
            startDateInput = driver.findElement(By.xpath("//*[@id=\"flight-departing-hp-flight\"]"));
        }
        startDateInput.click();
        startDateInput.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        startDateInput.sendKeys(startMonth + "/" + startDay + "/2019");




        ///////////////////////////////
        ////////////////////////////////////   End Date   ////////////////////////////////////
        ///////////////////////////
        WebElement endDayInput = null;
        while (endDayInput == null)
        {
            endDayInput = driver.findElement(By.xpath("//*[@id=\"flight-returning-hp-flight\"]"));
        }
        endDayInput.click();
        endDayInput.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        endDayInput.sendKeys(endMonth + "/" + endDay + "/2019");





        /////////////////////////////////   Find Search Button   ////////////////////////////////////////
        /////////////////////////////   Execute Search on First Page   ////////////////////////////////////
        ////////////////////   Attempt to Maximize Window after to Clear Popup   ///////////////////////////
        WebElement searchButton = null;
        while (searchButton == null)
        {
            searchButton = driver.findElement(By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[9]/label/button"));
        }
        searchButton.click();
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        try
//        {
//            Thread.sleep(500);
//        } catch (InterruptedException ie) {}


        /////////////////////////////////////
        //////////////////////////////////////////   Cheapest Price   ///////////////////////////////////
        ////////////////////////////////
        WebElement cheapestPriceWebElement = null;
        String cheapPrice;
//        double cheapPriceDouble = 1000000;      // Set at 1 Million so that if no flights are found, the "price" returned
//                                                // will almost always be greater than any other flight found so far.
        while (cheapestPriceWebElement == null)
        {

            try
            {
                Thread.sleep(5000);
                cheapestPriceWebElement = driver.findElement(By.xpath("//*[@id=\"stops\"]/div/label[1]/div/div[2]/div"));
            }
            catch (InterruptedException ie) {}
            catch (org.openqa.selenium.NoSuchElementException e)
            {
                WebElement noSuchFlight = null;
                try
                {
                    noSuchFlight = driver.findElement(By.xpath("no-flights-found-error"));
                }
                catch (org.openqa.selenium.NoSuchElementException nse)
                {
                    // Nothing is done here --> because the program can still hit this exception if the page is waiting
                    //   for the cheapestPriceElement, but doesn't find the No Flights Found Error.
                }


//                if (noSuchFlight != null) Sort Bar is Disabled
                return 1000000;
//                }
            }
//                {
            // Only returns 1 Million if the driver CANNOT find the cheapestPriceElement,
            // but CAN find the No Flights Found Error or finds that the

        }
        cheapPrice =  cheapestPriceWebElement.getText();
        cheapPrice = cheapPrice.replace("\n", "");
        cheapPrice = cheapPrice.replace(",", "");
        cheapPrice = cheapPrice.replace("$", "");


        return Double.valueOf(cheapPrice);

    }

    private static void saveTicket(@NotNull Ticket cheapestTicketForDest, @NotNull FileWriter fw) throws IOException
    {
        // The ticket is reassigned every time a better price is found, and is only added
        //  to the ArrayList of Tickets once the cheapest ticket for a destination is found.
        String str = "\n\n" + cheapestTicketForDest.toString() + "\n\n";

        // Write the Ticket to the .txt File
        fw.write(str);

        // Print the best destination Ticket to the console
        System.out.println(str);

        //  Add the Ticket to the ArrayList
        tickets.add(cheapestTicketForDest);
    }




    @AfterClass
    public static void breakDown() { driver.close(); }



}
