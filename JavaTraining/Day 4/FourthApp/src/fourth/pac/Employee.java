package fourth.pac;

import java.io.Serializable;

public class Employee implements Serializable {

	String ENO;
	String ENAME;
	
	public String getEno() {
		return ENO;
	}
	
	public String getEname() {
		return ENAME;
	}
	
	public void setEno(String eno) {
		ENO = eno;
	}
	
	public void setEname(String ename) {
		ENAME = ename;
	}
}
