package generics;

public class BoundedGenerics
{
    public static <T, E> boolean equalAmount(T first, E second)
    {
        return first.equals(second);
    }
    
	public static <T extends BankAccount> boolean equalAmount(T checking, T saving)
	{
		return checking.getBalance(checking.getAccount()) == saving.getBalance(saving.getAccount());
	}
	
	public static void main(String[] args)
	{
		CheckingAccount ca = new CheckingAccount(123456);
		SavingsAccount sa = new SavingsAccount();
		SavingsAccount sa2 = new SavingsAccount();

		ca.setAccount(1234567);
		ca.deposit(100, 1234567);

		sa.setAccount(123);
		sa.deposit(500, 123);
		
		if (equalAmount(ca, sa))
		{
			System.out.println("The accounts have the same balance.");
		}
		else
		{
			System.out.println("The balances are different.");
		}

		sa2.setAccount(123434334);
		//remember our checking account deposit has a $5 fee
		sa2.deposit(95, 123434334);
		if (equalAmount(ca, sa2))
		{
			System.out.println("The accounts have the same balance.");
		}
		else
		{
			System.out.println("The balances are different.");
		}

		equalAmount("Hello", "World");

	}

}
