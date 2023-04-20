package designpattern;

public class SingletonA {
	private static Singleton instance = null;

	private String message; // Example variable

	private SingletonA() {
		// Private constructor to prevent instantiation from outside the class
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
