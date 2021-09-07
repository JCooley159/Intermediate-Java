
public class GGCStudent {
	private String name;
	private int age;
	private String major;
	
	public GGCStudent(){
		name = "None";
		age = 0;
		major = "Unknown";
		
	}
	
	public GGCStudent(String name, int age, String major){
		this.name = name;
		this.age = age;
		this.major = major;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
		return "GGCStudent [name=" + name + ", age=" + age + ", major=" + major + "]";
	}
	
	
	

}
