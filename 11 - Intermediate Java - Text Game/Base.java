class Base {

	public static int firstNum = 5;

	public static void main(String[] args)

	{

		Base newObject = new Child();

		newObject.printNum();

	}

	public static void printNum()

	{

		System.out.println(firstNum);

	}
}

class Child extends Base

{

	public static int secondNum = 10;

	public static void printNum()

	{

		System.out.println(secondNum);

	}
}