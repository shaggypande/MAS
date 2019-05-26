package com.tcs.ilp.ghy.G06.beans;


import com.tcs.ilp.ghy.G06.dao.MultiplexDao;

import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;

/**
* The descriptive text that explaining the purpose and use of the class.
      * @author : 
      * @version : 1     
      * @Class name :Multiplex
      * @Creation Date :06/12/13	
     * @ History : Multiplex class is created to find user, set the password for user, check whether the user is first time logging in or not,fetching admin details and deleting admin.  
*/


public class Multiplex
 {
	/**
	 * Purpose: 	Purpose of this method is to check wehter admin exists or not
	 * @param		Admin <Method contains object of Admin type>
	 * @return		boolean <Method returns the either true or false>
	 * @exception 	throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since		<since the JDK version>
	 * @see			<reference to any other function called >
	 */
  
  public boolean fetch(Admin aAdmin) throws ClassNotFoundException, SQLException, NullPointerException, IOException
  {
	  boolean bool;
	  try
	  {
	
		  MultiplexDao mDao = new MultiplexDao();
		  bool=mDao.fetchAdmin(aAdmin);
		 
	  }
	  catch(ClassNotFoundException ce)
	  {
		  	throw ce;
	  }
	  catch(SQLException se)
	  {
			throw se;
			
	  }
	  catch(NullPointerException ne)
	  {
		    throw ne;
		  
	  }
	  catch(IOException e)
	  {
			throw e;
			
	  }
	  return bool;
	  
  }
  
  
  /**
	 * Purpose:	 	deleteAdm method is used is used to check whether the admin is exist or not 
	 * @param	 	Admin <Method contains the object of Admin class as parameter>
	 * @return		int <Method is returning integer value for whether the admin is deleted or not>
	 * @exception 	throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since		<since the JDK version>
	 * @see			<reference to any other function called >
	 */
  
  public int deleteAdm(Admin aAdmin) throws ClassNotFoundException, SQLException, NullPointerException, IOException
  {
	  int check=0;
	  try
	  {
		  MultiplexDao mDao = new MultiplexDao();
		  check=mDao.deleteAdmin(aAdmin);
		  

	  }
	  catch(ClassNotFoundException ce)
	  {
			
			throw ce;
			
	  }
	  catch(SQLException se)
	  {
			throw se;
			
	  }
	  catch(NullPointerException ne)
	  {
		  
		  throw ne;
		  
	  }
	  catch(IOException e)
	  {
			throw e;
			
	  }
	  
	  return check; 

  }
  
  /**
	 * Purpose:		purpose of this method is to find the user 
	 * @param		uObject  <Method contains the parameter uObject of type User>
	 * @return		String <This return the role of the user>
	 * @exception 	throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since		<since the JDK version>
	 * @see			<reference to any other function called >
	 */
  
  public String findUser(User uObject) throws ClassNotFoundException, SQLException, NullPointerException, IOException
	{
	String role=null;
	try
	{
	  MultiplexDao mDao = new MultiplexDao();
	  role=mDao.findUser(uObject);
	  System.out.println("role1"+role);
	}
	catch(ClassNotFoundException ce)
	  {
			
			throw ce;
			
	  }
	  catch(SQLException se)
	  {
			throw se;
			
	  }
	  catch(NullPointerException ne)
	  {
		  
		  throw ne;
		  
	  }
	  catch(IOException e)
	  {
			throw e;
			
	  }
	
	
	return role;
	}
	
  /**
	 * setPassword method is used is used to change the password of the user on first time login
	 * @param	  	User <Method contains userObj object of type User >
	 * @return		void 
	 * @exception   throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since		<since the JDK version>
	 * @see			<reference to any other function called >
	 */
  
	public void setPassword(User userObj) throws ClassNotFoundException, SQLException, NullPointerException, IOException
	{
		try
		{
		MultiplexDao mDao1=new MultiplexDao();
		mDao1.setPassword(userObj);
		}
		catch(ClassNotFoundException ce)
		  {
				
				throw ce;
				
		  }
		  catch(SQLException se)
		  {
				throw se;
				
		  }
		  catch(NullPointerException ne)
		  {
			  
			  throw ne;
			  
		  }
		  catch(IOException e)
		  {
				throw e;
				
		  }
		
	}
	
	/**
	 * setPassword method is used is used to check if the user is logging in for the first time
	 * @param	  	User <Method contains userObj object of type User >
	 * @return		String 
	 * @exception 	throws ClassNotFoundException,SQLException, NullPointerException, IOException
	 * @since		<since the JDK version>
	 * @see			<reference to any other function called >
	 */
	

	 
  	public String ifFirstTimeLogin(User uObj) throws ClassNotFoundException, SQLException, NullPointerException, IOException
	{
  		String firstLogin=null;
  		try
  		{
	
		MultiplexDao mDao2=new MultiplexDao();
		firstLogin=mDao2.ifFirstTimeLogin(uObj);
  		}
		catch(ClassNotFoundException ce)
		  {
				
				throw ce;
				
		  }
		  catch(SQLException se)
		  {
				throw se;
				
		  }
		  catch(NullPointerException ne)
		  {
			  
			  throw ne;
			  
		  }
		  catch(IOException e)
		  {
				throw e;
				
		  }
		
		return firstLogin;
	}
  }
