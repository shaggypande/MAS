package com.tcs.ilp.ghy.G06.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.ghy.G06.beans.Multiplex;
import com.tcs.ilp.ghy.G06.beans.User;

/**
 * Servlet implementation class PasswordSetServlet
 */
public class PasswordSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String scr=request.getParameter("operation");
		if(scr!=null)
		{
		if("choosePassword".equals(scr))
		{	
			try
			
			{

			User uObj=(User)((request.getSession(false)).getAttribute("user"));
			int id=uObj.getUserId();
			
			String password1=request.getParameter("password1");
			String password2=request.getParameter("password2");
			User userObj=new User(id,password1,password2);
			Multiplex mulObj=new Multiplex();
			mulObj.setPassword(userObj);
			RequestDispatcher rd = request.getRequestDispatcher("homepage2.jsp");
			rd.forward(request, response);		
			
		}
			catch(ClassNotFoundException ce)
   		   	{
   				String message=ce.getMessage();
   		   		ServletException see=new ServletException(message, ce);
   		   		throw see;
   					
   		   	}
   		   	catch(SQLException se)
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
   		  	catch(IOException e)
   		  	{
   		   		String message=e.getMessage();
   		   		ServletException see=new ServletException(message, e);
   				throw see;
   				
   		   	}
   		  	catch(Exception e)
   		  	{
   		   		String message=e.getMessage();
   		   		ServletException see=new ServletException(message, e);
   				throw see;
   				
   		   	}
		}
	}
		
	}
}
