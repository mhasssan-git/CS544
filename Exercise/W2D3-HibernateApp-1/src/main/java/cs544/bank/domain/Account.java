package cs544.bank.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.*;

@Entity
public class Account {
	@Id
	private long accountnumber;
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "account_id")
	private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "account_id")
	private Customer customer;


	public Account (long accountnr){
		this.accountnumber = accountnr;
	}

	public Account() {

	}

	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);
		toAccount.addEntry(toEntry);
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

}
