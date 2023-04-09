package fourth.pac;

import java.io.Serializable;
import java.util.Comparator;

//POJO -= Plain Old Java Object
public class Employee1 implements Serializable,Comparable<Employee1>{

	private int eid;
	private String ename;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}

	@Override
	public int compareTo(Employee1 e) {
		
		return this.eid - e.eid;
	
	}
	
	public static Comparator<Employee1> NameComparator = new Comparator<Employee1>() {

		@Override
		public int compare(Employee1 e1, Employee1 e2) {
			//return e1.getEid() -e2.getEid();
			return e1.getEname().compareTo(e2.getEname());
		}
	
	
	};

}


