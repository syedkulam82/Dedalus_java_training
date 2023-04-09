package fifth.pac;

import fifth.pac.MainClass1.First;

class ThreadA extends Thread {
	public void run() {
		for (int i=1; i<5; i++) {
			System.out.println("i = " + i);
		}
	}
}

class ThreadB implements Runnable{

	public void run() {
		System.out.println("Method started");

		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(1000);
				System.out.println("i = " + i);
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("Method ended");
	}

}

class Thread1 {

	public  void print1_5() {
		System.out.println("Method started");
		synchronized(this) {
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(1000);
				System.out.println("i = " + i);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		}
		System.out.println("Method ended");
	}

}

class Thread2 extends Thread {

	Thread1 t1;

	public Thread2(Thread1 t1) {
		this.t1 = t1;
	}

	public void run() {
		t1.print1_5();

	}

}

class ChildThread implements Runnable {
	Thread t;

	ChildThread() {
		t = new Thread(this, "ChildThread");
		System.out.println("Thread created: " + t);
		t.start();
	}

	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println(t + "loop :" + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException obj) {
			System.out.println("Thread :" + t + "interrupted");
		}
	}
}

class First {
	int num;
	boolean available=false;
	public synchronized int put(int num) {
		if(available)
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}		
		
		this.num=num;
		
		String name = Thread.currentThread().getName();
		System.out.println(name+ " produces " +  num);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		available=true;
		notify();
		return num;
		
	}

	public synchronized int get() {
		if(!available)
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}	
		String name = Thread.currentThread().getName();
		System.out.println(name+ " consumes " +  num);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		available=false;
		notify();
			
		return num;
	}
}

class Producer implements Runnable {

	First f;

	public Producer(First f) {
		this.f = f;
		new Thread(this,"Producer").start();
	}

	@Override
	public void run() {
		
		int x = 1, i = 1;
		while (x < 10) {
		
			f.put(i++);
			x++;
		}
	}

}

class Consumer implements Runnable {

	First f;

	public Consumer(First f) {

		this.f = f;
		new Thread(this,"Consumer").start();
	}

	@Override
	public void run() {
		int x = 1;
		while (x < 10) {
			
			f.get();
			x++;
		}

	}

}

public class MainClass {
	public static void main(String[] args) {
		
		System.out.println("Main started..");
		ThreadB tb = new ThreadB();
		Thread t = new Thread(tb);
		t.run();
		System.out.println("Main ended..");
		
		
		
		System.out.println("Main started..");
		ThreadA ta1 = new ThreadA();
		ta1.run();
		
		ThreadA ta2 = new ThreadA();
		ta2.run();
		System.out.println("Main ended..");
		
		
		
		System.out.println("Main started");
		Thread1 t1 = new Thread1();
	
		Thread2 t2a = new Thread2(t1);
		Thread2 t2b = new Thread2(t1);
		t2a.start();
		t2b.start();
		System.out.println("Main ended");
		
		
		
		ChildThread obj = new ChildThread();
		System.out.println("Main Started");
		System.out.println(obj.t + "is alive ? : " + obj.t.isAlive());
		try {
			System.out.println("Main thread waiting for child thread to finish");
			obj.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread is interrupted");
		}
		System.out.println(obj.t + "is alive ? : " + obj.t.isAlive());
		System.out.println("Main Thread is exiting");
		
		
		First f = new First();
		new Producer(f);
		new Consumer(f);
	}
}
