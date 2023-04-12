package eight.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	@Override
	public void insertEmployee(Employee emp) {
	     
		try {
			con  = MyDBConnection.getDbConnection();
			ps=con.prepareStatement("insert into dalemp values(?,?)");
			
			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got inserted... ");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	@Override
	public void showEmployee() {	
		try {
			con  = MyDBConnection.getDbConnection();
			stmt= con.createStatement();
			rs = stmt.executeQuery("select * from dalemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
				
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateEmployee(Employee emp) {
	
		
	}

	@Override
	public void deleteEmployee(int eid) {
	
		
	}
}
