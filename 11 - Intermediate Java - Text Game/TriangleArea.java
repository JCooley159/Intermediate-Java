
public class TriangleArea
{

    public static void main(String[] args)
    {
       TriangleArea ta = new TriangleArea();
       
       System.out.println(ta.getArea(3));
       System.out.println(ta.getArea(15));
       System.out.println(ta.getArea(125));

    }
    
    private int getArea(int width)
    {
        if (width == 1)
        {
            return 1;
        }
        
        return width + getArea(width -1);
    }

}
