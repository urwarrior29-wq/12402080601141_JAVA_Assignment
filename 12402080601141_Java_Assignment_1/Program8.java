//Program 8-> Create custom exception handling for bank withdrawal  scenario

//Custom exception class
class InsufficientBalanceException extends Exception
{
	InsufficientBalanceException(String message)
	{
		super(message);
	}
}
//Bank class
class BankAccount
{
	double balance;
	BankAccount(double balance)
	{
		this.balance=balance;
	}
	void withdraw(double amount) throws InsufficientBalanceException{
		if(amount>balance)
		{
			throw new InsufficientBalanceException("Insufficient Balance!");
		}
		else
		{
			balance-=amount;
			System.out.println("Withdrawal Successful");
			System.out.println("Remaining Balance:"+ balance);
		}
	}
}

//main class

public class Program8
{
	public static void main(String args[])
	{
		BankAccount acc=new BankAccount(5000);
		try
		{
			acc.withdraw(6000);//trying withdraw more than balance
		}
		catch(InsufficientBalanceException e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
		
	}
}