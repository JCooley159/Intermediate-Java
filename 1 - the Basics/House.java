import java.util.ArrayList;

public class House {

	 private final String address = null;
	 private final int zip = 0;
	 private ArrayList<String> owners;
	 private final boolean basement = true;
	 private int price;
	 private String status;
	 
	 



	public House(String address, int zip, String NewOwner, boolean basement, int price, String status) {
	 	 this.address = address;
		 this.zip = zip;
		 owners.addOwners(NewOwner);
		 this.basement = basement;
		 this.price = price;
		 this.status = status;	 
	 }
	 
	 
	 
	 
	public String getStatus() {
		return status; 	}
	public void setStatus(String status) {
		this.status = status; 
		System.out.println("The status for this house has been set to:" + status);
	}
	
	
	public ArrayList<String> getOwners() {
		return owners;	}
	public void setOwners(ArrayList<String> owners) {
		this.owners = owners;	}
	public void addOwners(String NewOwner) {
		owners.add(NewOwner);
		System.out.println("A new owner, " NewOwner + " has been added for this house.");
	}
	
	public String getAddress() {
		return address; 	}
	public int getZip() {
		return zip; }	
	public boolean hasBasement() {
		return basement; }
	
	
	public int getPrice() {
		return price; }
	public void setPrice(int price) {
		this.price = price; 
		System.out.println("The price for this house has been set to:" + price);
	}

	
	
	
	
	
	
	
}
