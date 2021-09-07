
public class Student {
	private String name;
	private String major;
	private double GPA;
	private int hours;
	
	public Student(String name, String major, double GPA, int hours) throws Exception {
		setName(name);
		setMajor(major);
		setGPA(GPA);
		setHours(hours);
	}
	
	
	

	public Student() {
		this.name = null;
		this.major = null;
		this.GPA = 0;
		this.hours = 0;
	}





	public String getName() 
	{
		return name;
	}

	public void setName(String name) throws Exception 
	{
		if (name.length() == 0) {
			throw new Exception("Name cannot be blank");
		}
		this.name = name;
	}

	public String getMajor() 
	{
		return major;
	}

	public void setMajor(String major) throws Exception 
	{
		if (major.length() == 0) {
			throw new Exception("Major cannot be blank");
		}
		this.major = major;
	}

	public double getGPA() 
	{
		return GPA;
	}

	public void setGPA(double GPA) throws Exception 
	{
		if (GPA < 0 || GPA > 4.0) {
			throw new Exception("GPA must be within 0 and 4.0");
		}
		this.GPA = GPA;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) throws Exception 
	{
		if (hours < 0 || hours > 17) {
			throw new Exception("Hours must be within 0 and 17");
		}
		this.hours = hours;
	}
	
	public String toString() 
	{
		return name + "\t\t" + major + "\t" + GPA + "\t" + hours;
	}
	
	
}



