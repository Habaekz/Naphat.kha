
public class BankAccount {

	public static double balance;
	
	public BankAccount() {
		balance = 0;
	}
	public static void deposit(double deposit) {
		balance = balance + deposit;
	}
	public static void withdraw(double withdraw) {
		balance = balance - withdraw;
	}
	public static double Balance() {
		return balance;
	}
	
}
