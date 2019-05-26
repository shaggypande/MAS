package com.tcs.ilp.ghy.G06.dao;
import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.tcs.ilp.ghy.G06.beans.Admin;
import com.tcs.ilp.ghy.G06.beans.User;
import java.lang.ClassNotFoundException;


/**
* The MultiplexDao contains methods for accessing data through database
      * @author : 
      * @version : 1     
      * @Class name :Multiplex Dao
      * @Creation Date :06/12/13	
     * @ History : The MultiplexDao contains methods for accessing data through database
*/

public class MultiplexDao {

	/**
	 * findUser()is used fetching user from database 
	 * @param	 <User><findUser() accepts parameter us of User type>
	 * @return	 String
	 * @exception 	throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since	 <since the JDK version>
	 * @see		<reference to any other function called >
	 */

	public String findUser(User uObject) throws ClassNotFoundException, SQLException, NullPointerException, IOException
	{
		
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			if(is!=null)
			{prop.load(is);}
			
		} catch (IOException e) {
			throw e;
		}
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String schema=prop.getProperty("schema");
		String userId=prop.getProperty("userId");
		String password=prop.getProperty("password");
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String roleName=null;
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema; 
			con=DriverManager.getConnection(url,userId,password);
		
			ps=con.prepareStatement("select role_tbl.role_name from role_tbl join user_login_tbl on role_tbl.role_id=user_login_tbl.role_id where user_login_tbl.user_id = ? and password like ?");
			ps.setInt(1, uObject.getUserId());
			ps.setString(2, uObject.getPassword());
			rs=ps.executeQuery();
				while(rs.next())
				{
					roleName=rs.getString(1);
					System.out.println("role2"+roleName);
					uObject.setRoleName(roleName);
				}
			}	
		
		catch(ClassNotFoundException ce)
		{
			throw ce;
			
		}
		catch(SQLException e1)
		{
			throw e1;
		}
		catch(NullPointerException ne)
		{
			throw ne;
		}
		finally
		{
			try
			{
			   if(rs!=null)
			   {
				   rs.close();
				   ps.close();
				   			 
			   }

			}
			catch(SQLException e1)
			{
				throw e1;
			}
			catch(NullPointerException ne)
			{
				throw ne;
			}
		}
		
		
return roleName;
	
	}
	
	

	
	/**
	 * setPassword() is used for updating password of the user.
	 * @param	<User> <Methods contains parameter us of type User>
	 * @return	void 
	 * @exception 	throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since	<since the JDK version>
	 * @see		<reference to any other function called >
	 */
	public void setPassword(User uObject) throws ClassNotFoundException, SQLException, NullPointerException, IOException
	{
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			if(is!=null)
			{prop.load(is);}
			
		} catch (IOException e) {
			throw e;
		}
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String schema=prop.getProperty("schema");
		String userId=prop.getProperty("userId");
		String password=prop.getProperty("password");	
				
		Connection con=null;
		PreparedStatement ps=null;
			
		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema; 
			con=DriverManager.getConnection(url,userId,password);
		
		
		con.setAutoCommit(false);
		
		ps=con.prepareStatement("update user_login_tbl set password=? where user_id=?");
		ps.setString(1, uObject.getNewPassword());
		ps.setInt(2, uObject.getUserId());
		ps.executeUpdate();
		
		
		ps=con.prepareStatement("update user_login_tbl set is_first_login=? where user_id=?");
		ps.setString(1,"NO");
		ps.setInt(2,uObject.getUserId());
		ps.executeUpdate();
		con.commit();
		
		}	
		
		catch(ClassNotFoundException ce)
		{
			throw ce;
			
		}
		catch(SQLException se)
		{
			try
			{
				con.rollback();
				
				throw se;
			}
			catch(SQLException e1)
			{
				
				throw e1;
			}
			
		}
		catch(NullPointerException ne)
		{
			
			throw ne;
			
		}
			
		
		finally
		{
			try
			{
		
			ps.close();
			con.close();
			}
			
			catch(SQLException se1)
			{
				
				throw se1;
			}
			catch(NullPointerException ne)
			{
				
				throw ne;
				
			}
			
			
			
		}
	
		}
		
	 
	

	
	/**
	 * ifFirtTimeLogin() method is used for checking whether the user is login in for the first time or not.
	 * @param	User Method contains parameter us of type User
	 * @return	String 
	 * @exception throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since	<since the JDK version>
	 * @see		<reference to any other function called >
	 */
	
	public String ifFirstTimeLogin(User uObject) throws ClassNotFoundException, SQLException, NullPointerException, IOException
	{
		
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			if(is!=null)
			{prop.load(is);}
			
		} catch (IOException e) {
			throw e;
		}
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String schema=prop.getProperty("schema");
		String userId=prop.getProperty("userId");
		String password=prop.getProperty("password");	
						
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String result=null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
	
			
			String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema; 
			con=DriverManager.getConnection(url,userId,password);
			ps=con.prepareStatement("select is_first_login from user_login_tbl where user_id=?");
			ps.setInt(1, uObject.getUserId());
			rs=ps.executeQuery();
		
				while(rs.next())
				{
					result=rs.getString(1);
				}
			
		
			}	
		
		catch(ClassNotFoundException ce)
		{
			throw ce;
			
		}
		catch(SQLException e1)
		{
			throw e1;
		}
		catch(NullPointerException ne)
		{
			throw ne;
		}
		finally
		{
			try
			{
			   if(rs!=null)
			   {
				   rs.close();
				   ps.close();
				   			 
			   }

			}
			catch(SQLException e1)
			{
				throw e1;
			}
			catch(NullPointerException ne)
			{
				throw ne;
			}
		}
		
		return result;
	}
	
	

	
	/**
	 * Purpose: purpose of the method is to fetch the admin details.
	 * @param		Admin <Method accepts the object of Admin >
	 * @return		Boolean <Method return either true or false values>
	 * @exception 	throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since			<since the JDK version>
	 * @see			<reference to any other function called >
	 */

		public boolean fetchAdmin(Admin aAdmin)throws ClassNotFoundException, SQLException, NullPointerException, IOException

		{
			InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
			Properties props=new Properties();
			try
			{
				if(is!=null)
				{
				 props.load(is);
				}
			
			} 
			
			catch (IOException e)
			{
				throw e;
			}
			String ipAddress=props.getProperty("ipAddress");
			String port=props.getProperty("port");
			String schema=props.getProperty("schema");
			String userid=props.getProperty("userId");
			String password=props.getProperty("password");
						
			Connection conn=null;
			String userName= null;
			String lastName=null;
			String gender=null;
			String emailId=null;
			String city=null;
			String dob=null;
			String location=null;
			PreparedStatement ps=null;
			PreparedStatement ps1=null;
			int roleId=0;
			int adminId = 0;
			ResultSet rs=null;
			ResultSet result=null;
			try
			{
				Class.forName("oracle.jdbc.OracleDriver");
				String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
				conn=DriverManager.getConnection(url,userid,password);
				ps1=conn.prepareStatement("Select role_id from user_login_tbl where user_id=? ");
				ps1.setInt(1,aAdmin.getAdminId());
				
				result=ps1.executeQuery();
				if(result!=null)
				{
			      while(result.next())
			       { 
					roleId=result.getInt("role_id");
					if(roleId!=0)
					{
						ps=conn.prepareStatement("Select * from user_details_tbl where user_id=(select user_id from user_login_tbl where role_id=? and user_id =?)");
						ps.setInt(1,roleId);
						ps.setInt(2,aAdmin.getAdminId());
						rs=ps.executeQuery();
						if(rs!=null)
						{
					      while(rs.next())
					       { 
							adminId= rs.getInt("user_id");
							aAdmin.setAdminId(adminId);
							userName= rs.getString("first_name");
							aAdmin.setFirstName(userName);
							lastName= rs.getString("last_name");
							aAdmin.setLastName(lastName);
							gender= rs.getString("gender");
							aAdmin.setGender(gender);
							dob=rs.getString("DOB");
							String DateOfBirth=dob.substring(0,10);
							aAdmin.setDateOfBirth(DateOfBirth);
							emailId=rs.getString("email_id");
							aAdmin.setEmailId(emailId);
							city=rs.getString("city");
							aAdmin.setCity(city);
							location=rs.getString("location");
							aAdmin.setLocation(location);
							
							return true;
					       }
						}
					}
				}
   			  }
			}
			//HANDLE EXCEPTIONS
			catch(ClassNotFoundException ce)
			{
				throw ce;
				
			}
			catch(SQLException e1)
			{
				throw e1;
			}
			catch(NullPointerException ne)
			{
				throw ne;
			}
			finally
			{
				try
				{
				   if(rs!=null)
					{
					  rs.close();
					  ps.close();
					if(result!=null)
					{
					 result.close();
					 ps1.close();
					 conn.close();
				    }
			      }
	
			   }
			catch(SQLException e1)
		     {
		    	throw e1;
		     }
		   catch(NullPointerException ne)
			{
			  throw ne;
			}
		  }
	     return false;
		}
		/**
		 * Purpose of the deleteAdmin(Admin aAdmin) method is to delete the admin from the database
		 * @param		Admin <The method contains the object aAdmin of Admin type as parameter>
		 * @return		int <function retuns inegeer value either 1 or 0>
		 * @exception 	throws ClassNotFoundException, SQLException, NullPointerException, IOException
		 * @since		<since the JDK version>
		 * @see			<reference to any other function called >
		 */
	public int deleteAdmin(Admin aAdmin) throws ClassNotFoundException, SQLException, NullPointerException, IOException
	{
		
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try
		{
			if(is!=null)
			{prop.load(is);}
		}
		catch(IOException e)
		{
			throw e;
		}
		
		String userId=prop.getProperty("userId");
		String password=prop.getProperty("password");
		String ipAddress=prop.getProperty("ipAddress");
		
		String port=prop.getProperty("port");
		String schema=prop.getProperty("schema");
		
		
		
		Connection conn=null;
		PreparedStatement ps=null;
		int n=0;//no. of admin deleted

		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema; 
			conn=DriverManager.getConnection(url,userId,password);
			conn.setAutoCommit(false);
			ps=conn.prepareStatement("delete from user_details_tbl where user_id=?");
			ps.setInt(1, aAdmin.getAdminId());
			n=ps.executeUpdate();
			
			if(n==1)
			{
				ps=conn.prepareStatement("delete from user_login_tbl where user_id=?");
				ps.setInt(1, aAdmin.getAdminId());
				n=ps.executeUpdate();
				conn.commit();
			}
			
			
			
			
		}
		
		catch(ClassNotFoundException ce)
		{
			
			
			throw ce;
			
		}
		catch(SQLException se)
		{
			try
			{
				conn.rollback();
				
				throw se;
			}
			catch(SQLException e1)
			{
				
				throw e1;
			}
			
		}
		catch(NullPointerException ne)
		{
			
			throw ne;
			
		}
			
		
		finally
		{
			try
			{
		
			ps.close();
			conn.close();
			}
			
			catch(SQLException se1)
			{
				
				throw se1;
			}
			catch(NullPointerException ne)
			{
				
				throw ne;
				
			}
			
			
			
		}
				
		return n;
	}
}
