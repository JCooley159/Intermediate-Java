/**
 * @author cjohns25
 *
 */
public class Math extends Course
{

    private boolean stem;
    private String format;

    /**
     * @param category
     * @param name
     * @param crn
     * @param stem
     * @param format
     */
    public Math(String category, String name, int crn, boolean stem,
            String format)
    {
        super(category, name, crn);
        this.stem = stem;
        this.format = format;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Math [stem = " + stem + ", format = " + format + ", category = " + getCategory()
                + ", name = " + getName() + ", crn = " + getCrn()
                 + ", hash code = " + hashCode() + "]";
    }

    /**
     * @return the stem
     */
    public boolean isStem()
    {
        return stem;
    }

    /**
     * @param stem
     *            the stem to set
     */
    public void setStem(boolean stem)
    {
        this.stem = stem;
    }

    /**
     * @return the format
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * @param format
     *            the format to set
     */
    public void setFormat(String format)
    {
        this.format = format;
    }

}
