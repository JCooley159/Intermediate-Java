
public class Fighter extends Player
{
    private String weapon;
   
    public Fighter()
    {
        super();
        weapon = "";
    }

    public Fighter(String name, int hitPoints, String armor)
    {
        super(name, hitPoints, armor);
        weapon = "";
    }

    public Fighter(String name, int hitPoints, String weapon, String armor)
    {
        super(name, hitPoints, armor);
        this.weapon = weapon;
    }

    /**
     * @return the weapon
     */
    public String getWeapon()
    {
        return weapon;
    }

    /**
     * @param weapon the weapon to set
     */
    public void setWeapon(String weapon)
    {
        this.weapon = weapon;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Fighter: " + super.toString() + ", weapon - " + weapon;
    }
    
    

}
