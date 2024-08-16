package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 customerID 	name  		emailId  	age	  dob  		panNumber  	aadharNo 	phoneNumber 	gender	 	nationality
  pk	  (first middle* last)	  varchar 	int	dateTime	varchar		longint		varchar		char		varchar
 */
public class PersonalDetailsDAOImpl implements PersonalDetailsDAO
{
Connection conn=null;
	
	public PersonalDetailsDAOImpl() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeLoan", "root", "MySQL");
		}
		catch(Exception e) {
			System.out.println("Problem : "+e);
		}
			
	}
	
	@Override
	public void createPersonalDetails(PersonalDetails personalDetails) {
		try {
			Statement statement = conn.createStatement();
			ResultSet stmt = statement.executeQuery("select * from personaldetails where customerId="+personalDetails.getCustomerId());
			if (stmt.isBeforeFirst() ) {
			    return ;
			}
			PreparedStatement pst = conn.prepareStatement("insert into personalDetails values (?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1,personalDetails.getCustomerId());
			pst.setString(2, personalDetails.getName());
			pst.setString(3,personalDetails.getEmail());
			pst.setInt(4,personalDetails.getAge());
			pst.setString(5,personalDetails.getDob());
			pst.setString(6,personalDetails.getPanNumber());
			pst.setLong(7,personalDetails.getAadharNo());
			pst.setString(8, personalDetails.getPhoneNumber());
			String gender="";
			gender+=personalDetails.getGender();
			pst.setString(9,gender);
			pst.setString(10, personalDetails.getNationality());
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) inserted : ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public boolean alreadyExisting(int cid)
	{
		try {
			Statement statement = conn.createStatement();
			ResultSet stmt = statement.executeQuery("select * from personalDetails where customerId="+cid);
			if (stmt.next() ) {    
			    return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}














