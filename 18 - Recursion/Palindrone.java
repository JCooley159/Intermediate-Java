package recursion;

public class Palindrone
{
    boolean palindrone = false;

    public static void main(String[] args)
    {
        Palindrone p = new Palindrone();
        p.checkPalindrone("XYYX");
        p.checkPalindrone("XYYZ");
        p.checkPalindrone("XZYX");
        p.checkPalindrone("This is a palindrone enordnilap a si sihT");
        p.checkPalindrone("X1YYX");
        p.checkPalindrone("XYYX2");
    }

    private void checkPalindrone(String testStr)
    {
        if (isPalindrone(testStr))
        {
            System.out.println("String " + testStr + " is a palindrone.");
        }
        else 
        {
            System.out.println("String " + testStr + " is not a palindrone.");
        }
    }

    public boolean isPalindrone(String input)
    {
        if (input.length() <= 1)
        {
            palindrone = true;
            return true;
        }
        char first = input.charAt(0);
        char last = input.charAt(input.length() -1);
        
        boolean firstLtr = Character.isLetter(first);
        boolean lastLtr = Character.isLetter(last);
        
        if (firstLtr && lastLtr)
        {
            if (first == last)
            {
                input = input.substring(1,input.length()-1);
                isPalindrone(input);
            }
            else
            {
                palindrone = false;
            }
        }
        else if (!firstLtr)
        {
            input = input.substring(1);
            isPalindrone(input);
        }
        else if (!lastLtr)
        {
            input = input.substring(0,input.length() - 1);
            isPalindrone(input);
        }
        
        return palindrone;
    }

}
