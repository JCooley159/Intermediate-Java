package inheritance;

public class CheckingAccount extends BankAccount
{
    private double interestRate;
    
    public CheckingAccount()
    {
//        super();
        interestRate = .05;
    }

    /**
     * Method: CheckingAccount
     * Create and initialize  the instance of CheckingAccount
     * @param acctNum
     * @param balance
     */
    public CheckingAccount(String acctNum, double balance)
    {
        this();
//      super(acctNum, balance);
        setAcctNum(acctNum);
        setBalance(balance);
        // TODO Auto-generated constructor stub
    }
    
    public void deposit(double amount)
    {
        amount -= 5;
        super.deposit(amount);
    }

    
}
