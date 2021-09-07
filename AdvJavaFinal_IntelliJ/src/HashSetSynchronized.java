// JEREMY COOLEY 12/7/2018 Adv JAVA Final

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static jdk.nashorn.internal.objects.NativeMath.round;


public class HashSetSynchronized
{
     private Set hashSet = new HashSet();
     private static final int TASK1DELAY = 1000;
     private static final int TASK2DELAY = 2000;
     private Lock hashSetLock = new ReentrantLock();

     class Task1 implements Runnable
     {
          public void run()
          {
              // FILL IN CODE TO ADD 20 values to hashSet.  Wait 1000 ms between each value. Make it thread safe!
              hashSetLock.lock();
              try
              {
                  for (int i = 1; i <= 20; i++)
                  {
                      hashSet.add( round(Math.random(), 2) );
                      Thread.sleep(TASK1DELAY);
                  }
              }
              catch (InterruptedException e)
              {
                  e.printStackTrace();
              }
              finally
              {
                  hashSetLock.unlock();
              }


          }
     }



     class Task2 implements Runnable
     {
          public void run()
          {
               // Write code to iterate through hashset every 2 seconds and print the contents.
               // do this until there are at least 20 values in the set.  Make sure to make it thread safe
              Condition condit = hashSetLock.newCondition();
              while (hashSet.size() <= 20) {
                  try {
                      condit.await();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }

              Iterator hashIterator = hashSet.iterator();

              hashSetLock.lock();
              try
              {
                  while (hashIterator.hasNext())
                  {
                      System.out.print("" + hashIterator.next() + ", ");
                  }
              }
              finally
              {
                  hashSetLock.unlock();
              }


              try {
                  Thread.sleep(TASK2DELAY);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

              System.out.println(" ");
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
