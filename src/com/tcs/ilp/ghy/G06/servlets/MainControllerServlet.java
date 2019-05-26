package com.tcs.ilp.ghy.G06.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class MainControllerServlet
 */
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

    	String scr=request.getParameter("operation");
		
		if(scr!=null)
		{
			if("homepage".equals(scr))
        	{
        		response.sendRedirect("homepage.jsp");
        	}

			else if("homepage4".equals(scr))
        	{
        		response.sendRedirect("homepage4.jsp");
        	}
    	   else if ("logAd".equals(scr)) 
    	  	{
    	  		response.sendRedirect("superadhome.jsp");
    	  		
    	  	}
    	  	else if ("underConstruction".equals(scr)) 
    	  	{
    	  		response.sendRedirect("pageunderconst.html");
    	  		
    	  	}
    	  	else if ("logOp".equals(scr)) 
    	  	{
    	  		response.sendRedirect("pageunderconst.html");
    	  		
    	  	}
    	  	else if ("contactus".equals(scr)) 
    	  	{
    	  		response.sendRedirect("contactus.jsp");
    	  		
    	  	}
    	  	else if ("bookTicket".equals(scr)) 
    	  	{
    	  		response.sendRedirect("pageunderconst.html");
    	  		
    	  	}
    		else if ("newsAndEvents".equals(scr)) 
    	  	{
    	  		response.sendRedirect("pageunderconst.html");
    	  		
    	  	}
    		else if ("editProfile".equals(scr)) 
    	  	{
    	  		response.sendRedirect("pageunderconst.html");
    	  		
    	  	}
    	  	else if ("forgotpassword".equals(scr) )
    	  	{
    	  		response.sendRedirect("pageunderconst.html");
    	  		
    	  	}
    	  	else if ("ManageAdmin".equals(scr)) 
    	  	{
    	  		response.sendRedirect("DeleteAdmin.jsp");
    	  		
    	  	}
    	  	else if ("abtus".equals(scr)) 
    	  	{
    	  		response.sendRedirect("aboutus.jsp");
    	  		
    	  	}
        	else if ("faqs".equals(scr)) 
    	  	{
    	  		response.sendRedirect("faqs.jsp");
    	  		
    	  	}
        	else if ("customer".equals(scr)) 
    	  	{
    			response.sendRedirect("RegCustomer.jsp");
    	  		
    	  	}
        	else if ("showProfileNew".equals(scr)) 
    	  	{
    			response.sendRedirect("ShowCustomerProfile_new.jsp");
    	  		
    	  	}
    	  	else if ("adminmovie".equals(scr)) 
    	  	{
    			response.sendRedirect("adminmovie.jsp");
    	  			
    	  	}
    	  	else if ("addup".equals(scr)) 
    	  	{
    			response.sendRedirect("Addupcoming.jsp");
    	  		
    	  	}
    	  	else if ("viewup".equals(scr)) 
    	  	{
    			response.sendRedirect("Showupcomingmovie.jsp");
    	  		
    	  	}
    	  	else if ("delup".equals(scr)) 
    	  	{
    	  		response.sendRedirect("DeleteUpcoming.jsp");
    	  		
    	  	}
    	  	else if ("homenoacc".equals(scr)) 
    	  	{
    			response.sendRedirect("noaccad.jsp");
    	  			
    	  	}
        	else if ("homenoaccmovies".equals(scr)) 
    	  	{
    			response.sendRedirect("noaccad.jsp");
    	  		
    	  	}
        	else if ("superadminmovie".equals(scr)) 
    	  	{
    			response.sendRedirect("superadminmoviemenu.jsp");
    	  		
    	  	}
    	  	else if ("menu".equals(scr)) 
    	  	{
    	  		response.sendRedirect("menu.jsp");
    	  		
    	  	}
        	else if ("noaccesstoadmin".equals(scr)) 
    	  	{
    	  		response.sendRedirect("noaccesstoadmin.jsp");
    	  		
    	  	}
        	else if ("superadminmenu".equals(scr)) 
    	  	{
    	  		response.sendRedirect("superadminmenu.jsp");
    	  		
    	  	}
        	else if ("adminmoviemenu".equals(scr)) 
    	  	{
    	  		response.sendRedirect("adminmoviemenu.jsp");
    	  		
    	  	}
        	else if ("sessionInactive".equals(scr)) 
    	  	{
    	  		response.sendRedirect("homepage.jsp");
    	  		
    	  	}
	     	else if("okAtDisplay".equals(scr)||"errorPage".equals(scr)||"cancelAtDisplay".equals(scr)||"show".equals(scr)||"deleteupcomingmovie".equals(scr))
    		{
    			if(request.getSession(false)!=null)
    			{
    		
    				if ("okAtDisplay".equals(scr))
    				{
    					RequestDispatcher rd = request.getRequestDispatcher("/DeleteAdmin.jsp");
    					rd.forward(request, response);
    				}
    	  	
    				else if ("cancelAtDisplay".equals(scr)) 
    				{
    					RequestDispatcher rd = request.getRequestDispatcher("/DeleteAdmin.jsp");
    					rd.forward(request, response);
    	  		
    				}
    				else if ("errorPage".equals(scr)) 
    	    	  	{
    	    	  		response.sendRedirect("DeleteAdmin.jsp");
    	    	  		
    	    	  	}
    				else if("show".equals(scr))
    	    	  	{
    	    		  
    	    	  		RequestDispatcher rd=request.getRequestDispatcher("ShowupcomingmovieServlet");
    	    	  		rd.forward(request, response);
    	    				  
    	    	  	}	
    			 	else if("deleteupcomingmovie".equals(scr))
    	    	  	{
    	    	  		 
    	    	  		RequestDispatcher rd=request.getRequestDispatcher("DeleteUpcomingMovieServlet");
    	    	  		rd.forward(request, response);
    	    		  
    	    	  	}
    	    	  		else if("noBack".equals(scr))
    	    	  	{
    			 		response.sendRedirect("NotAllowed.jsp");
    			 		
    	    		  
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
		
		else
		{
			
			PrintWriter pw=response.getWriter();
    		pw.print("Access denied.");
		}
    		
    		
    	
	}
		
	

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 

{
		// TODO Auto-generated method stub
	

		
		String scr=request.getParameter("operation");
		
		
		if(scr!=null)
		{
			//Login		
			if("login".equals(scr))
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("/LoginServlet");
				rd.forward(request, response);
					
			}
			
			//Register me
			else if("addcustomer".equals(scr))
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("/LoginServlet");
				rd.forward(request, response);
					
			}
		
			
			
			else if("choosePassword".equals(scr))
			{
				 	
				RequestDispatcher rd=request.getRequestDispatcher("/PasswordSetServlet");
				rd.forward(request, response);
			}
			 
			else if ("customer".equals(scr)) 
			{
				 
				response.sendRedirect("RegCustomer.jsp");
		  			
			}
		
			
			
			else if("DeleteAdmin".equals(scr)||"Display".equals(scr)||"addupcomingmovie".equals(scr)||"deleteupcomingmovie1".equals(scr))
			{
				if(request.getSession(false)!=null)
				{
					 if("DeleteAdmin".equals(scr))
					 {
						
						 RequestDispatcher rd=request.getRequestDispatcher("/DeleteAdminServlet");
						 rd.forward(request, response);
						 
					 }

					 else if("Display".equals(scr))
					 {
						 RequestDispatcher rd=request.getRequestDispatcher("/DeleteAdminServlet");
						 rd.forward(request, response);
					 }				
						
					else if("addupcomingmovie".equals(scr))
						{
							 
							RequestDispatcher rd=request.getRequestDispatcher("/AddupcomingmovieServlet");
							rd.forward(request, response);
						}
					else if ("deleteupcomingmovie1".equals(scr))
						{
							RequestDispatcher rd=request.getRequestDispatcher("/DeleteUpcomingMovieServlet");
							rd.forward(request, response);
						}
						 
					 
					 else
					 {
						 PrintWriter pw=response.getWriter();
						 pw.print("Access denied.");
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
		
		else
		{
			
			PrintWriter pw=response.getWriter();
    		pw.print("Access denied.");
		}
    	
}

		
		
		
	}
	
	
	
		
 




