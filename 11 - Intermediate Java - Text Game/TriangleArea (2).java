
public class TriangleArea {
	private boolean isPalindrome = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TriangleArea ta = new TriangleArea();

		System.out.println(ta.getArea(3));
		System.out.println(ta.getArea(15));
		System.out.println(ta.getArea(120));
		
		System.out.println(ta.recursiveFlipString("Hannah"));
		System.out.println(ta.recursiveFlipString("racecar"));
		
		
	}
	
	private int getArea(int width) 
	{
		if (width == 1) 
		{
			return 1;
		}
		
		return width + getArea(width - 1);
	}
	
	private boolean isPalindrome(String str) {
		
		
		
		if (str.length() <= 1) 
		{
			isPalindrome = true;
			return isPalindrome;
		}
		
		char first = str.charAt(0);
		char last = str.charAt(str.length()-1);
		boolean firstLetter = Character.isLetter(first);
		boolean lastLetter = Character.isLetter(last);
		
		
			if (firstLetter && lastLetter) {
				if (first == last) {
					return isPalindrome(str.substring(1, str.length()-1));
				}				
			}
			else 
			{
				return false;
			}
		
	
	}
	
	
	

}
