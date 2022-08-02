package com.user;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Login extends HttpServlet{

		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
			 response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			          
			    String user=request.getParameter("user");  
			    String pass=request.getParameter("pass");  
			    
			          
			    if(validate(user, pass)){  
			        out.print("Welcome "+ user); 
			        RequestDispatcher rd=request.getRequestDispatcher("Logout.html");  
			        rd.include(request,response);  
		
			    }  
			    else{  
			        out.print("Sorry username or password error");  
			        RequestDispatcher rd=request.getRequestDispatcher("LoginPage.html");  
			        rd.include(request,response);  
			    }  
			          
			    out.close();  
			    }

		private boolean validate(String n, String p) {
			String user="admin";
			String pass="1234";
			if (user.equals(n) && pass.equals(p) )
				return true;
			return false;
		}  
		}

	

