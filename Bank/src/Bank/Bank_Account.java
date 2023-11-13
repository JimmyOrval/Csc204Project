package Bank;

public class Bank_Account implements BankOperations {
	private int AccountNumber;
	Customer customer;
	double balance;
	
	public Bank_Account() {
		this.balance=0;
	}
	

	public Bank_Account(int accountNumber, Customer customer, double balance) {
		AccountNumber = accountNumber;
		this.customer = customer;
		setBalance(balance);
	}
	


	public Bank_Account(Bank_Account b) {
		super();
		AccountNumber = b.AccountNumber;
		this.customer = b.customer;
		this.balance = b.balance;
	}


	public int getAccountNumber() {
		return AccountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		if(balance<=0) {
			this.balance=0;
		}
		else {
		this.balance = balance;
		}
	}


	@Override
	public double Deposit(double dep) {
		this.balance=this.balance+dep;
		return this.balance;
	}

	@Override
	public double Withdraw(double with) {
		this.balance=this.balance-with;
		return this.balance;
	}

	@Override
	public double WithdrawT(double with) {
		this.balance=this.balance-with-0.02*with;
		return this.balance;
	}


	public String Show(Bank_Account ba) {
		return String.format("%s%s%s","Bank_Account [AccountNumber=" + ba.getAccountNumber() + ", customer=" + customer.toString() + ", balance=" + balance + "]");
	}

}
