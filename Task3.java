import java.util.Scanner;

class BankAccount{
    private double balance;
    //constructor
    public BankAccount(double initialBalance)
    {
        this.balance=initialBalance;
    }
    // to get the balance
    public double getBalance()
    {
        return balance;
    }
    //to check deposit amount
    public void deposit(double amount)
    {
        if(amount>0){
            balance+=amount;
            System.out.println("INR "+amount+" deposited successfully");
        }
        else
        {
            System.out.println("Deposit amount must be positive");
        }
    }
    //to check withdraw
    public void withdraw(double amount)
    {
        if (amount<=0)
        {
            System.out.println("Withdraw at least 1 rupee.");
        }
        else if (amount>balance)
        {
            System.out.println("Insufficient balance. Transaction failed.");
        }
        else
        {
            balance-=amount;
            System.out.println("INR "+amount+"withdraw successful.");
        }
    }
}
// class for the working of ATM
class ATM{
    private BankAccount account;
    private Scanner scanner;
    // constructor
    public ATM(BankAccount account)
    {
        this.account=account;
        this.scanner=new Scanner(System.in);
    }
    // here the process start
    public void start()
    {
        int choice;
        do{
            displayMenu();
            System.out.println("Enter your choice: ");
            choice =scanner.nextInt();
            handleChoice(choice);
        }
        while(choice !=4);
    }
    // to display the menu
    private void displayMenu(){
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }
    // function for handling the choices
    private void handleChoice(int choice)
    {
        switch(choice)
        {
            case 1:
                System.out.println("Current Balance: Rs "+account.getBalance());
                break;
            case 2:
                System.out.println("Enter amount to deposit: Rs ");
                double deposit=scanner.nextDouble();
                account.deposit(deposit);
                break;
            case 3:
                System.out.println("Enter the amount to withdraw: Rs ");
                double withdraw=scanner.nextDouble();
                account.withdraw(withdraw);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Have a nice day");
                break;
            default:
                System.out.println("Invalid option. Please try again");
        }
    }
}
// main class
public class Task3 {
    public static void main(String[] args) {
        BankAccount userAccount=new BankAccount(1000.0);
        ATM atmMachine=new ATM(userAccount);
        atmMachine.start();
    }
