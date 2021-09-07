package tests.test2;

public class Birthday implements Comparable<Birthday>
{
	//name of person
	private String name = "";
	//Birth date of person in yyyymmdd format
	private int bday = 0;
	public final static int TODAY = 20160714;

	public Birthday()
	{
		setName("Fred");
		setBday(TODAY);
	}
	
	
	public Birthday(String name, int birthday)
	{
		setName(name);
		setBday(birthday);
	}

	
	
	
	public String getName()
	{
		return name;
	}

	public void setName(String name) throws InvalidBirthdayException
	{
	    if (name.length() < 1)
	    {
	        throw new InvalidBirthdayException("Name cannot be empty.");
	    }
		this.name = name;
	}

	
	
	
	
	public int getBday()
	{
		return bday;
	}

	public void setBday(int bday) throws InvalidBirthdayException
	{
	    if (bday < 0 || bday > TODAY)
	    {
	        throw new InvalidBirthdayException("Birthday of " + bday + " is not valid.  Must be between 0 and " + TODAY);
	    }
	    if (bday != 0 && bday < 10000)
	    {
	        throw new InvalidBirthdayException("Date of " + bday + " is invalid.");
	    }
		this.bday = bday;
	}
	
	
	
	
	
	
	public String toString()
	{
		String data = "";
		data += name + " " + bday;
		return data;
	}
	
	
	public int compareTo(Birthday otherBirthday) {
		return bday.compareTo(otherBirthday.getBday());
	}
	
	
	
}
