
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userServlet")
public class User extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		insertdb(firstname,lastname,email,password);
	
	

}
	
	private static void insertdb(String firstname, String lastname, String email, String password) {
				
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
				Statement statement = connection.createStatement();) {

			String query = "insert into user values('" + firstname + "', '" + lastname + "', '" + email + "', '" + password  + "')";
			System.out.println("Query being executed: " + query);
			int rowsInserted = statement.executeUpdate(query);
			System.out.println("Number of rows inserted: " + rowsInserted);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void deletedb() {
			
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
				Statement statement = connection.createStatement()){
			statement.execute("delete from account where idaccount=2");
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		
	}
	
	private static void updatedb() {

		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
				Statement statement = connection.createStatement()){
			statement.execute("update account set amount=200 where idaccount=1 ");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	private static void readdb() {
	
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
				Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery("select * from account");
			while (resultSet.next()) {				
				System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3) + ", " + resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	}
