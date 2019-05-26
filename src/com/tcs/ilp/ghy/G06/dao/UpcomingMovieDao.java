package com.tcs.ilp.ghy.G06.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.tcs.ilp.ghy.G06.beans.UpcominMovie;



/**
* The UpcomingMovieDao contains methods for accessing data through database
      * @author : 
      * @version : 1     
      * @Class name :Multiplex Dao
      * @Creation Date :06/12/13	
     * @ History : The UpcomingMovieDao contains methods for accessing data through database
*/


public class UpcomingMovieDao {
	
	/**
	 * Addupcoming((UpcominMovie oupcomingmovie)is used adding Upcoming movie in the database 
	 * @param	 <UpcominMovie><Addupcoming((UpcominMovie oupcomingmovie) accepts parameter us of UpcominMovie type>
	 * @return	 Integer
	 * @since	 <since the JDK version>
	 * @see		<reference to any other function called >
	 */

	public int Addupcoming(UpcominMovie oupcomingmovie) throws SQLException, ClassNotFoundException
	{
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			prop.load(is);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		String userid=prop.getProperty("userId");
		String password=prop.getProperty("password");
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String schema=prop.getProperty("schema");
		Connection con=null;
		Statement st=null;
	    ResultSet rs=null;
		int p=1;
		try
		{
			
			try
			{
			Class.forName("oracle.jdbc.OracleDriver");
			}
			 catch (ClassNotFoundException e)
			 {
				throw e;
					
			 }
			String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
			con=DriverManager.getConnection(url,userid,password);
			con.setAutoCommit(false);
			st=con.createStatement();
			
			int randomNumber=(int)(Math.random()*9999);
			
			if(randomNumber<=10000)
			{
				randomNumber=randomNumber+1;
			}
			rs=st.executeQuery("select * from upcomingmovie where movie_name='"+oupcomingmovie.getMovieName()+"' and movie_language='"+oupcomingmovie.getMovieLanguage()+"'");
			
			if(!rs.next())
			{
			p=st.executeUpdate("insert into upcomingmovie values("+randomNumber+",'"+oupcomingmovie.getMovieName()+"','"+oupcomingmovie.getMovieLanguage()+"','"+oupcomingmovie.getDate()+"','"+oupcomingmovie.getMonth()+"','"+oupcomingmovie.getYear()+"')");
			oupcomingmovie.setMovieId(randomNumber);
			con.commit();
			}
			else
			{
			    p=0;
			
				int MovieID = rs.getInt(1);
				
				String Movie_name= rs.getString(2);
				String Movie_language = rs.getString(3);
				String Movie_date = rs.getString(4);
				String Movie_month = rs.getString(5);
				String Movie_year = rs.getString(6);
				oupcomingmovie.setMovieId(MovieID);
				oupcomingmovie.setMovieName(Movie_name);
				oupcomingmovie.setMovieLanguage(Movie_language);
				oupcomingmovie.setDate(Movie_date);
				oupcomingmovie.setMonth(Movie_month);
				oupcomingmovie.setYear(Movie_year);
				
				
			
			
			}
		}
		 catch (SQLException se) 
		 {
			
			 
				throw se;
		 }
		 catch(NullPointerException ne)
			{
				throw ne;
			}
		 
		finally
		{
			try
			{
				rs.close();
				st.close();
				con.close();
				
			}
			catch(SQLException se)
			{
				 
					throw se;
			}
			catch(NullPointerException ne)
			{
				throw ne;
			}
		}
		return p;
	}
	
	
	
	

	/**
 * Fetchupcoming()is used fetching all Upcoming movies from database 
	 * @param	 <><Fetchupcoming()doesn't accepts any parameter>
	 * @return	 ArrayList<UpcominMovie>
	 * @since	 <since the JDK version>
	 * @see		<reference to any other function called >
	 */

	public ArrayList<UpcominMovie> Fetchupcoming() throws ClassNotFoundException, SQLException
	{
		
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			prop.load(is);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String userid=prop.getProperty("userId");
		String password=prop.getProperty("password");
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String schema=prop.getProperty("schema");
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				
				
			    ArrayList<UpcominMovie> oupcoming = new ArrayList<UpcominMovie>();
				try
				{
					
					try
					{
					Class.forName("oracle.jdbc.OracleDriver");
					}
					 catch (ClassNotFoundException e)
					 {
						    throw e;
							
					 }
					 String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
						con=DriverManager.getConnection(url,userid,password);
					
					st=con.createStatement();
					
				
					rs=st.executeQuery("select * from upcomingmovie order by movie_name");
					
					while (rs.next()) 
					{
						UpcominMovie  oupcomingmovie=  new UpcominMovie();
						int MovieID = rs.getInt(1);
						String Movie_name= rs.getString(2);
						
						String Movie_language = rs.getString(3);
						String Movie_date = rs.getString(4);
						String Movie_month = rs.getString(5);
						String Movie_year = rs.getString(6);
						oupcomingmovie.setMovieId(MovieID);
						oupcomingmovie.setMovieName(Movie_name);
						oupcomingmovie.setMovieLanguage(Movie_language);
						oupcomingmovie.setDate(Movie_date);
						oupcomingmovie.setMonth(Movie_month);
						oupcomingmovie.setYear(Movie_year);
						oupcoming.add(oupcomingmovie);
						
						
						
					}
				}
				 catch (SQLException e) 
				 {
					
					  throw e;
				  }
				 catch(NullPointerException ne)
					{
						throw ne;
					}
				finally
				{
					try
					{
						rs.close();
						st.close();
						con.close();
						
					}
					catch(SQLException se)
					{
						 
							throw se;
					}
					catch(NullPointerException ne)
					{
						throw ne;
					}
				}
		
			
			return oupcoming ;
	}
	
	public	int FetchMovie(	UpcominMovie oupcomingmovie) throws SQLException, ClassNotFoundException
	{
		
		
		/**
		 * FetchMovie((UpcominMovie oupcomingmovie)is used fetch Upcoming movie from the database 
		 * @param	 <UpcominMovie><FetchMovie((UpcominMovie oupcomingmovie) accepts parameter us of UpcominMovie type>
		 * @return	 Integer
		 * @since	 <since the JDK version>
		 * @see		<reference to any other function called >
		 */

		
		
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			prop.load(is);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		String userid=prop.getProperty("userId");
		String password=prop.getProperty("password");
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String schema=prop.getProperty("schema");
		Connection con=null;
		PreparedStatement ps=null;
		
		ResultSet movieDetails=null;
		
		int response=0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
	
			String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
			con=DriverManager.getConnection(url,userid,password);	
		
		ps=con.prepareStatement("select movie_name,movie_language,movie_date,movie_month,movie_year from upcomingmovie where movie_id=?");
		ps.setString(1, ""+oupcomingmovie.getMovieId());
		
		movieDetails=ps.executeQuery();
		if(movieDetails.next())
		{
			String movie_name=movieDetails.getString(1);
			
			String movie_language=movieDetails.getString(2);
			String movie_date=movieDetails.getString(3);
			String movie_month=movieDetails.getString(4);
			String movie_year=movieDetails.getString(5);
			oupcomingmovie.setMovieName(movie_name);
			oupcomingmovie.setMovieLanguage(movie_language);
			oupcomingmovie.setDate(movie_date);
			oupcomingmovie.setMonth(movie_month);
			oupcomingmovie.setYear(movie_year);
			
			}	
		else
		{
			response=1;
		}
		}
		
		catch(ClassNotFoundException e)
		{
			 
				throw e;
				
		}
		catch(SQLException se)
		{
			    
				throw se;
		}
		catch(NullPointerException ne)
		{
			throw ne;
		}
		finally
		{
			try
			{
	       movieDetails.close();
			ps.close();
			con.close();
			}
			catch(SQLException se)
			{
				
				throw se;
			}
			catch(NullPointerException ne)
			{
				throw ne;
			}
		}
		return response;
	}
	
	
	public int DeleteMovie(UpcominMovie oupcomingmovie) throws ClassNotFoundException, SQLException
	{
		
		

		/**
		 * DeleteMovie((UpcominMovie oupcomingmovie)is used delete Upcoming movie from the database 
		 * @param	 <UpcominMovie><DeleteMovie((UpcominMovie oupcomingmovie) accepts parameter us of UpcominMovie type>
		 * @return	 Integer
		 * @since	 <since the JDK version>
		 * @see		<reference to any other function called >
		 */
		
		
		
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("MAS.properties");
		Properties prop=new Properties();
		try {
			prop.load(is);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		String userid=prop.getProperty("userId");
		String password=prop.getProperty("password");
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String schema=prop.getProperty("schema");
		Connection conn=null;
		PreparedStatement ps=null;
		int response=0;

		
		try
		{
			
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@"+ipAddress+":"+port+":"+schema;
			conn=DriverManager.getConnection(url,userid,password);
			conn.setAutoCommit(false);
			ps=conn.prepareStatement("delete from upcomingmovie where movie_id=?");
			ps.setInt(1, oupcomingmovie.getMovieId());
			response=ps.executeUpdate();
			
			
		}
		catch(ClassNotFoundException e)
		{
			 
				throw e;
			
		}
		catch(NullPointerException ne)
		{
			throw ne;
		}
		catch(SQLException se)
		{
			try
			{
				conn.rollback();
			
			}
			catch(SQLException e1)
			{
				
					throw e1;
			}
			catch(NullPointerException ne)
			{
				throw ne;
			}
			
			throw se;
		}
		
		finally
		{
			try
			{
		
			ps.close();
			conn.close();
			}
			catch(SQLException se)
			{
			
				throw se;
			}
			catch(NullPointerException ne)
			{
				throw ne;
			}
			
		}


		return response;
	}

}
	
	
	
	
	

