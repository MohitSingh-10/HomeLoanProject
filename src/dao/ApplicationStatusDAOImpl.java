package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

	
	public void createApplicationStatus(int appId) {
		try {
			Statement statement = conn.createStatement();
			ResultSet cidResult=statement.executeQuery("select * from loanapplication where applicationId="+appId);
			PreparedStatement pst = conn.prepareStatement("insert into applicationstatus values (?,?,?,?,?,?,?)");
			if(cidResult.next())
			{
				double principal= cidResult.getDouble(11);
				int tenure=cidResult.getInt(12);
				pst.setInt(1,cidResult.getInt(1));
				pst.setInt(2, cidResult.getInt(2));
				pst.setDouble(3,cidResult.getDouble(11));
				pst.setDouble(4,8.5);
				Calendar cal = Calendar.getInstance();
			    cal.add(Calendar.MONTH, cidResult.getInt(12));  
			    Date updatedDate = cal.getTime();  
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			    String formattedDate = sdf.format(updatedDate);
			    String endDate=java.time.LocalDate.now().toString();
			    pst.setString(5,endDate);
				pst.setString(6,formattedDate);
				double emi = (principal * (8.5/1200) * Math.pow(1 + (8.5/1200), tenure)) /
		                (Math.pow(1 + (8.5/1200), tenure) - 1);
				pst.setDouble(7,emi);

				System.out.println(principal + " " + tenure);
				int rows = pst.executeUpdate();
			}
		}
		catch (SQLException e) {
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
		
			if(status.equals("Pending")) {
				
				return ("The approval of loan is still pending");
			}
			if(status.equals("rejected"))
				return "Your loan request of rejected";
			ResultSet result = statement.executeQuery("select * from applicationstatus where applicationId="+id);
			if(result.next()) {
				ans="Your loan has been approved";
				ans+="\nApplication Id = "+result.getInt(1)+
					  "\nCustomer Id = "+result.getInt(2)+
					  "\nLoan amount = "+result.getDouble(3)+
					  "\nInterest Rate = "+result.getDouble(4)+
					  "\nStart Date = "+result.getDate(5)+
					  "\nEnd Eate = "+result.getDate(6)+
					  "\nEMI amount = "+result.getDouble(7);
				return ans;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

	public double getLoanAmount(int cid) {
		try {
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select loanamount from applicationstatus where applicationId="+cid);
			result.next();
			double amt=result.getDouble(1);
			return amt;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getCustomerId(int id) {
		try {
			Statement statement = conn.createStatement();
			ResultSet idResult=statement.executeQuery("SELECT customerId FROM loanapplication where applicationId="+id);
			if(idResult.next())
				return idResult.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

}

