
public class QuestionFive {
    public static void main(String args[]){
        BankAccount userOne = new BankAccount("Jerry", 2057.68, 1);
        BankAccount userTwo = new BankAccount("Tom", 2387.34, 2);
        BankAccount userThree = new BankAccount("Spike", 1003.21, 1);

        if (userOne.getBalance() > userTwo.getBalance() && userOne.getBalance() > userThree.getBalance()){
            System.out.print(userOne.getName() + " has the highest balance.");
        } else if (userTwo.getBalance() > userOne.getBalance() && userTwo.getBalance() > userThree.getBalance()){
            System.out.print(userTwo.getName() + " has the highest balance.");
        } else {
            System.out.print(userThree.getName() + " has the highest balance.");
        }
    }
}
