package com.sum;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


	public class AddNum2 extends HttpServlet{

		@Override
		public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			int i=Integer.parseInt(req.getParameter("n1"));
			int j=Integer.parseInt(req.getParameter("n2"));
			int k=i+j;
			//System.out.println(k);
			PrintWriter out=res.getWriter();
			out.println("sum="+k);
			
		}

	
}
