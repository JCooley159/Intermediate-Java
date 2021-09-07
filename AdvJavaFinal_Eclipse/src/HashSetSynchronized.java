import java.util.*;

public class HashSetSynchronized
{
 private Set hashSet = new HashSet();

 class Task1 implements Runnable
 {
  public void run()
  {
     // FILL IN CODE TO ADD 20 values to hashSet.  Wait 1000 ms between each value. Make it thread safe! 
  }
 }



 class Task2 implements Runnable
 {
  public void run()
  {
   // Write code to iterate through hashset every 2 seconds and print the contents. 
   // do this until there are at least 20 values in the set.  Make sure to make it thread safe
  }
 }


// YOU MAY ONLY ADD TO THIS METHOD - DO NOT CHANGE THE EXISTING CODE
 public HashSetSynchronized()
 {
  Thread thread1 = new Thread(new Task1());
  Thread thread2 = new Thread(new Task2());
  thread1.start();
  thread2.start();
 }
 
 // DO NOT MODIFY THIS METHOD
 public static void main(String[] args)
 {
  new HashSetSynchronized();
 }
}
