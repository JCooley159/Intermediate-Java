package inheritance;

public class Motorcycle extends Vehicle
{
    public Motorcycle()
    {
        super();
        setWheels(2);
    }

    public static void main(String[] args)
    {
       Motorcycle motor = new Motorcycle();
       System.out.println(motor.getWheels());

    }
    
    public int getWheels()
    {
        System.out.println("Wheels are spoked.");
        return super.getWheels();
    }
    
    public void setWheels(int wheels)
    {
        super.setWheels(wheels);
    }

}
