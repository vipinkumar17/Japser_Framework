package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {
	@Test
	public void executeQuery() throws Throwable
	{
		//Step 1: Register the database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		//Step 2 : establish connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
		// Step 3 : Issue Create Statement
		Statement stat = con.createStatement();
		// Step 4 : Execute the query
		int result = stat.executeUpdate("insert into customers values (4 , 'Honey' , 'Gawande' , 'Bhopal')");
		if(result ==1)
		{
			
			System.out.println("Project is created successfully");
		}
		else
		{
			System.out.println("query Failed");
		}
	}
}