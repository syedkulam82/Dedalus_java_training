package second.app;

public class Manager extends Employee {
	public String getName() {
		return "Sridhar B";
	}
	
	public String getEmployeeName() {
		return super.getName();
	}
}
