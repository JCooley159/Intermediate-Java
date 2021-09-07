
public class Player
{
    private String name;
    private int hitPoints;
    private String armor;
    
    public Player()
    {
        name = "";
        hitPoints = 100;
    }
    
    public Player(String name, int hitPoints, String armor)
    {
        this.name = name;
        this.hitPoints = hitPoints;
        this.armor = armor;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the hitPoints
     */
    public int getHitPoints()
    {
        return hitPoints;
    }

    /**
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }

    /**
     * @return the armor
     */
    public String getArmor()
    {
        return armor;
    }

    /**
     * @param armor the armor to set
     */
    public void setArmor(String armor)
    {
        this.armor = armor;
    }


    @Override
    public String toString()
    {
        return "Name - " + name + ", hitPoints - " + hitPoints + ", armor - " + armor;
    }
}
