
public class CircleTester {

	public static void main(String[] args) {
		MyCircleClass c1 = new MyCircleClass();
		
		c1.setRadius(1.1);
		c1.setColor("Red");
		
		System.out.println(c1.getRadius());
		System.out.println(c1.getColor());
		
		System.out.println(c1.toString());
		
		MyCircleClass c2 = new MyCircleClass(2.1, "Black");
		
		System.out.println(c2.toString());
		
	}

}
