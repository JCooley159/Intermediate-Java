public class Truck extends Vehicle
{
    private boolean hasSideStep;
    private int towCapacity;

    public Truck(){}

    public Truck(String make, String model, int year, boolean isFourWheelDrive, double price, int mpg, boolean hasSideStep, int towCapacity)
    {
        super(make, model, year, isFourWheelDrive, price, mpg);
        this.hasSideStep = hasSideStep;
        this.towCapacity = towCapacity;
    }

    @Override
    public void printVehicle()
    {
        super.printVehicle();
        if (hasSideStep)
        {
            System.out.println("Has a side step");
        }
        else
        {
            System.out.println("Has no side step");
        }
        System.out.println("Tows up to " + towCapacity + " tons");
    }

    public boolean isHasSideStep()
    {
        return hasSideStep;
    }

    public void setHasSideStep(boolean hasSideStep)
    {
        this.hasSideStep = hasSideStep;
    }

    public int getTowCapacity()
    {
        return towCapacity;
    }

    public void setTowCapacity(int towCapacity)
    {
        this.towCapacity = towCapacity;
    }
}
