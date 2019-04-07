package com.pentastagiu.threads;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		firstThreadExample();
		secondThreadExample();
		thirdThreadExample();
		fourthThreadExample();
	}

	/**
	 * In this method both threads will start their execution. The output is non
	 * deterministic.
	 */
	public static void firstThreadExample() {
		MyThread jamaica = new MyThread("Jamaica");
		MyThread fiji = new MyThread("Fiji");

		jamaica.start();
		fiji.start();
	}

	/**
	 * Creating a thread using runnable and an anonymous class.
	 */
	public static void secondThreadExample() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello from the second example");

			}
		});
		t.start();
	}

	/**
	 * This example also uses runnable, but as a lambda expression.
	 */
	public static void thirdThreadExample() {
		Thread t = new Thread(() -> System.out.println("Hello From the third example"));
		t.start();
	}

	/**
	 * Example of join usage. The threads will be executed sequentially.
	 */
	public static void fourthThreadExample() {
		MyThread jamaica = new MyThread("Jamaica");
		MyThread fiji = new MyThread("Fiji");

		jamaica.start();
		try {
			jamaica.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fiji.start();
	}

}
