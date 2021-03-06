package com.pentastagiu.threads;

//Java program to explain the 
//concept of Waiting a thread. 
class PNBCustomer {

	// let a initial amount is 9000
	int amount = 9000;

	// synchronized function because i wil use for
	// waiting thread. Here synchronized means inter-
	// thread communication
	synchronized void withdraw(int amount) {
		System.out.println("Withdrawing...");

		// check if balance amount is less than withdraw
		// amount in this condition. deposit() synchronized
		// method call and deposit amount after that this
		// thread again execute
		if (this.amount < amount) {

			System.out.println("Amount is not enough; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}

		System.out.println("After deposit, balance is available: " + this.amount);
		this.amount -= amount;
		System.out.println("Withdraw completed...");
		System.out.println("After Withdraw, balance is available: " + this.amount);
	}

	synchronized void deposit(int amount) {
		System.out.println("Going to deposit...");
		this.amount += amount;
		System.out.println("Deposit completed... ");
		notify();
	}

}

public class WaitInJava {

	public static void main(String args[]) {
		final PNBCustomer c = new PNBCustomer();
		// create two new thread and start
		// them simultaneously
		new Thread() {
			@Override
			public void run() {
				c.deposit(10000);
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				c.withdraw(15000);
			}
		}.start();

	}
}
