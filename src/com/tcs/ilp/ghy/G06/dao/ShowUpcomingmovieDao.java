package com.tcs.ilp.ghy.G06.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tcs.ilp.ghy.G06.beans.UpcominMovie;

public class ShowUpcomingmovieDao {

	public ArrayList<UpcominMovie> Fetchupcoming()
	{
		
		
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				int p=1;
				
			    ArrayList<UpcominMovie> oupcoming = new ArrayList<UpcominMovie>();
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
					con=DriverManager.getConnection(url,"G064PD","tcsghy");
					st=con.createStatement();
					
				
					rs=st.executeQuery("select * from upcomingmovie");
					//rs.next();
					//System.out.print(""+rs.getString(2));
					
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
		
			
			return oupcoming ;
		}
	}
