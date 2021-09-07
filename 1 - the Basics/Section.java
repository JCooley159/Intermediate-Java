import java.util.ArrayList;

public class Section {

	private int secNum;
	private String instructor;
	private String room;
	@SuppressWarnings("unused")
	private ArrayList<Student> students;
	
	public Section() {
		this.secNum = 0;
		this.instructor = "not set";
		this.room = "not set";
		students = new ArrayList<Student>();
	}
	
	
	public Section(int secNum, String instructor, String room) throws Exception {
		this();
		setSecNum(secNum);
		setInstructor(instructor);
		setRoom(room);
	}


	public int getSecNum() {
		return secNum;
	}


	public void setSecNum(int secNum) throws Exception {
		if (secNum < 1 || secNum > 15) {
			throw new Exception("Invalid Section");
		}
		this.secNum = secNum;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) throws Exception {
		if (instructor.isEmpty()) {
			throw new Exception("Instructor cannot be blank");
		}
		this.instructor = instructor;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) throws Exception {
		if (room.isEmpty()) {
			throw new Exception("Room cannot be blank");
		}
		this.room = room;
	}

	public String toString()
	{
		String result = "Section\t\tInstructor\t\tRoom\n\n";
		result += secNum + "\t\t" + instructor + "\t\t" + room + "\n";
		
		result += "Name\t\tMajor\tGPA\tHours\n";
		
		for (Student stu : students)
		{
			result += stu.toString() + "\n";
		}
		return result;
	}
	
	
}
