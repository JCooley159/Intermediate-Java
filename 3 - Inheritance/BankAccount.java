package inheritance;

public class BankAccount
{
    private String acctNum;
    private double balance;
    
    
    
    /**
     * Method: BankAccount
     * Create and initialize  the instance of BankAccount
     */
    public BankAccount()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * Method: BankAccount
     * Create and initialize  the instance of BankAccount
     * @param acctNum
     * @param balance
     */
    public BankAccount(String acctNum, double balance)
    {
        this.acctNum = acctNum;
        this.balance = balance;
    }
    
    public void deposit(double amount)
    {
        balance += amount;
    }
    
    /**
     * @return the acctNum
     */
    public String getAcctNum()
    {
        return acctNum;
    }
    /**
     * @param acctNum the acctNum to set
     */
    public void setAcctNum(String acctNum)
    {
        this.acctNum = acctNum;
    }
    /**
     * @return the balance
     */
    public double getBalance()
    {
        return balance;
    }
    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    

}
