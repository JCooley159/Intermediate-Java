import java.util.*;
public class TestGeometricObject {
  public static void main(String[] args) { 
    GeometricObject myCircle = new Circle(5.0, "Blue", true);
    GeometricObject myRectangle = new Rectangle(3.0, 5.0, "Lime", true);
    
    System.out.println("---- Circle -----");
    displayInfo(myCircle);
    
    System.out.println("---- Rectangle -----");
    displayInfo(myRectangle);    
  }
  
  public static void displayInfo(GeometricObject obj) {
    System.out.println(obj.toString());    
    System.out.printf("Area = %,.3f\n", obj.getArea());
    System.out.printf("Perimeter = %,.3f\n", obj.getPerimeter());
    
    if(obj instanceof Circle) {
      Circle myCircle = (Circle)obj;
      System.out.printf("Radius = %,.3f\n", myCircle.getRadius());
    }
    else
      if(obj instanceof Rectangle) {
        Rectangle myRectangle = (Rectangle)obj;
        System.out.printf("Width = %,.3f\n", myRectangle.getWidth());
        System.out.printf("Height = %,.3f\n", myRectangle.getHeight());
      }      
  }
}
