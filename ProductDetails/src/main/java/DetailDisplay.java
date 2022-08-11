import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Details") 
public class DetailDisplay extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		int pId =Integer.parseInt( request.getParameter("pId"));
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
		
			e1.printStackTrace();
		}
		

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
				PreparedStatement statement = connection.prepareStatement("select * from productdetail where pId=?")) {
			statement.setInt(1,pId);
			ResultSet rs=statement.executeQuery();
			PrintWriter pw=response.getWriter();
			if (rs.next())
			{ 
			pw.println("Product Details");
			pw.print(
					"<style>"
					+ "td{text-align: center;}"
					+ "body {text-align:center;}"
					+"</Style>"
					+ "<table width=\"400\" border=\"2\" cellspacing=\"2\" cellpadding=\"2\" align=\"center\">"
					+ "<tr><th>pId</th>"
					+ "<th>Mobile Phone</th>"
					+ "<th>Cost</th></tr>");
				 do{				
				pw.print("<tr><td>"+rs.getString(1)
				+"</td><td>"+rs.getString(2)
				+"</td><td>"+rs.getString(3)
				+ "</td></tr>");
//				pw.print("<tr><td>"+rs.getString("pId")
//				+"</td><td>"+rs.getString("Name")
//				+"</td><td>"+rs.getString("Cost")
//				+ "</td></tr>");
				}while(rs.next());
				pw.print("</table>");
				pw.println("<p><a href=\"product_details.html\">Home</a></p>");
				
			}
			else {
				pw.println("<h2><b>Product Id not Exists</b><h2>");  
				pw.print("Try Again!!");
		        RequestDispatcher rd=request.getRequestDispatcher("product_details.html");  
		        rd.include(request,response); 

		        return;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
