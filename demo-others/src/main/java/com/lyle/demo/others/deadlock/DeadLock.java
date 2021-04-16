package com.lyle.demo.others.deadlock;

public class DeadLock {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
		Thread thread1 = new Thread(new DeadLock.Thread1());
		Thread thread2 = new Thread(new DeadLock.Thread2());
		thread1.start();
		thread2.start();
	}

	public static class Thread1 implements Runnable {

		public void run() {
			synchronized (DeadLock.lock1) {
				System.out.println("1");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (DeadLock.lock2) {
					System.out.println("2");
				}
			}
		}
	}

	public static class Thread2 implements Runnable {

		public void run() {
			synchronized (DeadLock.lock2) {
				System.out.println("3");
				synchronized (DeadLock.lock1) {
					System.out.println("4");
				}
			}
		}

	}

}
