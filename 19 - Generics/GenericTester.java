package generics;

public class GenericTester<E>
{
    private static int num;
//    private static E num2;
//    private E[] nums = new E[10];
    private E[] nums2 = (E[]) new Object[10];
//    private E number = new E();
    private E number = (E) new Object();
    
    static 
    {
        num = 150;
//        E number4 = 10;
    }
    


}
