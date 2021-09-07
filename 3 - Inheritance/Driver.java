package inheritance;

public class Driver
{

    public static void main(String[] args)
    {
        Car car = new Car();
        Motorcycle motor = new Motorcycle();
        Trike trike = new Trike();
        SUV suv = new SUV();
        
        System.out.println(car.getWheels());//should print 4
        System.out.println(motor.getWheels());//should print 2
        System.out.println(trike.getWheels());
        System.out.println(suv.getWheels());

    }

}
