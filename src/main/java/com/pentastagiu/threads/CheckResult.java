package com.pentastagiu.threads;

public class CheckResult {
	private static int counter = 0;

	/**
	 * How many times will the while() loop in this code execute and output Not
	 * reached yet?
	 * 
	 * We don't know.
	 */
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 50000; i++)
				CheckResult.counter++;
		}).start();

		while (CheckResult.counter < 5000) {
			System.out.println("Not reached yet");
		}
		System.out.println("Reached!");
	}
}