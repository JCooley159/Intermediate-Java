package recursion;

public class CharacterTester
{

    public static void main(String[] args)
    {
        CharacterTester ct = new CharacterTester();
        for (int index = 1; index <= 8; index++)
        {
            System.out.println("Index is " + index);
            System.out.println(ct.writeChars(index));
            System.out.println("");
        }
    }
    
    private String writeChars(int n)
    {
        if (n <= 2)
        {
            String center = "*";
            if (n ==2)
            {
                center = "**";
            }
            return center;
        }
        return "<" + writeChars(n-2) + ">";
        
    }

}
