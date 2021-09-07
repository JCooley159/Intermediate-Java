public class ComparableCircle extends GeometricObject implements Comparable<ComparableCircle> {
  private double radius;
  
  public ComparableCircle() {   radius = 1.0;  }
  public ComparableCircle(double radius) {   this.radius = radius;  }
  public ComparableCircle(double radius, String color, boolean filled) {    
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
  
  /** Override compareTo from the Clonable interface */
  @Override
  public int compareTo(ComparableCircle circle0) {
    if(getArea() > circle0.getArea())
      return 1;
    else
      if(getArea() < circle0.getArea())
        return -1;
      
    return 0;
  }
}
