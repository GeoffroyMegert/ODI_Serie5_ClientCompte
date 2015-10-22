package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

public class Customer {

	private Collection<Account> accounts;
	private int number;
	private string firstName;
	private string lastName;

	public Collection<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public string getFirstName() {
		return this.firstName;
	}

	public void setFirstName(string firstName) {
		this.firstName = firstName;
	}

	public string getLastName() {
		return this.lastName;
	}

	public void setLastName(string lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @param number
	 * @param firstName
	 * @param lastName
	 */
	public Customer(Integer number, String firstName, String lastName) {
		// TODO - implement Customer.Customer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param number
	 */
	public Account getAccountByNumber(string number) {
		// TODO - implement Customer.getAccountByNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param number
	 * @param name
	 * @param rate
	 */
	public void addAccount(string number, string name, double rate) {
		// TODO - implement Customer.addAccount
		throw new UnsupportedOperationException();
	}

}