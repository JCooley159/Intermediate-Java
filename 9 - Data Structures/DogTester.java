package dataStructures;

import java.util.Scanner;

public class DogTester
{
    private Dog[] dogs = new Dog[5];
    
    private void buildDogs()
    {
        dogs[0] = new Dog("Spot", 5, "Dalmation", 50);
        dogs[1] = new Dog("Dusty", 8, "Golden Retriever", 95);
        dogs[2] = new Dog("Sam", 12, "Golden Retriever", 70);
        dogs[3] = new Dog("Kenai", 7, "Australian Shepherd", 75);
        dogs[4] = new Dog("Bella", 3, "German Shepherd", 90);
    }

    public static void main(String[] args)
    {
        DogTester dt = new DogTester();
        dt.buildDogs();
        boolean again = true;
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.println("Please select the type of list you want to create");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Priority Queue");
            System.out.println("4. Quit");
            int menuChoice = input.nextInt();
            
            switch (menuChoice)
            {
                case 1:
                {
                    dt.stack();
                    break;
                }
                case 2:
                {
                    dt.queue();
                    break;
                }
                case 3:
                {
//                    dt.priorityQueue();
                    break;
                }
                case 4:
                {
                    again = false;
                    break;
                }
                default:
                {
                    System.out.println("Invalid choice");
                }
            }
            
        }while(again);

    }
    
    public void stack()
    {
        DogStack ds = new DogStack();
        ds.addDogs(dogs);
        ds.printStack();
        System.out.println("\n");
        System.out.println(ds.removeDog().toString());
        System.out.println("\n");
        ds.printStack();
        System.out.println("\n");
    }
    
    public void queue()
    {
        DogQueue dq = new DogQueue();
        dq.addDogs(dogs);
        dq.printQueue();
        System.out.println("\n");
        System.out.println(dq.removeDog().toString());
        System.out.println("\n");
        dq.printQueue();
        System.out.println("\n");
    }
    
//    public void priorityQueue()
//    {
//        DogPriorityQueue dpq = new DogPriorityQueue();
//        dpq.addDogs(dogs);
//        dpq.printQueue();
//        System.out.println("\n");
//        System.out.println(dpq.removeDog().toString());
//        System.out.println("\n");
//        dpq.printQueue();
//        System.out.println("\n");
//        System.out.println(dpq.removeDog().toString());
//        System.out.println("\n");
//        dpq.printQueue();
//        System.out.println("\n");
//        System.out.println(dpq.removeDog().toString());
//        System.out.println("\n");
//        dpq.printQueue();
//        System.out.println("\n");
//        System.out.println(dpq.removeDog().toString());
//        System.out.println("\n");
//        dpq.printQueue();
//        System.out.println("\n");        
//    }

}
