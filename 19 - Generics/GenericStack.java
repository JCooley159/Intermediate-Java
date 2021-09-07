package generics;

import java.util.ArrayList;

public class GenericStack <E>
{
    private ArrayList<E> list;
    
    public GenericStack()
    {
        list = new ArrayList<E>();
    }
    
    public int getSize()
    {
        return list.size();
    }
    
    public E peek()
    {
        return list.get(list.size() - 1);
    }
    
    public E pop()
    {
        E item = list.get(list.size() -1);
        list.remove(list.size() -1);
        return item;
    }
    
    public void push(E item)
    {
        list.add(item);
    }
    
    public boolean isEmpty()
    {
        return list.size() == 0;
    }

}
