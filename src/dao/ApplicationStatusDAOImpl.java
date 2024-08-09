package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*applicationId	customerId    loanAmount    	interestRate		startDate	endDate 	emi 	
(int)pk		(int)fk		double		double			DateTime	DateTime	double  */
public class ApplicationStatusDAOImpl implements ApplicationStatusDAO{

	Connection conn=null;
	
	public ApplicationStatusDAOImpl() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeloan", "root", "MySQL");
		}
		catch(Exception e) {
			System.out.println("Problem : "+e);
		}
			
	}
	@Override
	public void createApplicationStatus(ApplicationStatus applicationStatus) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into applicationstatus values (?,?,?,?,?,?,?)");
			pst.setInt(1,applicationStatus.getApplicationId());
			pst.setInt(2, applicationStatus.getCustomerId());
			pst.setDouble(3,applicationStatus.getLoanAmount());
			pst.setDouble(4,applicationStatus.getInterestRate());
			pst.setString(5,applicationStatus.getStartDate());
			pst.setString(6,applicationStatus.getEndDate());
			pst.setDouble(7,applicationStatus.getEmi());
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) inserted : ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String getApplicationStatus(int id, String date) {
		String ans="";
		try {
			Statement statement = conn.createStatement();
			ResultSet cidResult=statement.executeQuery("select customerId from loanapplication where applicationId="+id);
			if (!cidResult.isBeforeFirst() ) {    
			    return "there is no loan application with that number";
			}
			int cid=0;
			
			while (cidResult.next())
				cid = cidResult.getInt(1);
			
			ResultSet dateResult=statement.executeQuery("select dob from personaldetails where customerId="+cid);
			String actualDate="";
			
			while (dateResult.next())
			   actualDate=dateResult.getDate(1).toString();
			
			if(!actualDate.equals(date))
				return ("Your date of birth is incorrect");
			
			ResultSet statusResult = statement.executeQuery("select applicationStatus from loanapplication where applicationId="+id);
			statusResult.next();
			String status= statusResult.getString(1);
			if(status.equals("pending"))
				return ("The approval of loan is still pending");
			
			if(status.equals("rejected"))
				return "Your loan request of rejected";
			ResultSet result = statement.executeQuery("select * from ApplicationStatus where applicationId="+id);
			if(result.next()) {
				ans="Your loan has been approved";
				ans+="\nApplication Id = "+result.getInt(1)+
					  "\nCustomer Id = "+result.getInt(2)+
					  "\nLoan amount = "+result.getDouble(3)+
					  "\nInterest Rate = "+result.getDouble(4)+
					  "\nStart Date = "+result.getDate(5)+
					  "\nEnd Eate = "+result.getDate(6)+
					  "\nEMI amount = "+result.getDouble(7);
				System.out.println(ans);
				return ans;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

}

