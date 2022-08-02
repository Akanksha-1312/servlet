import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
//		insertdb();
//		readdb();
//		updatedb();
//		deletedb();
		
		
	}

	private static void deletedb() {
		// TODO Auto-generated method stub
		//Connection connection = null;
		//Statement statement = null;
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
				Statement statement = connection.createStatement()){
			statement.execute("delete from account where idaccount=2");
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		
	}

	private static void insertdb() {
		// TODO Auto-generated method stub
		
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
				Statement statement = connection.createStatement()){
			statement.execute("insert into account values(2,'aki','cbt',5)");
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
		// TODO Auto-generated method stub

		
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