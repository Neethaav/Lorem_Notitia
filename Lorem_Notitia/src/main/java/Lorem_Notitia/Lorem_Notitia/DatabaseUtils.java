package Lorem_Notitia.Lorem_Notitia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
/*	@Test
	 public void getExecuteQuery() throws SQLException
	 {
	  //Step 1: Register the database
	  Driver driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  
	  //Step 2: establish Connection with database
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	  
	  //Step 3: Issue create statement
	  Statement stat=con.createStatement();
	  
	  //Step 4: Execute any query
	  ResultSet result = stat.executeQuery("select * from Customer;");
	  while(result.next())
	  {
	   System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6));
	  }
	  
	  //Step 5: Close database connection
	  con.close();
	 }
	*/
	@Test
	public void getExcuteDelete() throws SQLException 
	{
		Connection con1 = null;
		try
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
			Statement sta = con1.createStatement();
			sta.executeUpdate(" delete from customer where CustomerName='Cardinal';");
			System.out.println("deleted a row successfully");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con1.close();
			System.out.println("Connection got closed");
		 }
	}
	
	/*
	@Test
	 public void getExecuteUpdate() throws SQLException
	 {
	  //Step 1: Register the database
		Connection con =null;
		try {
	  Driver driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  
	  //Step 2: establish Connection with database
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	  
	  //Step 3: Issue create statement
	  Statement stat=con.createStatement();
	  
	  //Step 4: Execute any query
	  int result = stat.executeUpdate("insert into Customer values('Neetha','Hiremath','#335','Mysore','230022','India');");
	  if(result==1)
	  {
		  System.out.println("Project is successfully created");
	  }
	  else
	  {
		  System.out.println("Project created failed");
	  }
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	  
	  //Step 5: Close database connection
	  finally {
		con.close();
		System.out.println("Connection got closed");
	 }

	 }
	*/
	
	
	@Test
	public void getExecuteValid() throws SQLException {
		Connection con = null;
		try {
			// Register the database
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref); 
			
			//establish the connection with Database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
			
			//issue create statements
			Statement stat=con.createStatement();
			
			String s=new String("Neetha");
		
			//execute any query
			 ResultSet result = stat.executeQuery("select * from Customer;");
			  while(result.next())
			  {
				  //Validating the Data
				  if(result.getString(1).equals(s))
				  {
					  System.out.println("Data is present in Database");
				  }
				  else
				  {
					  System.out.println("Data is not present in database");
				  }
			  }  
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			con.close();
			System.out.println("Connection got closed");
		 }
	}
	
	
}
