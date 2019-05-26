package com.tcs.ilp.ghy.G06.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.tcs.ilp.ghy.G06.beans.UpcominMovie;

public class AddUpcomingMovieDao {
	public int Addupcoming(UpcominMovie oupcomingmovie)
	{
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("mas.properties");
		Properties prop=new Properties();
		
		try {
			prop.load(is);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		prop.getProperty("userid");
		prop.getProperty("password");
		
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
			 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			String url="jdbc:oracle:thin:@01hw185178:1521:tcsghy";
			con=DriverManager.getConnection(url,"G064pd","tcsghy");
			st=con.createStatement();
			
			int randomNumber=(int)(Math.random()*9999);
			
			if(randomNumber<=10000)
			{
				randomNumber=randomNumber+1;
			}
			rs=st.executeQuery("select * from upcomingmovie where movie_name='"+oupcomingmovie.getMovieName()+"'");
			
			if(!rs.next())
			{
			p=st.executeUpdate("insert into upcomingmovie values("+randomNumber+",'"+oupcomingmovie.getMovieName()+"','"+oupcomingmovie.getMovieLanguage()+"','"+oupcomingmovie.getDate()+"','"+oupcomingmovie.getMonth()+"','"+oupcomingmovie.getYear()+"')");
			oupcomingmovie.setMovieId(randomNumber);
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
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				st.close();
				con.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
	