package com.tcs.ilp.ghy.G06.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.ghy.G06.beans.UpcominMovie;
import com.tcs.ilp.ghy.G06.dao.UpcomingMovieDao;


public class ShowupcomingmovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ShowupcomingmovieServlet()
    {
        super();
       
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String op=request.getParameter("Operation");
		if(op!=null)
	  {
		if("show".equals(op))
			{
			
			UpcomingMovieDao omd=new UpcomingMovieDao();
		    ArrayList<UpcominMovie> oupcoming = new ArrayList<UpcominMovie>();
			try {
				oupcoming= omd.Fetchupcoming();
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
			
			request.setAttribute("movie2",oupcoming);
			request.getRequestDispatcher("./showsuccess.jsp").forward(request, response);
		}
			
	}
	
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
