package dataStructures;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class DogQueue
{
    private Queue<Dog> dogs;
    
    public DogQueue()
    {
        dogs = new LinkedList<Dog>();
    }
    
    public void addDogs(Dog[] dogList)
    {
        for (Dog inDog : dogList)
        {
            dogs.add(inDog);
        }
    }
    
    public void printQueue()
    {
       ListIterator<Dog> iter = (ListIterator<Dog>) dogs.iterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
    
    public Dog removeDog()
    {
        return dogs.remove();
    }
}
