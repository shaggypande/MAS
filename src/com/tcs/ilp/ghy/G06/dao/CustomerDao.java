package com.tcs.ilp.ghy.G06.dao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.tcs.ilp.ghy.G06.beans.User;


public class CustomerDao {
	//using AddCustomerDao function data of the new customer will be saved in two tables.
	public int AddCustomerDao(User oUser) throws NullPointerException, ClassNotFoundException, SQLException
	{
		InputStream ip=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			prop.load(ip);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String userId=prop.getProperty("userId");
		String password=prop.getProperty("password");
		String schema=prop.getProperty("schema");
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		Connection conn = null;
		String url=null;
		int rt1=0;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
			conn = DriverManager.getConnection(url,userId,password);
			conn.setAutoCommit(false);
			
			PreparedStatement ps= conn.prepareStatement("insert into customer_detail_table values(?,?,?,?,?,?,?,?,?,?,?,customer_Id.nextval,4)");
			ps.setString(1, oUser.getFirstName());
			ps.setString(2, oUser.getMiddleName());
			ps.setString(3, oUser.getLastName());
			ps.setString(4, oUser.getAddress());
			ps.setString(5, oUser.getCity());
			ps.setString(6, oUser.getState());
			ps.setString(7, oUser.getGender());
			ps.setString(8, oUser.getDate());
			ps.setLong(9, oUser.getMobileNo());
			ps.setString(10, oUser.getEmailId());
			ps.setString(11, oUser.getLocation());
			
			rt1=ps.executeUpdate();
			PreparedStatement ps2= conn.prepareStatement("select customerid from  customer_detail_table where customerid like 'customer_Id.CURRVAL' ");
			//ps2.setInt(1, oUser.getCustomerId());
			System.out.println(oUser.getCustomerId());
			//System.out.println(customer_Id.CURRVAL());
			PreparedStatement ps1= conn.prepareStatement("insert into USER_LOGIN_TBL values(customer_Id.CURRVAL,?,?,4,'YES')");
			ps1.setString(1, oUser.getFirstName());
			ps1.setString(2, Long.toString(oUser.getMobileNo()));
			ps1.executeUpdate();
		}
			
		catch(ClassNotFoundException ce)
		{
			throw ce;
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			try
			{
				conn.rollback();
				throw e;
			}
			catch(SQLException s)
			{
			throw s;
			}
		}
		catch (NullPointerException npe)
		{
			throw npe;
		}
		finally
		{
			try
			{
				//stmt.close();
				conn.commit();
				conn.close();
			}
			catch(SQLException e)
			{
				try 
				{
					conn.rollback();
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					throw e1;
				}
				catch(NullPointerException npe1)
				{
					throw npe1;
				}
			}
		}
		return rt1;
	}
	//checkEmailExist function will check weather the entered id by the new customer exists in database.
	public boolean checkEmailExist(User oUser) throws NullPointerException, ClassNotFoundException, SQLException
	{
		System.out.println("helloz");
		/*InputStream ip=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			prop.load(ip);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String userId=prop.getProperty("userId");
		String password =prop.getProperty("password");
		String schema= prop.getProperty("schema");
		String ipAddress= prop.getProperty("ipAddress");
		String port= prop.getProperty("port");
		String url = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			url = "jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
			conn = DriverManager.getConnection(url,userId,password);
			st =conn.createStatement();
			
			rs = st.executeQuery("select * from customer_detail_table where email_Id like '"+oUser.getEmailId()+"'");
			while (rs.next()) 
			{
				if(rs.getString(10).equals(oUser.getEmailId()))
				{
					return false;
				}
			}	
			
		} catch(ClassNotFoundException ce)
		{
			throw ce;
		}
		catch (SQLException e) 
		{
			throw e;
		}
		catch (NullPointerException npe)
		{
			throw npe;
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException e)
			{
				
					// TODO Auto-generated catch block
					throw e;
			}
			catch(NullPointerException npe1)
			{
					throw npe1;
			}
		}*/
	
		return true;
			
 	}
	//fetchCustomer function will set the customer Id in User bean class.
	public void fetchCustomer(User oUser) throws NullPointerException, ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		InputStream ip=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			prop.load(ip);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String userId=prop.getProperty("userId");
		String password=prop.getProperty("password");
		String schema=prop.getProperty("schema");
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String url = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
			conn = DriverManager.getConnection(url,userId,password);
			st =conn.createStatement();
			rs = st.executeQuery("select * from customer_detail_table");
			
			while (rs.next()) 
			{
				if((oUser.getEmailId()).equals(rs.getString(10)))
				{
					int customerId=Integer.parseInt(rs.getString(12));	
					oUser.setCustomerId(customerId);
				}
			
			}
		} catch(ClassNotFoundException ce)
		{
			throw ce;
		}
		catch (SQLException e) 
		{
			throw e;
		}
		catch (NullPointerException npe)
		{
			throw npe;
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException e)
			{
				
					// TODO Auto-generated catch block
					throw e;
			}
			catch(NullPointerException npe1)
			{
					throw npe1;
			}
		}
	}
	//retrieveData function will fetch data from database and save it in User bean class
	public User retrieveData(int userId) throws NullPointerException, ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		InputStream ip=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			prop.load(ip);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String userIdSql=prop.getProperty("userId");
		String password=prop.getProperty("password");
		String schema=prop.getProperty("schema");
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		User oUser=new User();
		
		String url = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
			conn = DriverManager.getConnection(url,userIdSql,password);
			st =conn.createStatement();
			rs = st.executeQuery("select * from customer_detail_table where customer_Id ="+userId);
			String firstName=null;	
			String lastName=null;
			long mobileNo=0;
			String city=null;
			String state=null;
			String emailId=null ;
			if(rs.next())
			{
				firstName=rs.getString(1);
				lastName= rs.getString(3);
				mobileNo= rs.getLong(9);
				city= rs.getString(5);
				state= rs.getString(6);
				emailId= rs.getString(10);
				userId=rs.getInt(12);
			}
			oUser.setFirstName(firstName);
			oUser.setLastName(lastName);
			oUser.setMobileNo(mobileNo);
			oUser.setCity(city);
			oUser.setState(state);
			oUser.setEmailId(emailId);
			oUser.setUserId(userId);
			
		} catch(ClassNotFoundException ce)
		{
			throw ce;
		}
		catch (SQLException e) 
		{
			throw e;
		}
		catch (NullPointerException npe)
		{
			throw npe;
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException e)
			{
				
					// TODO Auto-generated catch block
					throw e;
			}
			catch(NullPointerException npe1)
			{
					throw npe1;
			}
		}
		return oUser;
	}
	
}	
		
