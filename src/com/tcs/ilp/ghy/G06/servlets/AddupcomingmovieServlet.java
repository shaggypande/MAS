package com.tcs.ilp.ghy.G06.servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.ghy.G06.beans.UpcominMovie;
import com.tcs.ilp.ghy.G06.dao.UpcomingMovieDao;

public class AddupcomingmovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddupcomingmovieServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op=request.getParameter("operation");
		
		
		if(op!=null)
	 {
		if("addupcomingmovie".equals(op))
		{
			
			 String moviename=request.getParameter("moviename");
			 String language=request.getParameter("language");
			 String date=request.getParameter("date");
			 String month=request.getParameter("month");
			 String year=request.getParameter("year");
			 
			
			 
			
			 UpcominMovie oupcomingmovie=new UpcominMovie();
			 oupcomingmovie.setMovieName(moviename);
			 
			 oupcomingmovie.setMonth(month);
			 
			 oupcomingmovie.setMovieLanguage(language);
			 
			 oupcomingmovie.setDate(date);
			 
			 oupcomingmovie.setYear(year);
			
			 
			
			
			 
			 UpcomingMovieDao omd=new UpcomingMovieDao();
			 
			int ab=0;
			try {
				ab = omd.Addupcoming(oupcomingmovie);
			  } 
			catch (ClassNotFoundException e) 
			{
				
				String message=e.getMessage();
   		   		ServletException see=new ServletException(message, e);
   		   	 	throw see;
			
			  } 
			catch (SQLException se) 
			{
				
				String message=se.getMessage();
   		   		ServletException see=new ServletException(message, se);
   		   	 	throw see;
			}
			catch(NullPointerException ne)
   		   	{
   		   		String message=ne.getMessage();
   		   		ServletException see=new ServletException(message, ne);
   				throw see;
   				
   		   	}
			 			
		
			
			if(ab!=0)
			{
			request.setAttribute("movie",  oupcomingmovie);
			request.getRequestDispatcher("./success.jsp").forward(request, response);
		    }
			if(ab==0)
			{
				request.setAttribute("movie1",  oupcomingmovie);
				request.getRequestDispatcher("./failure.jsp").forward(request, response);
			}
		
		
	  }

}
}
}
