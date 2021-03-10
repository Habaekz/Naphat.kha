public class BankAccount {
	
	//1. variables
	private int acctnumber;
	private double balance;
	private double initBalance;
	//2. constructor
	public BankAccount(int acctnumber, double initBalance){
		this.initBalance = initBalance;
		balance = this.initBalance;
		this.acctnumber = acctnumber;
	}
	
	//3. methods
	public void withdraw(double amount){
		double newBalance = balance - amount;
		balance = newBalance;
	}
	public void deposit(double amount){
		double newBalance = balance + amount;
		balance = newBalance;
	}
	public double getBalance(){
		return balance;
	}
	public int getAccountNumber(){
		return acctnumber;
	}
}
