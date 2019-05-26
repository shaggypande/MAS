package com.tcs.ilp.ghy.G06.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.ghy.G06.beans.UpcominMovie;

public class DeleteUpcomingMovieDao {
 
	
	public	int FetchMovie(	UpcominMovie oupcomingmovie)
	{
		
		
		Connection con=null;
		PreparedStatement ps=null;
		
		ResultSet movieDetails=null;
		
		int response=0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
	
			
		String url="jdbc:oracle:thin:@01hw185178:1521:tcsghy"; 
		con=DriverManager.getConnection(url,"G064pd","tcsghy");
		ps=con.prepareStatement("select movie_name,movie_language,movie_date,movie_month,movie_year from upcomingmovie where movie_id=?");
		ps.setString(1, ""+oupcomingmovie.getMovieId());
		
		movieDetails=ps.executeQuery();
		if(!movieDetails.next())
		{
			response=1;
		}
		
		
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
		
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	
		return response;
	}
	public int DeleteMovie(UpcominMovie oupcomingmovie)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int response=0;

		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@01hw185178:1521:tcsghy"; 
			conn=DriverManager.getConnection(url,"G064PD","tcsghy");
			conn.setAutoCommit(false);
			ps=conn.prepareStatement("delete from upcomingmovie where movie_id=?");
			ps.setInt(1, oupcomingmovie.getMovieId());
			response=ps.executeUpdate();
			
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(SQLException e)
		{
			try
			{
				conn.rollback();
				System.out.println("Could not delete due to SQL exception");
			}
			catch(SQLException e1)
			{
				e.printStackTrace();
			}
			
			e.printStackTrace();
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
				se.printStackTrace();
			}
			
		}


		return response;
	}

}
