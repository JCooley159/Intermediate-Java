package inheritance;

public class Vehicle
{
    private int wheels = 4;
    private String engine;
    /**
     * @return the wheels
     */
    public int getWheels()
    {
        System.out.println("in the getWheels method");
        return wheels;
    }
    /**
     * @param wheels the wheels to set
     */
    public void setWheels(int wheels)
    {
        this.wheels = wheels;
    }
    /**
     * @return the engine
     */
    public String getEngine()
    {
        return engine;
    }
    /**
     * @param engine the engine to set
     */
    public void setEngine(String engine)
    {
        this.engine = engine;
    }
    
    

}
