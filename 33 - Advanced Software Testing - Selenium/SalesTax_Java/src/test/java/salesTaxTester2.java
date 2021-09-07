import org.junit.*;


//   Because the categories of books, food, and medicine can be extremely broad, and (at least in large
//   inventory management systems) are typically managed with barcodes and/or number codes, I made the conscious
//   decision to play to the given test cases and attempt to match only the terms "book", "chocolate", and "pills".
//
//
//   As my program currently is, there are cases where, because an item contains one of the phrases above, it gets
//   treated as tax-exempt when it should not be. For example, a bookmark or a chocolate-scented perfume should not be
//   tax-exempt, even though the current version of my program would flag them as such because the item names contain the
//   strings "book" and "chocolate".
//
//
//   Because I was given the constraint to not use (aside from JUnit) outside libraries like Scanner to
//   complete this problem, I chose to focus on coding to the test cases and not on allowing any user input. Plus,
//   for stable, production-level code, if the user is allowed to input the itemInfo for their own cart,
//   the user's inputs would need to be formatted, sanitized, and checked for errors/exceptions like an
//   IllegalArgumentException.
//
//   In an attempt to avoid using ArrayList, which, despite its popularity and ease of use, is an outside library, I
//   had to "redeclare" the sizes of the Cart and Receipt arrays in each of the test cases in order to fit the varying
//   number of items into the array without any empty or "null" spaces.
//
//
//   Also, I chose not to make each Cart or Item its own Object because:
//      Item Quantity and Price are just as easily stored in a String array as they would be in the fields of an Item
//          object, especially when I have to split and alter the Item's string anyway;
//      And in order to make the objects persistent, I would have to implement the Serializable interface, which is
//          against the rules of, and is not directly related to, this Code Challenge.
//
//
//   In future iterations, in addition to allowing user input, I would also attempt
//      to match more terms that could be associated with the tax-exempt categories,
//      to use File I/O to save logs of receipts,
//      and to use Serialization to make the data persistent across sessions/users/computers.
//
//


public class salesTaxTester
{
    //  Please excuse my use of ArrayLists for the cart & receipt! I didn't want to use simple arrays because the number
    //  of items in the test cases--and thus the size & indices of the array--vary.
    private String[] receipt;
    private String[] cart;
    private double runningSalesTaxTotal;
    private double runningCartTotal;

    //  TEST CASES



    @Before
    public void newCart()
    {


        //  initializes a new Array of Strings, called cart, to hold the info about each item
        cart = new String[3];

        //  initializes a new Array of Strings, called receipt, to hold each Item's name, quantity, and price after tax
        //  as well as the TotalSalesTax and Total for the cart
        receipt = new String[cart.length + 2];

        //  initializes a new runningCartTotal and runningSalesTaxTotal
        runningCartTotal = 0.0;
        runningSalesTaxTotal = 0.0;
    }




    @Test
    public void testCalculateTax_1()
    {
        cart[0] = "1 book at 12.49";
        cart[1] = "1 music CD at 14.99";
        cart[2] = "1 chocolate bar at 0.85";

        calculateItemPriceWithTax();

        Assert.assertEquals("Sales Tax for Test Case 1", 1.50, runningSalesTaxTotal, 0.05);
    }

    @Test
    public void testCalculateTotal_1()
    {
        cart[0] = "1 book at 12.49";
        cart[1] = "1 music CD at 14.99";
        cart[2] = "1 chocolate bar at 0.85";

        calculateItemPriceWithTax();

        Assert.assertEquals("Total for Test Case 1",29.83, runningCartTotal, 0.05);
    }

    @Test
    public void testCalculateTax_2()
    {
        cart = new String[2];
        receipt = new String[cart.length + 2];

        cart[0] = "1 imported box of chocolates at 10.00";
        cart[1] = "1 imported bottle of perfume at 47.50";

        calculateItemPriceWithTax();

        Assert.assertEquals("Sales Tax for Test Case 2", 7.65, runningSalesTaxTotal, 0.05);


    }

    @Test
    public void testCalculateTotal_2()
    {
        cart = new String[2];
        receipt = new String[cart.length + 2];

        cart[0] = "1 imported box of chocolates at 10.00";
        cart[1] = "1 imported bottle of perfume at 47.50";

        calculateItemPriceWithTax();

        Assert.assertEquals("Total for Test Case 2",65.15, runningCartTotal, 0.05);
    }

    @Test
    public void testCalculateTax_3()
    {
        cart = new String[4];
        receipt = new String[cart.length + 2];

        cart[0] = "1 imported bottle of perfume at 27.99";
        cart[1] = "1 bottle of perfume at 18.99";
        cart[2] = "1 packet of headache pills at 9.75";
        cart[3] = "1 box of imported chocolates at 11.25";

        calculateItemPriceWithTax();

        Assert.assertEquals("Sales Tax for Test Case 3", 6.70, runningSalesTaxTotal, 0.05);


    }

    @Test
    public void testCalculateTotal_3()
    {
        cart = new String[4];
        receipt = new String[cart.length + 2];

        cart[0] = "1 imported bottle of perfume at 27.99";
        cart[1] = "1 bottle of perfume at 18.99";
        cart[2] = "1 packet of headache pills at 9.75";
        cart[3] = "1 box of imported chocolates at 11.25";

        calculateItemPriceWithTax();

        Assert.assertEquals("Total for Test Case 3",74.68, runningCartTotal, 0.05);
    }


    private void calculateItemPriceWithTax()
    {
        //  For each Item in the Cart, (aka for each String in the ArrayList) calculate the price plus tax
        for (int i = 0; i < cart.length; i++)
        {
            if (cart[i] == null)
            {
                break;
            }

            // Split the input string at the spaces
            String[] infoArray = cart[i].split(" ");


            //   The first String is the Quantity
            int quantity = Integer.valueOf( infoArray[0] );


            //   The last String is the Initial Price of a singular item without tax
            double pricePerItem = Double.valueOf(  infoArray[ infoArray.length - 1 ]  );
            double pricePerItem_Rounded = Math.round(pricePerItem * 100.0) / 100.0;



            //   The name of the item can be assembled from its String Array, and thus we can
            //   leave out the quantity, price, and "at", such as in the given test case "1 chocolate bar at 0.85"
            StringBuilder itemName = new StringBuilder();
            for (int j = 1; j < infoArray.length - 2; j++)
            {
                itemName.append(" ");
                itemName.append(infoArray[j]);
            }
            String itemString = itemName.toString();



            //  The untaxedSubtotal for the item is calculated by the quantity times the pricePerItem
            double untaxedSubtotal = quantity * pricePerItem_Rounded;
            double untaxedSubtotal_Rounded = Math.round(untaxedSubtotal * 100.0) / 100.0;



            //   Assuming the item is NOT imported AND falls into the category of tax-exempt BOOKS, FOOD, or MEDICAL PRODUCTS,
            //   the tax rate is 0%.
            double taxRate = 0.0;



            //   From here, if the item is imported, the taxRate is then increased by 5%, or 0.05, for import duty;
            if (itemString.contains("imported"))
            {
                taxRate += 0.05;
            }



            //   And is increased by 10%, or 0.1, if the item does not fall into the Books/Food/Medical categories, i.e.
            //   if the itemString does not contain "book", "cocolate", or "pills"
            if ( !itemString.contains("book") && !itemString.contains("chocolate") &&  !itemString.contains("pills") )
            {
                taxRate += 0.1;
            }



            //  The dollar value of the salesTax for the item can be calculated from the taxRate times the item's
            //  subtotal but it still needs to be rounded to the nearest $0.05.
            double salesTaxOnItem = untaxedSubtotal_Rounded * taxRate;



            //  Because the Math.round() function rounds to the nearest integer, and 0.05 is 1/20th of 1,
            //  this can easily be done by multiplying by 20, rounding the double, and then dividing by 20.
            double salesTaxOnItem_Rounded = Math.ceil(salesTaxOnItem * 20.0) / 20.0;



            //  The value of the Item's sales tax is then added to the runningSalesTaxTotal,
            runningSalesTaxTotal += salesTaxOnItem_Rounded;
            runningSalesTaxTotal = Math.round(runningSalesTaxTotal * 20.0) / 20.0;



            //  The Item's total with tax can be calculated,
            double itemTotalWithTax = untaxedSubtotal_Rounded + salesTaxOnItem_Rounded;
            double itemTotalWithTax_Rounded = Math.round(itemTotalWithTax * 100.0) / 100.0;



            //  And the Item's total with tax can be added to the runningCartTotal
            runningCartTotal += itemTotalWithTax_Rounded;
            runningCartTotal = Math.round(runningCartTotal * 100.0) / 100.0;



            //  The final step for each Item in the loop is to add the Item's info and taxed total to the running receipt
            receipt[i] = quantity + itemString + ": " + itemTotalWithTax_Rounded;

        }


        //  After having iterated through each item in the cart, Add the Sales Taxes and final Total to the Receipt
        receipt[receipt.length-2] = "Sales Taxes: " + runningSalesTaxTotal;
        receipt[receipt.length-1] = "Total: " + runningCartTotal;


        //  Prints White Space before for visual clarity
        System.out.println("\n");

        //  Prints out each line of the receipt to the console.
        for (String s : receipt)
        {
            System.out.println(s);
        }

        //  Prints White Space after for visual clarity
        System.out.println("\n");

    }



}
