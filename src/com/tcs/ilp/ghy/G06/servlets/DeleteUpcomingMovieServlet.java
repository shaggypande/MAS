package com.tcs.ilp.ghy.G06.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.ghy.G06.beans.UpcominMovie;
import com.tcs.ilp.ghy.G06.dao.UpcomingMovieDao;


public class DeleteUpcomingMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteUpcomingMovieServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String op=request.getParameter("Operation");
		if(op!=null)
	   	{
		if("deleteupcomingmovie".equals(op))
			{
			
			
			int movieId=Integer.parseInt(request.getParameter("movieid"));
			UpcominMovie oupcomingmovie=new UpcominMovie();
			oupcomingmovie.setMovieId(movieId);
			UpcomingMovieDao dmd=new UpcomingMovieDao();
			int res=0;
			try {
				res = dmd.FetchMovie(oupcomingmovie);
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
			HttpSession session=request.getSession();
			if(session!=null)
			{
			if(res!=0)
			{
				
				session.setAttribute("movie1",  oupcomingmovie);
				request.getRequestDispatcher("./movienotpresent.jsp").forward(request, response);
		    }
			if(res==0)
			{
				
                session.setAttribute("movie",  oupcomingmovie);
				request.getRequestDispatcher("./moviepresent.jsp").forward(request, response);
			}
			
	     }
		
	}

}
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String op=request.getParameter("operation");
		if(op!=null)
	   	{
		if("deleteupcomingmovie1".equals(op))
			{
			HttpSession session=request.getSession();
			UpcominMovie upcomingmovie=(UpcominMovie)session.getAttribute("movie");	
			UpcomingMovieDao dmd=new UpcomingMovieDao();
			int res=0;
			try {
				res = dmd.DeleteMovie(upcomingmovie);
			} 
			catch (ClassNotFoundException e) 
			{
				String message=e.getMessage();
   		   		ServletException see=new ServletException(message, e);
   		   	 	throw see;
			} 
			catch (SQLException se)
			{ String message=se.getMessage();
   		   		ServletException see=new ServletException(message, se);
   		   	 	throw see;
			}
			catch(NullPointerException ne)
   		   	{
   		   		String message=ne.getMessage();
   		   		ServletException see=new ServletException(message, ne);
   				throw see;
   				
   		   	}
			if(res!=0)
			{
				
				session.setAttribute("movie1",  upcomingmovie);
				request.getRequestDispatcher("./moviedelete.jsp").forward(request, response);
		    }
			if(res==0)
			{
				
                session.setAttribute("movie",  upcomingmovie);
				request.getRequestDispatcher("./movienotdelete.jsp").forward(request, response);
			}
			
			}
	}

}
}
