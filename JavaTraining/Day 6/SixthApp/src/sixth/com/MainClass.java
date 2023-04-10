package sixth.com;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class MainClass {
	public static void main(String[] args) {
		// JAVA 7
		/*
		Task task = new Task();
		task.connect();
		*/
		
		/*
		Runnable r = new MyTaskThread();
		Thread thread = new Thread(r);
		thread.start();
		*/
		
		/*
		Runnable r = new Runnable() {
			@Override
			public void run() {
				Task task = new Task();
				task.connect();
			}
		};
		Thread t1 = new Thread();
		t1.start();
		*/
		
		/*
		// JAVA 8
		Runnable r = () -> {
			Task task = new Task();
			task.connect();
		};
		Thread t1 = new Thread(r);
		t1.start();
		*/
		
		/*
		Thread trd = new Thread(() -> {
			Task task = new Task();
			task.connect();
		});
		trd.start();
		*/
		
		/*
		new Thread(() -> { new Task().connect(); }).start();
		*/
		
		/*
		new Thread(new Task()::connect).start();
		*/
		
		User u1 = new User(11, "Nilima", "nilima@gamil.com");
		User u2 = new User(12, "Praveen", "praveen@gamil.com");
		User u3 = new User(13, "Arika", "aarika@gamil.com");
		
		List<User> li = new ArrayList<User>();
		li.add(u1);
		li.add(u2);
		li.add(u3);
		
		System.out.println("User list - " + li);
		
		/*
		Iterator<User> i = li.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		*/
		
		/*
		li.forEach(lis -> System.out.println(lis));
		*/
		
		li.forEach(System.out::println);
	}
}
