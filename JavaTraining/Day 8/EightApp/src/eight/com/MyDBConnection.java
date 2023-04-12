package eight.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection {
	static Connection con;

	public static Connection getDbConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "syedkulam", "syedkulam");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}

	public static void main(String[] args) {
		System.out.println(getDbConnection());
		
		EmployeeDaoImpl empImp = new EmployeeDaoImpl();
		
		Employee emp = new Employee();
		emp.setEid(1554099);
		emp.setEname("Syed Kulam A.");
		
		empImp.insertEmployee(emp);
		
		empImp.showEmployee();
	}

}
