import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample
{

    public static void main(String[] args)
    {
     
      String initialSet[] = {"Romeo", "Juliet", "Adam", "Eve", "Homer", "Marge", "Bart", "Eve"};
      String initialSet2[] = { "Eve", "Homer", "Marge", "Bart", "Eve", "Stewie", "Alex"};
      Set<String> set1 = new HashSet<String>(Arrays.asList(initialSet));
      Set<String> set2 = new HashSet<String>(Arrays.asList(initialSet2));
      

    }

}
