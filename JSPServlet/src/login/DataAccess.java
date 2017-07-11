package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=USER";
	String userName = "sa";
	String password = "Abcde12345";
	Connection con;
	
	public Connection getConnect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, userName, password);
			//System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
		return con;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DataAccess da = new DataAccess();
		System.out.print(da.getConnect());
	}
}