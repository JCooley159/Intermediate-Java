
public class RectangleTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r1 = new Rectangle();			
		r1.setWidth(1.1);
		r1.setLength(3.4);
		r1.setColor("Purple");
			
		
		System.out.println(r1.getWidth());
		System.out.println(r1.getLength());
		System.out.println(r1.getColor());
		
		System.out.println(r1.toString());
		
		
		Rectangle r2 = new Rectangle(4, 3, "Black");		
		System.out.println(r2.toString());
		
		System.out.println(r2.Area());
		
		
	}

}
