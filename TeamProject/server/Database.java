package server;
//
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;


public class Database
{
	private Connection conn;
	//Add any other data fields you like – at least a Connection object is mandatory
	public Database()
	{	
		//Create properties object
		Properties property = new Properties();
		//Get the url/user/pass
		String url = property.getProperty("url");
		String user = property.getProperty("user");
		String pass = property.getProperty("password");

		//use a FileInputStream as input to the Properties object for reading the db.properties file
		FileInputStream fis = null;
		try 
		{
			fis = new FileInputStream("lab7out/db.properties");


		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Init the Properties object to fis
		try 
		{
			property.load(fis);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Create the connection
		try 
		{
			conn = DriverManager.getConnection(url,user,pass);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> query(String query)
	{
		//Create a statement from the connection object
		try 
		{
			Statement stmt=conn.createStatement();

			//Run the query using the executeQuery return a ResultSet
			ResultSet rs=stmt.executeQuery("select * from test1");

			//Need to retrieve each row from Result Set using getString
			//method to retrieve each field
			ArrayList<String> ReturnSet = new ArrayList<String>();
			String add;
			while(rs.next()) 
			{
				System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3));
				add = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3);
				ReturnSet.add(add);
			}
			
			
			//Create a string for each row so each field is, delimited
			//Store each String into an arrayList
			//Get metadata about the query
			ResultSetMetaData rmd;
			rmd = rs.getMetaData();
		
			//Get the # of columns
			int no_columns = rmd.getColumnCount();

			//Get a column name
			String name = rmd.getColumnName(1);
			//return the ResultSet
			return ReturnSet;

		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//If not return the ArrayList, return null
		return null;
		
	}

	public void executeDML(String dml) throws SQLException
	{
		//Create a statement from the connection
		Statement stmt = conn.createStatement();
		
		//Invoke the execute method on the statement
		stmt.execute(dml);
	}

}


