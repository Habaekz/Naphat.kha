import java.util.ArrayList;
public class Bank {
	
	//1.variable
		public double totalbalance = 0;
		private ArrayList<BankAccount> accounts;
		//2.constructor
		
		public Bank(){
			accounts = new ArrayList<BankAccount>();
		}
		//3.methods
		//add an account to this bank
		public void addAccount(BankAccount a){
			accounts.add(a);
		}
		//gets the sum of the balances of all accounts in this bank
		public double getTotalBalance(){
			double total = 0;
			for (int i = 0; i < accounts.size(); i++)
			{
				BankAccount a = accounts.get(i);
				total = total + a.getBalance();
			}
			/*for (BankAccount a : accounts)
			{
				total = total + a.getBalance();
			}*/
			return total;
		}
		//counts the number of bank account whose balance is at least given value.
		public double countBalanceAtLeast(double atLeast){
			//put your code here
			double matches = 0;
			for (int i = 0; i < accounts.size(); i++)
			{
				BankAccount a = accounts.get(i);
				if (a.getBalance() >= atLeast) {
					matches++; // Found a match
				}
			}
			/*for (BankAccount a : accounts)
			{
				if (a.getBalance() >= atLeast) {
					matches++; // Found a match
				}
			}*/
			return matches;
		}
		//finds a bank account with a given number
		public BankAccount find(int accountNumber){
			
			//put your code here
			for (int i = 0; i < accounts.size(); i++)
			{
				BankAccount a = accounts.get(i);
				if (a.getAccountNumber() == accountNumber) // Found a match
					return a;
			}
			/*for (BankAccount a : accounts)
			{
				if (a.getAccountNumber() == accountNumber) // Found a match
				return a;
			}*/
			return null;
		}
		//gets the bank account which has minimum balance.
	    public BankAccount getMin(){
			
	        //put your code here
	    	if (accounts.size() == 0) return null;
	    	BankAccount Min = accounts.get(0);
	    	for (int i = 1; i < accounts.size(); i++)
	    	{
	    		BankAccount a = accounts.get(i);
	    		if (a.getBalance() < Min.getBalance())
	    		{
	    			Min = a;
	    		}
	    	}
	    	return Min;
	    }
}	

