package com.tcs.ilp.ghy.G06.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.ghy.G06.beans.Multiplex;
import com.tcs.ilp.ghy.G06.beans.User;
import com.tcs.ilp.ghy.G06.dao.CustomerDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		User uObj;
		
		if(scr!=null){
			
		
			if("login".equals(scr))
				{
				System.out.println("in login");
					try
					
					{
				
					String userIdString=request.getParameter("userId");
					
					int userId=Integer.parseInt(userIdString);
									
					String password=request.getParameter("password");
					
					uObj=new User(userId,password);
					Multiplex mObj=new Multiplex();
		
					String userRole=mObj.findUser(uObj);
			System.out.println("role"+userRole);
						if(userRole!=null)
							{
							System.out.println("in userrole");
								if("SuperAdmin".equals(userRole))
									{
										HttpSession session=request.getSession(true);
										session.setAttribute("user", uObj);
										response.sendRedirect("menu.jsp");
									}
								else if("Admin".equals(userRole))
									{	
										HttpSession session=request.getSession(true);
										session.setAttribute("user", uObj);
			
										//logic to check if first time login
										User uObj1=(User)((request.getSession(false)).getAttribute("user"));
										Multiplex mObj1=new Multiplex();
				
										String firstTimeLogin=mObj1.ifFirstTimeLogin(uObj1);
				
											if("YES".equals(firstTimeLogin))
												{
													response.sendRedirect("firsttimeLogin.jsp");
				
												}
											else if("NO".equals(firstTimeLogin))
												{
													response.sendRedirect("menu.jsp");
												}
								
									}
								else if("Customer".equals(userRole))
									{	
									System.out.println("incustomer");
										//logic to check if first time login
										//CustomerDao dao=new CustomerDao();
										//dao.storeData(uObj);
										HttpSession session=request.getSession(true);
										session.setAttribute("user", uObj);
				
										User uObj1=(User)(session.getAttribute("user"));
			
										Multiplex mObj1=new Multiplex();
										
										String firstTimeLogin=mObj1.ifFirstTimeLogin(uObj1);
				
				
											if("YES".equals(firstTimeLogin))
												{
													response.sendRedirect("firsttimeLogin.jsp");
				
												}
											else if("NO".equals(firstTimeLogin))
												{
													CustomerDao dao=new CustomerDao();
													// instead of storeData method create a method which would take the primary key of customer and return User Object
													User objUser=new User();
													try 
													{
														objUser = dao.retrieveData(uObj.getUserId());
													}
													catch (NullPointerException e) 
													{
														// TODO Auto-generated catch block
														ServletException see=new ServletException(e);
														throw see;
														
													} 
													catch (ClassNotFoundException cnf) 
													{
														// TODO Auto-generated catch block
														
														ServletException see=new ServletException(cnf);
														throw see;
													} 
													catch (SQLException sqle) 
													{
														// TODO Auto-generated catch block
														ServletException see=new ServletException(sqle);
														throw see;
													}//HttpSession session1=request.getSession(true);
													
													session.setAttribute("user", objUser);
													response.sendRedirect(request.getContextPath()+"/ShowCustomerProfile_new.jsp");
												}
									}
							}
						else
						{
							System.out.println("else");
							response.sendRedirect("homepage1.jsp");
						
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
			
		if("addcustomer".equals(scr))
		{
			String fname=request.getParameter("firstName");
			String mname=request.getParameter("middleName");
			String lname=request.getParameter("lastName");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String gender=request.getParameter("gender");
			String date=request.getParameter("date"); lname="sagar";
			String email=request.getParameter("email");
			String location=request.getParameter("location");
			
			//long mobile=Long.parseLong(request.getParameter("mobile"));
			request.getParameter("check1");
			
			
			
			
			request.getParameter("check2");
			
			
			User oUser=new User();
			oUser.setFirstName(fname);
			oUser.setMiddleName(mname);
			oUser.setLastName(lname);
			oUser.setAddress(address);
			oUser.setGender(gender);
			oUser.setDate(date);
		//	oUser.setMobileNo(mobile);
			oUser.setCity(city);
			oUser.setEmailId(email);
			oUser.setState(state);
			oUser.setLocation(location);
			
			PrintWriter pw=response.getWriter();
			CustomerDao dao=new CustomerDao();
			int rec=0;
			
			try {
				if(dao.checkEmailExist(oUser))
				{
					try 
					{
						rec=dao.AddCustomerDao(oUser);
					} 
					catch (NullPointerException e) 
					{
						// TODO Auto-generated catch block
						ServletException see=new ServletException(e);
						throw see;
						
					} 
					catch (ClassNotFoundException cnf) 
					{
						// TODO Auto-generated catch block
						
						ServletException see=new ServletException(cnf);
						throw see;
					} 
					catch (SQLException sqle) 
					{
						// TODO Auto-generated catch block
						ServletException see=new ServletException(sqle);
						throw see;
					}
					if(rec!=0)
					{
						dao.fetchCustomer(oUser);
						//HttpSession session=request.getSession(Boolean.TRUE);
						request.setAttribute("user", oUser);
						RequestDispatcher rd = request.getRequestDispatcher("ShowCustomerProfile.jsp");
						rd.forward(request, response);
					}
					else
					{
						pw.println("System could not create your account,please try after some time"+rec);
					}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("EmailIdAlreadyRegistered.jsp");
					rd.forward(request, response);
				}
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
}
}

