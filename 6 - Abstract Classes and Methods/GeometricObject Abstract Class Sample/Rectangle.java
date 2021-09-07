public class Rectangle extends GeometricObject {
  private double width, height;
  
  public Rectangle() { 
    width = 1.0; height = 1.0;
  }
  
  public Rectangle(double width, double height) {
    this.width = width; 
    this.height = height;
  }
  
  public Rectangle(double width, double height, String color, boolean filled) {
    this.width = width; 
    this.height = height;
    setColor(color);
    setFilled(filled);
  }
  
  public double getWidth() { return width; }
  public void setWidth(double width) { this.width = width; }
  public double getHeight() { return height; }
  public void setHeight(double height) { this.height = height; }  
  
  /** Override abstract method getArea from super class GeometricObject */
  @Override
  public double getArea() { return width * height; }
  
  /** Override abstract method getPerimeter from super class GeometricObject */
  @Override
  public double getPerimeter() { return 2.0 * width + 2.0 * height; }  
}
