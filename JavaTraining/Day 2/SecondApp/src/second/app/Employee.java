package second.app;

public class Employee implements EmpInterface {
	
	String defaultName = "Shameem";
	
	public Employee() {
		this("Abdul");
	}
	
	public Employee(String name) {
		defaultName = name + " " + defaultName;
	}
	
	public String getDefaultName() {
		return defaultName;
	}
	
	public String getName() {
		return "Seenivasan";
	}
	
	public String getNameX(String name) {
		return name;
	}
	
	public String getNameX() {
		return "Elavarasi" + " " + this.getNameX("PannerSelvam");
	}
}
