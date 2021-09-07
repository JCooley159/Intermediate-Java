public class Circle extends GeometricObject {
  private double radius;
    
  public Circle() { radius = 1.0; }  
  public Circle(double radius) {   this.radius = radius; }
  
  public Circle(double radius, String color, boolean filled) {    
    this.radius = radius;
    setColor(color);
    setFilled(filled);
  }
  
  public void setRadius(double radius) { this.radius = radius; }
  public double getRadius() { return radius; }
  
  /** Override abstract method getArea from the superClass GeometricObject */
  @Override
  public double getArea() { return Math.PI * radius * radius; }
  
  /** Override abstract method getPerimeter from the superClass GeometricObject */
  @Override
  public double getPerimeter() { return 2.0 * Math.PI * radius; }  
}
