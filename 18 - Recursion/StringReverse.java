package recursion;

public class StringReverse
{

    public static void main(String[] args)
    {
        StringReverse sr = new StringReverse();
        
//        for (int index = 1; index < "Hello".length(); index++)
//        {
//            System.out.println("Hello".substring(0,  "Hello".length() -index));
//        }
//        
        System.out.println(sr.reverseStr("Hello"));

    }
    
    private String reverseStr(String str)
    {
        System.out.println(str);
        if (str.length() <= 1)
        {
            return str;
        }
        char last = str.charAt(str.length() -1);
        String rev = str.substring(0,  str.length() -1);
        reverseStr(rev);
        String newString =  last + rev;
        return newString;
    }

}
