
public class FinalQ4CarShow{
	
	public static void main(String[] args) {

	ElectricCar joe = new ElectricCar("Toyota", "Prius", 150900, 75, "Joe Shmoe", true, 2014);
	ElectricCar jeremy = new ElectricCar("Nissan", "Leaf", 100000, 30, "Jeremy Cooley", true, 2016);
	ElectricCar gonna = new ElectricCar("Audi", "SmartCar", 90000, 45, "Gonna B. Dead", false, 2010);
	
	chargeBattery(joe);
	chargeBattery(jeremy);
	chargeBattery(gonna);
	
	}

	public static String chargeBattery(ElectricCar e) {
		 int batteryLife = e.getBatteryLife() + 25;
		 return "Battery is now at: " + batteryLife + "/100%. Let's drive!";
	 }
}
