import java.util.ArrayList;

public class MainTest
{
    public static void main(String[] args)
    {
        ArrayList<Vehicle> vehicleAL = new ArrayList();

        Car car1 = new Car("Toyota", "Corolla", 2012, false, 12000.00, 30, false);
        vehicleAL.add(car1);

        Truck truck1 = new Truck("Ford", "F-150", 2010, true, 15000.00, 18, true, 20);
        vehicleAL.add(truck1);

        Vehicle vehicle1 = new Vehicle("Nissan", "Leaf", 2016, false, 20000.00, 45);
        vehicleAL.add(vehicle1);


        for (Vehicle v : vehicleAL)
        {
            v.printVehicle();
            System.out.println("");
        }






    }




}
