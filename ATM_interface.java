import java.util.*;

class BankAccount
{
    private  double balance;
    public BankAccount(double initialBalance) {
    this.balance = initialBalance;
}

public double getBalance()
{
    return balance;
}

public void deposit(double amount)
{
    if(amount>0)
    {
        balance += amount;
        System.out.println("Money Deposited " + amount + "successfully");
        System.out.println("Your Current balance is : " + balance);
    }
    else
    {
        System.out.println("InValid Deposite amount : ");
    }
}
    
    public void withdraw(double amount)
    {
        if(amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("Money Withdrawal " + amount + "Successfully");
            System.out.println("Your Current Balance is : " + balance);
        }
        else
        {
            System.out.println("Invalid Withdrawal Amount or Sufficient Balace : ");
        
        }

    }
}


class ATM
{
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }
    public void DisplayMenu()
    {
        System.out.println("ATM Menu");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposite");
        System.out.println("3.Withdraw");
        System.out.println("4.Exit");
    }

    public void performTransaction(int choice,Scanner s)
    {
        switch(choice)
        {
            case 1:
            System.out.println("Current Balance : " + bankAccount.getBalance());
            break;

            case 2:
            System.out.println("Enter Deposite Amount : ");
            double depositeAmount = s.nextDouble();
            bankAccount.deposit(depositeAmount);
            break;

            case 3:
            System.out.println("Enter Withdrawal Amount : ");
            double withdrawAmount = s.nextDouble();
            bankAccount.withdraw(withdrawAmount);
            break;

            case 4:
            System.out.println("Existing ATM THANK YOU !!");
            s.close();
            System.exit(0);

            default:
            System.out.println("Invalid Choice Please Select a valid option");
        }
    }
}

public class ATM_interface
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter initial account balance : ");
        double initialBalance = s.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(bankAccount);
        while (true)
        {
            atm.DisplayMenu();
            System.out.println("Select an Option : ");
            int choice = s.nextInt();
            atm.performTransaction(choice, s);
            
        }
    }
}

