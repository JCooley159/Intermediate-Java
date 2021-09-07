/**
 * @author Jeremy Cooley
 *
 * Class: ITEC 4260 - Software Testing & QA
 *
 * Latest edit: 1/24/2019
 */



import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;


public class Inventory implements Serializable
{

    private ArrayList<Vehicle> vehicleInventory;



    public Inventory()
    {
        this.vehicleInventory = new ArrayList<Vehicle>();
    }
    public Inventory (ArrayList<Vehicle> vehicleInventory)
    {
        this.vehicleInventory = vehicleInventory;
    }




    public ArrayList<Vehicle> getVehicleInventory() {
        return vehicleInventory;
    }

    public void add(Vehicle v)
    {
        vehicleInventory.add(v);
    }
    public void remove(Vehicle v)
    {
        vehicleInventory.remove(v);
    }

    public Vehicle findCheapestVehicle()
    {
        Vehicle cheapest = new Vehicle("", "", 0, false, MAX_VALUE, 0 );
        for (Vehicle v : vehicleInventory)
        {
            if (v.getPrice() < cheapest.getPrice())
            {
                cheapest = v;
            }
        }
        return cheapest;
    }
    public void printCheapestVehicle()
    {
        System.out.println( findCheapestVehicle() );
    }



    public Vehicle findMostExpensiveVehicle()
    {
        Vehicle expensivest = new Vehicle("", "", 0, false, MIN_VALUE, 0 );
        for (Vehicle v : vehicleInventory)
        {
            if (v.getPrice() > expensivest.getPrice())
            {
                expensivest = v;
            }
        }
        return expensivest;
    }
    public void printMostExpensiveVehicle()
    {
        System.out.println( findMostExpensiveVehicle() );
    }



    public double findAveragePriceOfAllVehicles()
    {
        double avg = 0.0;
        for (Vehicle v : vehicleInventory)
        {
            avg = avg + v.getPrice();
        }
        return avg / (vehicleInventory.size());
    }
    public void printAveragePriceOfAllVehicles()
    {
        System.out.println( findAveragePriceOfAllVehicles() );
    }



    public int getSize()
    {
        return vehicleInventory.size();
    }

    public void printSize()
    {
        System.out.println( "This inventory has " + getSize() + " vehicles in it.");
    }


    public void printInventory()
    {
        for (Vehicle v : vehicleInventory)
        {
            v.printVehicle();
        }
    }

}
