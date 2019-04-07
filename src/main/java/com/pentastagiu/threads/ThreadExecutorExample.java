package com.pentastagiu.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorExample {

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			service.execute(() -> System.out.println("Printing items"));
			service.execute(() -> {
				for (int i = 0; i < 3; i++) {
					/*
					 * try { Thread.sleep((long) (Math.random() * 1000)); } catch
					 * (InterruptedException e) { }
					 */
					System.out.println("Printing record: " + i);
				}
			});
			service.execute(() -> System.out.println("Printing items"));
			System.out.println("end");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
