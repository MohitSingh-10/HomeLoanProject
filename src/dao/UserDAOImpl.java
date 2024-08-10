package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*customerId       password       admin 		email	   phoneNumber	fname       mname       lname
(primary key)(int)	(varchar)		Boolean		varchar		varchar		varchar     varchar     varchar*/
public class UserDAOImpl implements UserDAO
{
	Connection conn=null;
	
	public UserDAOImpl() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeloan", "root", "MySQL");
		}
		catch(Exception e) {
			System.out.println("Problem : "+e);
		}
			
	}
	
	@Override
	public void createUser(User user) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into user (password,admin,email,phoneNumber,fname,mname,lname) values(?,?,?,?,?,?,?)");
			pst.setString(1, user.getPassword());
			pst.setInt(2,0);
			pst.setString(3,user.getEmail());
			pst.setString(4,user.getPhoneNumber());
			pst.setString(5,user.getFname());
			pst.setString(6,user.getMname());
			pst.setString(7,user.getLname());
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) inserted : ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String login(int customerId, String password) {
		boolean admin=false;
		try {
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("select password from user where customerId="+customerId);
		if(result.next())
		{
			if(password.equals(result.getString(1)))
			{
				System.out.println("Successful Login");
				ResultSet isAdmin=statement.executeQuery("select admin from user where customerId="+customerId);
				isAdmin.next();
				admin = isAdmin.getInt(1)==1?true:false;
				System.out.println(admin);
				return "Successful Login "+admin;
			}
			else
			{
				System.out.println("Wrong password entered");
				return "Wrong password entered";
			}
		}
		else
			System.out.println("No user exists with the given customer Id");
		return "No user exists with the given customer Id";
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "";
	}
	
}