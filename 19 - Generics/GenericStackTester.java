package generics;

public class GenericStackTester
{

    public static void main(String[] args)
    {
        GenericStack<String> strings = new GenericStack<String>();
        strings.push("Hello");
        strings.push("World");
        System.out.println("Size is " + strings.getSize());
        System.out.println(strings.peek());
        System.out.println(strings.pop());
        System.out.println("Size is " + strings.getSize());
        System.out.println("Is empty? " + strings.isEmpty());
        System.out.println(strings.peek());
        System.out.println(strings.pop());
        System.out.println("Size is " + strings.getSize());
        System.out.println("Is empty? " + strings.isEmpty());
        
        GenericStack<Integer> numbers = new GenericStack<Integer>();
        numbers.push(5);
        numbers.push(10);
//        numbers.push("Hello");
        System.out.println("Size is " + numbers.getSize());
        System.out.println(numbers.peek());
        System.out.println(numbers.pop());
        System.out.println("Size is " + numbers.getSize());
        System.out.println("Is empty? " + numbers.isEmpty());
        System.out.println(numbers.peek());
        System.out.println(numbers.pop());
        System.out.println("Size is " + numbers.getSize());
        System.out.println("Is empty? " + numbers.isEmpty());
        
    }

}
