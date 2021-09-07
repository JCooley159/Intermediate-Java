import java.util.Scanner;

public class MyCircleClass {
	
	  private double radius;
	  private String color;
	  
	  
	  
	  public MyCircleClass() 
	  {		  
	  }
	  public MyCircleClass(double r) 
	  {
		  this.radius = r;
		  this.color = "none";
	  }
	  public MyCircleClass(double r, String c) 
	  {
		  this.radius = r;
		  this.color = c;
	  }
	  
	  
	
	public double getRadius() 
	{
		return radius;	
	}
	
	public void setRadius(double radius) 
	{
		this.radius = radius;
	}
	
	public String getColor() 
	{
		return color;
	}
	
	public void setColor(String color) 
	{
		this.color = color;
	}
	
	@Override  /* makes sure it calls this version of .toString() without calling the old one it naturally inherits from java.lang.object */
	public String toString() {
		return "MyCircleClass [radius=" + radius + ", color=" + color + "]";
	}
	  
	
  
}
