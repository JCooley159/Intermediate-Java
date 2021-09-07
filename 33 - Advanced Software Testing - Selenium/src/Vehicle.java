import java.io.Serializable;

/**
 * @author Jeremy Cooley
 *
 * Class: ITEC 4260 - Software Testing & QA
 *
 * Latest edit: 1/24/2019
 *  ------> changed printVehicle() to not print MPG if it == 0
 */
public class Vehicle implements Serializable
{

    private String make;
    private String model;
    private int year;
    private boolean isFourWheelDrive;
    private double price;
    private int mpg;


    public Vehicle(){}

    public Vehicle(String make, String model, int year, boolean isFourWheelDrive, double price, int mpg)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isFourWheelDrive = isFourWheelDrive;
        this.price = price;
        this.mpg = mpg;
    }

    public Vehicle(String make, String model, int year, double price, boolean isFourWheelDrive)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isFourWheelDrive = isFourWheelDrive;
        this.mpg = 0;
    }


    public String getMake()
    {
        return make;
    }
    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model = model;
    }

    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }

    public boolean isFourWheelDrive()
    {
        return isFourWheelDrive;
    }
    public void setFourWheelDrive(boolean fourWheelDrive)
    {
        isFourWheelDrive = fourWheelDrive;
    }

    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getMpg()
    {
        return mpg;
    }
    public void setMpg(int mpg)
    {
        this.mpg = mpg;
    }

    public void printVehicle()
    {
        System.out.println(make + ", " + model + ", " + year);
        if (isFourWheelDrive)
        {
            System.out.println("is 4WD");
        }
        else
        {
            System.out.println("is not 4WD");
        }
        System.out.println("$" + price);

        if (mpg != 0)
        {
            System.out.println(mpg + " MPG");
        }
    }

    @Override
    public boolean equals(Object o)
    {
        Vehicle vehicle = (Vehicle) o;
        if( this.year == vehicle.year &&
                this.isFourWheelDrive == vehicle.isFourWheelDrive &&
                Double.compare(vehicle.price, this.price) == 0 &&
                this.mpg == vehicle.mpg &&
                this.make.equals(vehicle.make) &&
                this.model.equals(vehicle.model) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getMakeModel()
    {
        return make + " " + model;
    }
}
