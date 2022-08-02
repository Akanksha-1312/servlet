package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		 PrintWriter out = response.getWriter();      
		out.print("ThankYou For Visiting");
	}}
