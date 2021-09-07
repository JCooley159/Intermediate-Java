import java.util.*;
public class TestComparableCircles {
  public static void main(String[] args) { 
    Scanner input = new Scanner(System.in);
    int n;
    double maxRadius;
    ArrayList<ComparableCircle> listCircle = new ArrayList<ComparableCircle>();
    
    System.out.print("Enter number of random circles and max radius: ");
    n = input.nextInt();
    maxRadius = input.nextDouble();
    
    generateRandomCircles(listCircle, n, maxRadius);
    
    System.out.println("----- Original List -----");
    displayAllCircles(listCircle);
  
    System.out.println("----- Sorted List -----");
    Collections.sort(listCircle);
    displayAllCircles(listCircle);    
  }
  
  public static void generateRandomCircles(ArrayList<ComparableCircle> list, int n, 
                                           double maxRadius) {
    
    for(int i = 0; i < n; i++) {
      double radius = Math.random() * maxRadius;
      ComparableCircle newCircle = new ComparableCircle(radius);
      
      list.add(newCircle);
    }
  }
  
  public static void displayAllCircles(ArrayList<ComparableCircle> list) {
    for (ComparableCircle myCircle: list) {
      System.out.printf("Circle radius = %.3f, area = %,.3f\n", myCircle.getRadius(), 
                        myCircle.getArea());
    }
  }
  
}
