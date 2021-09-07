package dataStructures;

import java.util.ListIterator;
import java.util.Stack;

public class DogStack
{
    Stack<Dog> dogs;
    public DogStack()
    {
        dogs = new Stack<Dog>();
    }
    
    public void addDogs(Dog[] dogList)
    {
        for (Dog inDog : dogList)
        {
            dogs.push(inDog);
        }
    }
    
    public void printStack()
    {
        ListIterator<Dog> iter = dogs.listIterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next().toString());
        }
    }
    
    public Dog removeDog()
    {
        return dogs.pop();
    }

}
