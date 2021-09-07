public class Car extends Vehicle
{
    private boolean isConvertible;

    public Car(){}

    public Car(String make, String model, int year, boolean isFourWheelDrive, double price, int mpg, boolean isConvertible)
    {
        super(make, model, year, isFourWheelDrive, price, mpg);
        this.setConvertible(isConvertible);
    }

    public boolean isConvertible()
    {
        return isConvertible;
    }

    public void setConvertible(boolean convertible)
    {
        isConvertible = convertible;
    }

    @Override
    public void printVehicle()
    {
        super.printVehicle();
        if (isConvertible)
        {
            System.out.println("Is a Convertible");
        }
        else
        {
            System.out.println("Is NOT a Convertible");
        }
    }


}
