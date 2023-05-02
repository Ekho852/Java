public class BankAccount
{
	private String name; //private to prevent override outside class
	private int AccNum;
	private double balance;
	
	public BankAccount()//Default value to 1.0
    {
		balance = 0.0;
    }
	
	public void setName(String name)//sets name to "name" string
	{
		this.name = name;
	}
	
	public String getName()//used to assign to name from input
	{
		return name;
	}
	
	public void setAccNum(int AccNum)//sets Account Number to "AccNum" integer
	{
		this.AccNum = AccNum;
	}
	
	public int getAccNum()//used to assign to Account Number from input
	{
		return AccNum;
	}

	public double getBalance()//returns balance of account
	{
		return balance;
	}

	public void deposit(double amount)//adds money to balance 
	{
		balance += amount;
	}
	
	public void withdraw(double amount)// withdraw method
	{
		if(amount < balance)
		{
			balance -= amount;//checks to confirm balance is greater than withdrawal amount
		}
		else
		{
			System.out.println("Error: Insufficient funds.");//prints error if withdrawal amount is greater than balance
		}
		
	}
	
	public String toString()// toString overrides and converts object into readable string
	{
		return name + ": Balance = €" + balance;
	}

	protected void setBalance(double balance2)//used to set new balance in loan account 
	{
		this.balance = balance2;
	}
}
