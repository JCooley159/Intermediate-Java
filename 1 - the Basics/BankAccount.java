

public class BankAccount {

    private String name;
    private double balance;
    private int interest;

    public BankAccount(String n, double b, int i){
        this.name = n;
        this.balance = b;
        this.interest = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", interest=" + interest +
                '}';
    }
}
