package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery {
	@Test
	public void executeQuery() throws Throwable
	{
		//Step 1: Register the database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);   //register the Driver File to the Data Base

		//Step 2 : establish connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root"); //type jdbc connection in google
		//establish connection with the Data Base.
		
		// Step 3 : Issue Create Statement
		Statement stat = con.createStatement();
		
		// Step 4 : Execute the query
		ResultSet result = stat.executeQuery("Select * from customers;");
		while(result.next())
		{
			System.out.println(result.getString(4));
		}
	}
}
