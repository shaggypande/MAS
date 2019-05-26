package com.tcs.ilp.ghy.G06.servlets;
import com.tcs.ilp.ghy.G06.beans.Admin;

import com.tcs.ilp.ghy.G06.beans.Multiplex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteAdminServlet
 */
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminServlet() {
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
		// TODO Auto-generated method stub
		
	   	String op=request.getParameter("operation");
		
		if(null != request.getSession())
		{
		HttpSession session=request.getSession(false);
	   	
	   	if(op!=null)
	   	{
	   		if("DeleteAdmin".equals(op))
	   		{
	   			try
	   			{
	   			
	   			String adminIdStr=request.getParameter("adminId");
	   			int adminId=Integer.parseInt(adminIdStr);
	   			Admin aAdmin =new Admin();
	   			aAdmin.setAdminId(adminId);
	   			Multiplex mMultiplex =new Multiplex();
	   			boolean bool=mMultiplex.fetch(aAdmin);
	   			if(bool==true)
	   			{
	   				int deletedAdmin=0;
	   				session.setAttribute("deletedAdmin",deletedAdmin);
	   				session.setAttribute("admin", aAdmin);
	   				
	   				RequestDispatcher rd=request.getRequestDispatcher("AdminDetails.jsp");
	   				rd.forward(request, response);
					
	   			}	
	   			else
	   			{
	   				
					response.sendRedirect("Error.jsp");
	   				
	   			}
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
	   			
	   		   	
	   		   	
	   		
	   		
	   		else if("Display".equals(op))
	   		{
	   			
	   			
	   				try
	   				{
	   				
	   				
	   				Admin aAdmin =new Admin();
	   				aAdmin=(Admin)session.getAttribute("admin");
	   				int adminIdStr=aAdmin.getAdminId();
	   				
	   				aAdmin.setAdminId(adminIdStr);
	   				
	   				Multiplex mMultiplex =new Multiplex();
	   				int deletedAdmin=(Integer)session.getAttribute("deletedAdmin");
	   				deletedAdmin=mMultiplex.deleteAdm(aAdmin);//deletedAdmin is no. of admin deleted
	   				
	   				
	   				
	   				session.setAttribute("deletedAdmin",deletedAdmin);
	   				response.sendRedirect("AdminDetails.jsp");
	   				
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
	   			
   		else
	   	{
   			response.sendRedirect("SessionInactive.jsp");
	   	}
	   	}
		else
		{
			PrintWriter pw=response.getWriter();
    		pw.print("Access denied.");
		}
	   			
	   		   	
	   }
    } 	
  	

