

public class Wizard extends Player
{
    private String spell;
   
    public Wizard()
    {
        super();
        spell = "";
    }

    public Wizard(String name, int hitPoints, String armor)
    {
        super(name, hitPoints, armor);
        spell = "";
    }

    public Wizard(String name, int hitPoints, String armor, String spell)
    {
        super(name, hitPoints, armor);
        this.spell = spell;
    }

    /**
     * @return the spell
     */
    public String getSpell()
    {
        return spell;
    }

    /**
     * @param armor the spell to set
     */
    public void setSpell(String spell)
    {
        this.spell = spell;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
    	// add "Wizard" back in if not working
        return this.getClass().getName() + ": " + super.toString() + ", spell - " + spell;
    }
    
    


}
