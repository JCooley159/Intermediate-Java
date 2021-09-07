import java.util.ArrayList;

public class ElectricCar extends FinalQ4CarShow {

	 private static String company;
	 private static String model;
	 private static int price;
	 private static int batteryLife;
	 private static String owner;
	 private static boolean warranty;
	 private static int year;
	 

	 public ElectricCar(); {
		 
	 }


	 public ElectricCar(String company, String model, int price, int batteryLife, String owner, boolean warranty, int year) {
		 this.company = company;
		 this.model = model;
		 this.price = price;
		 this.batteryLife = batteryLife;
		 this.owner = owner;
		 this.warranty = warranty;
		 this.year = year; 
	 }

	 public static String chargeBattery(ElectricCar e) {
		 batteryLife = e.getBatteryLife() + 25;
		 return "Battery is now at: " + batteryLife + "/100%. Let's drive!";
	 }
	 
	public String getCompany() {
		return company;
	}
	public String getModel() {
		return model;
	}
	public int getPrice() {
		return price;
	}
	public int getBatteryLife() {
		return batteryLife;
	}
	public String getOwner() {
		return owner;
	}
	public boolean isWarranty() {
		return warranty;
	}
	public int getYear() {
		return year;
	}
	
	
	public void setCompany(String company) {
		this.company = company;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setWarranty(boolean warranty) {
		this.warranty = warranty;
	}
	public void setYear(int year) {
		this.year = year;
	}
	 
	 
	 
	
	
	
	
}
