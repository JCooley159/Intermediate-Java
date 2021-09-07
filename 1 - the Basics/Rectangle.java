
public class Rectangle {
		private double width;
		private double length;
		private String color;
		
		
		public Rectangle() {
			
		}
		public Rectangle(double w, double l, String c) {
			this.width = w;
			this.length = l;
			this.color = c;
		}
		public double Area() {
		
			final double a;
			a = width * length;
			return a;
		}
		
		
		
		public double getWidth() {
			return width;
		}
		public void setWidth(double width) {
			this.width = width;
		}
		public double getLength() {
			return length;
		}
		public void setLength(double length) {
			this.length = length;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		@Override
		public String toString() {
			return "Rectangle [width=" + width + ", length=" + length + ", color=" + color + "]";
		}
		
		
		
		
}
