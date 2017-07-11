package login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class NguoiDung {
	private String username;
	private String password;
	private String hoTen;
	
	/**
	 * 
	 */
	public NguoiDung() {
		
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @param hoTen
	 */

	public NguoiDung(String username, String password, String hoTen) {
		super();
		this.username = username;
		this.password = password;
		this.hoTen = hoTen;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public boolean checkLogin(String username, String password){
		DataAccess da = new DataAccess();
		Connection con =da.getConnect();
		ResultSet rs;
		Statement stmt;
		String sql = "SELECT username FROM TAIKHOAN WHERE username = '" + username + "' AND password = '" + password + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;		
	}
	public boolean duplicate(String username){
		DataAccess da = new DataAccess();
		Connection con =da.getConnect();
		ResultSet rs;
		Statement stmt;
		String sql = "SELECT username FROM TAIKHOAN WHERE username = '" + username + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;		
	}
	
	public ArrayList<NguoiDung> getListUser() {
		ArrayList<NguoiDung> arr = new ArrayList<>();
		DataAccess da = new DataAccess();
		Connection con =da.getConnect();
		ResultSet rs = null;
		Statement stmt = null;

		String sql = "SELECT * FROM TAIKHOAN ";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				NguoiDung nd = new NguoiDung();
				nd.setUsername(rs.getString("username"));
				nd.setPassword(rs.getString("password"));
				nd.setHoTen(rs.getString("hoten"));
				arr.add(nd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return arr;
	}
	public void addUser(String username, String password, String hoTen){
		PreparedStatement pstm;
		DataAccess da = new DataAccess();
		Connection con =da.getConnect();
		String sql = "INSERT INTO TAIKHOAN VALUES(?,?,?)";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.setString(3, hoTen);

			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public NguoiDung getInforUser(String username) {
		DataAccess da = new DataAccess();
		Connection con =da.getConnect();
		String sql=	"SELECT * FROM TAIKHOAN " +"WHERE username = '"+username+"'";
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		NguoiDung nd = new NguoiDung();
		try {
			while(rs.next()){
				nd.setUsername(username);
				nd.setPassword(rs.getString("password"));
				nd.setHoTen(rs.getString("hoten"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nd;
	}
	public void updateUser(String username, String password, String hoTen){
		DataAccess da = new DataAccess();
		Connection con =da.getConnect();
		String sql=	"UPDATE TAIKHOAN SET password ='"+password+"' ,hoten ='"+hoTen+"' WHERE username = '"+username+"'";
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void deleteUser(String username) {
		DataAccess da = new DataAccess();
		Connection con =da.getConnect();
		String sql=	"DELETE FROM TAIKHOAN WHERE username = '"+username+"'"; 
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		NguoiDung user = new NguoiDung();
		ArrayList<NguoiDung> arr = user.getListUser();
		for (NguoiDung nguoiDung : arr) {
			System.out.println("" + nguoiDung.getHoTen());
			
		}
	}
}