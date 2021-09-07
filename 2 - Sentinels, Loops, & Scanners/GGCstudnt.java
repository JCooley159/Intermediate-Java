
public class GGCstudnt {

	private String name;
	private double age;
	private String major;
	
  
	public GGCstudnt() {
		name = "None";
		age = 0;
		major = "Unknown";
		
	} 
	
	public GGCstudnt(String n, double a, String m) {
	  this.name = n;
	  this.age = a;
	  this.major = m;
	}
	

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override  
	public String toString() {
		return "MyCircleClass [name: " + name + ", age:" + age + ", major: " + major +"]";
	}

	
		


}
