package inheritance;

public class BankDriver
{

    public static void main(String[] args)
    {
        CheckingAccount ca = new CheckingAccount("1234", 1.5);
        System.out.println(ca.getAcctNum());
        
        ca.deposit(10);
        System.out.println("Checking " + ca.getBalance());
        
        SavingsAccount sa = new SavingsAccount("23423", 1.5);
        sa.deposit(10);
        System.out.println("Savings " + sa.getBalance());
    }

}
