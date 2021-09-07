import java.io.Serializable;
/**
 * Pet class for use on Midterm exam. Do not modify Do turn in with answer
 * 
 * @author cjohns25
 *
 */
public class Pet implements Serializable
{

	/**
     * Default constructor
     */
    public Pet()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param name
     * @param age
     * @param owner
     */
    public Pet(String name, int age, String owner)
    {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @param age
     *            the age to set
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * @return the owner
     */
    public String getOwner()
    {
        return owner;
    }

    /**
     * @param owner
     *            the owner to set
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    private String name;
    private int age;
    private String owner;

}
