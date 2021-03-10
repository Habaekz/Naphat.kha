public class BankAccountTester {
	
	public static void main(String[] args) {
		BankAccount third = new BankAccount();
		System.out.println("Naphat 6188029");
		System.out.println("Balance  : " + third.Balance());
		System.out.println("");
		BankAccount.deposit(1000);
		System.out.println("withdraw : 1000.0");
		System.out.println("Balance  : " + third.Balance());
		System.out.println("");
		BankAccount.withdraw(500);
		System.out.println("deposite : 500.0");
		System.out.println("Balance  : " + third.Balance());
		System.out.println("");
		BankAccount.withdraw(400);
		System.out.println("deposite : 400.0");
		System.out.println("Balance  : " + third.Balance());
		
	}
}
