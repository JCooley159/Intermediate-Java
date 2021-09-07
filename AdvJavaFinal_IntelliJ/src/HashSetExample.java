// JEREMY COOLEY 12/7/2018 Adv JAVA Final

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample
{

    public static void main(String[] args)
    {
     
      String initialSet[] = {"Romeo", "Juliet", "Adam", "Eve", "Homer", "Marge", "Bart", "Eve"};
      String initialSet2[] = { "Eve", "Homer", "Marge", "Bart", "Eve", "Stewie", "Alex"};
      Set<String> set1 = new HashSet<String>(Arrays.asList(initialSet));
      Set<String> set2 = new HashSet<String>(Arrays.asList(initialSet2));

      Set<String> set3 = new HashSet<String>();
      Iterator iter = set1.iterator();
      while (iter.hasNext())
      {
          Object testStr = iter.next();
          if (set2.contains(testStr))
          {
              set3.add((String) testStr);
          }
      }


        Iterator iter3 = set3.iterator();
      while (iter3.hasNext())
      {
          System.out.println(iter3.next());
      }

    }

}
