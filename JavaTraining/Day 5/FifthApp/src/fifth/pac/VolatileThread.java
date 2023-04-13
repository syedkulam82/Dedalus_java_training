package com.pkg.thread;

public class VolatileThread {

	public static void main(String[] args) {
		CVolatileThread vThread = new CVolatileThread();
		vThread.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vThread.stopRunning();
	}
}

class CVolatileThread extends Thread {
	private volatile boolean vIndicator = true; 

	public void stopRunning() {
		vIndicator = false; 
	}

	@Override
	public void run() {
		while (vIndicator) { 
			System.out.println("Thread is running..." + vIndicator);
		}
		System.out.println("Thread stopped!!!" + vIndicator);
	}
}