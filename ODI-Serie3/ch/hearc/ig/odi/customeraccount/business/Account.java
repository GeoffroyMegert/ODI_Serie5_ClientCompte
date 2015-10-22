package ch.hearc.ig.odi.customeraccount.business;

public class Account {

	private Customer customer;
	private string number;
	private string name;
	private double balance = 0;
	private double rate = 0.001;

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public string getNumber() {
		return this.number;
	}

	public void setNumber(string number) {
		this.number = number;
	}

	public string getName() {
		return this.name;
	}

	public void setName(string name) {
		this.name = name;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * 
	 * @param number
	 * @param name
	 * @param rate
	 * @param customer
	 */
	public Account(String number, String name, double rate, Customer customer) {
		// TODO - implement Account.Account
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 */
	public void credit(double amount) {
		// TODO - implement Account.credit
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 */
	public void debit(double amount) {
		// TODO - implement Account.debit
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 * @param source
	 * @param target
	 */
	public static void transfer(double amount, Account source, Account target) {
		// TODO - implement Account.transfer
		throw new UnsupportedOperationException();
	}

}