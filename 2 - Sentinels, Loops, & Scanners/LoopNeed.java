import java.util.Scanner;

public class LoopNeed
{
  public static void main(String[] args)
  {
    String name = "";
    Scanner input = new Scanner(System.in);
    System.out.println("Enter as many names as you like, entering \" End \" to stop.");
    while(!name.equalsIgnoreCase("End"))
    {
      name = input.nextLine();
      System.out.println("Hi, " + name);
    }
  }
}