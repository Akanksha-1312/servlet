package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			ServletContext context = config.getServletContext();
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dburl"),
					context.getInitParameter("dbuser"), context.getInitParameter("dbpassword"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");


		try (Statement statement = connection.createStatement();) {

			String query = "update user set password='" + password + "' where email = '" + email + "'";
			System.out.println("Query being executed: " + query);
			int rowsUpdated = statement.executeUpdate(query);
			System.out.println("Number of rows Update: " + rowsUpdated);

			PrintWriter pw = response.getWriter();
			pw.write("User updated successfully");
			pw.write("<p><a href=\"userhome.html\">Home</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void destroy() {
		try {
			System.out.println("UpdateUserSevlet.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}