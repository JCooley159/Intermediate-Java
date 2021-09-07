import java.util.Scanner;

public class SectionDriver {
	
	private Scanner input;

	public static void main(String[] args) 
	{
		SectionDriver sd = new SectionDriver();
		sd.input = new Scanner(System.in);
		Section sec = sd.getSectionInfo();
		boolean another = true;
		while(another)
		{
			
		}
		
		try
		{
			System.out.println(sec.toString());
		}
		catch(Exception e)
		{
			another = false;
		}
		
		sd.input.close();
	}
	
	private Section getSectionInfo()
	{
		Section sec = new Section();
		boolean valid = false;
		
		do
		{
			try
			{
				System.out.println("Please enter the section number");
				int secNum = input.nextInt();
				sec.setSecNum(secNum);
				valid = true;
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				valid = false;
			}
			finally
			{
				input.nextLine();
			}
		} while (!valid);
		
		valid = false;
		do
		{
			try
			{
				System.out.println("Please enter the instructor for the section");
				String instructor = input.nextLine();
				sec.setInstructor(instructor);
				valid = true;
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				valid = false;
			}
			finally
			{
				input.nextLine();
			}
		} while (!valid);
		
		
		valid = false;
		do
		{
			try
			{
				System.out.println("Please enter the Room for the section");
				String room = input.nextLine();
				sec.setInstructor(room);
				valid = true;
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				valid = false;
			}
			finally
			{
				input.nextLine();
			}
		} while (!valid);
		
		
		
		return sec;
	}
	
	private Student getStudentInfo() throws Exception
	{
		Student stu = new Student();
		System.out.println("please enter the student name, press enter to exit");
		String name = input.nextLine();
		stu.setName(name);
		
		// MAJOR TRY/CATCH
		boolean valid = false;
		do 
		{
			try
			{
				System.out.println("Please enter the major for " + stu.getName());
				String major = input.nextLine();
				stu.setMajor(major);
			} catch(Exception e) 
			{
				System.out.println(e.getMessage());
				valid = false;
			}
		}while (!valid);
		
		
		// GPA TRY/CATCH
		valid = false;
		do 
		{
			try
			{
				System.out.println("Please enter the GPA for " + stu.getGPA());
				Double GPA = input.nextDouble();
				stu.setGPA(GPA);
			} 
			catch(Exception e) 
			{
				System.out.println(e.getMessage());
				valid = false;
			}
			finally
			{
				input.nextLine();
			}
		}while (!valid);
		
		
		// HOURS TRY/CATCH
		valid = false;
		do 
		{
			try
			{
				System.out.println("Please enter the hours for " + stu.getHours());
				int hours = input.nextInt();
				stu.setHours(hours);
			} catch(Exception e) 
			{
				System.out.println(e.getMessage());
				valid = false;
			}
		}while (!valid);
		
		
		
		
		
		
		
		return stu;
	}
	
	
	
}
