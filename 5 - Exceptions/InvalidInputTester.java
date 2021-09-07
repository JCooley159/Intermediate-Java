package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InvalidInputTester
{
    
    

    public static void main(String[] args)
    {
       InvalidInputTester iit = new InvalidInputTester();
       try
       {
           iit.getNumber();
       }
       catch(DuplicateIDException die)
       {
           System.out.println(die.getMessage());
       }
    }
    
    private void getNumber()
    {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        do
        {
            try
            {
                System.out.println("Enter a number");
                int num = input.nextInt();
                valid = true;
            }
            catch(InputMismatchException ime)
            {
                throw new DuplicateIDException("Not a valid number");
//                System.out.println("Enter a valid number.");
//                input.nextLine();
            }
        }while(!valid);
        
    }

}
