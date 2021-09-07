
public class GGCStudentTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GGCStudent tom = new GGCStudent("Tom", 23, "IT");
		System.out.println(tom.toString());
		
		GGCStudent jane = new GGCStudent("Jane", 21, "Nurse");
		System.out.println(jane.toString());
		
		GGCStudent bob = new GGCStudent();
		System.out.println(bob.toString());
		bob.setName("Bob");
		bob.setAge(22);
		bob.setMajor("English");
		//please how bob object is changed
		System.out.println(bob.toString());
		
		
		

	}

}
