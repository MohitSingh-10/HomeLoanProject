package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoanApplicationDAOImpl implements LoanApplicationDAO{
	
	Connection conn = null;

    public LoanApplicationDAOImpl() {
        try {
            System.out.println("Registering driver...");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("Driver registered...");

            System.out.println("Trying to connect to the DB");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeloan", "root", "MySQL");
            System.out.println("Connected to the DB: " + conn);
        } catch (Exception e) {
            System.out.println("Problem: " + e);
        }
    }
    
    @Override
    public void createApplication(LoanApplication app) {
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO loanApplication VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, app.getApplicationId());
            pst.setInt(2, app.getCustomerId());
            pst.setString(3, app.getLocation());
            pst.setString(4, app.getName());
            pst.setDouble(5, app.getEstimatedCost());
            pst.setString(6, app.getEmploymentType());
            pst.setInt(7, app.getRetirementAge());
            pst.setString(8, app.getOrganization());
            pst.setString(9, app.getEmployerName());
            pst.setDouble(10, app.getMonthlyIncome());
            pst.setDouble(11, app.getLoanAmount());
            pst.setInt(12, app.getTenure());
            pst.setDouble(13, app.getRateOfInterest());
            pst.setString(14, app.getApplicationStatus());
            pst.setDate(15, app.getSubmissionDate());
            pst.setDouble(16, app.getMaxLoanAmount());
            int rows = pst.executeUpdate();
            System.out.println(rows + " Record(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public LoanApplication readApplication(int applicationId) {
        LoanApplication app = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM loanApplication WHERE applicationId=" + applicationId);
            if (result.next()) {
                app = new LoanApplication();
                app.setApplicationId(result.getInt(1));
                app.setCustomerId(result.getInt(2));
                app.setLocation(result.getString(3));
                app.setName(result.getString(4));
                app.setEstimatedCost(result.getDouble(5));
                app.setEmploymentType(result.getString(6));
                app.setRetirementAge(result.getInt(7));
                app.setOrganization(result.getString(8));
                app.setEmployerName(result.getString(9));
                app.setMonthlyIncome(result.getDouble(10));
                app.setLoanAmount(result.getDouble(11));
                app.setTenure(result.getInt(12));
                app.setRateOfInterest(result.getDouble(13));
                app.setApplicationStatus(result.getString(14));
                app.setSubmissionDate(result.getDate(15));
                app.setMaxLoanAmount(result.getDouble(16));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return app;
    }
    
    @Override
    public List<LoanApplication> readApplications(int userId) {
        List<LoanApplication> appList = new ArrayList<>();
        String query = "SELECT * FROM loanApplication WHERE customerId = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet result = pstmt.executeQuery();
            
            while (result.next()) {
                LoanApplication app = new LoanApplication();
                app.setApplicationId(result.getInt("applicationId"));
                app.setCustomerId(result.getInt("customerId"));
                app.setLocation(result.getString("location"));
                app.setName(result.getString("name"));
                app.setEstimatedCost(result.getDouble("estimatedCost"));
                app.setEmploymentType(result.getString("employmentType"));
                app.setRetirementAge(result.getInt("retirementAge"));
                app.setOrganization(result.getString("organization"));
                app.setEmployerName(result.getString("employerName"));
                app.setMonthlyIncome(result.getDouble("monthlyIncome"));
                app.setLoanAmount(result.getDouble("loanAmount"));
                app.setTenure(result.getInt("tenure"));
                app.setRateOfInterest(result.getDouble("rateOfInterest"));
                app.setApplicationStatus(result.getString("applicationStatus"));
                app.setSubmissionDate(result.getDate("submissionDate"));
                app.setMaxLoanAmount(result.getDouble("maxLoanAmount"));
                appList.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return appList;
    }
    
    @Override
    public void updateApplication(LoanApplication app) {
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE loanApplication SET customerId=?, location=?, name=?, estimatedCost=?, employmentType=?, retirementAge=?, organization=?, employerName=?, monthlyIncome=?, loanAmount=?, tenure=?, rateOfInterest=?, applicationStatus=?, submissionDate=?, maxLoanAmount=? WHERE applicationId=?");
            pst.setInt(1, app.getCustomerId());
            pst.setString(2, app.getLocation());
            pst.setString(3, app.getName());
            pst.setDouble(4, app.getEstimatedCost());
            pst.setString(5, app.getEmploymentType());
            pst.setInt(6, app.getRetirementAge());
            pst.setString(7, app.getOrganization());
            pst.setString(8, app.getEmployerName());
            pst.setDouble(9, app.getMonthlyIncome());
            pst.setDouble(10, app.getLoanAmount());
            pst.setInt(11, app.getTenure());
            pst.setDouble(12, app.getRateOfInterest());
            pst.setString(13, app.getApplicationStatus());
            pst.setDate(14, app.getSubmissionDate());
            pst.setDouble(15, app.getMaxLoanAmount());
            pst.setInt(16, app.getApplicationId());
            int rows = pst.executeUpdate();
            System.out.println(rows + " Record(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deleteApplication(int applicationId) {
        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM loanApplication WHERE applicationId=?");
            pst.setInt(1, applicationId);
            int rows = pst.executeUpdate();
            System.out.println(rows + " Record(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String [][] allPendingApplication() {
		ArrayList<ArrayList<String>> arr=new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select * from loanapplication where applicationstatus = 'pending'");
			ResultSetMetaData rsmd = result.getMetaData();
			while(result.next())
			{
				ArrayList<String> temp=new ArrayList<>();
				temp.add(result.getString(1));
				temp.add(result.getString(2));
				temp.add(result.getString(9));
				temp.add(result.getString(10));
				temp.add(result.getString(11));
				temp.add(result.getString(12));
				arr.add(temp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		String ans[][]=new String[arr.size()][7];
		for(int i=0;i<arr.size();i++)
		{
			for(int j=0;j<6;j++)
				ans[i][j]=arr.get(i).get(j);
		}
		return ans;
	}
    
    @Override
    public String [][] allRejectedApplication() {
		ArrayList<ArrayList<String>> arr=new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select * from loanapplication where applicationstatus = 'rejected'");
			ResultSetMetaData rsmd = result.getMetaData();
			while(result.next())
			{
				ArrayList<String> temp=new ArrayList<>();
				temp.add(result.getString(1));
				temp.add(result.getString(2));
				temp.add(result.getString(9));
				temp.add(result.getString(10));
				temp.add(result.getString(11));
				temp.add(result.getString(12));
				arr.add(temp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		String ans[][]=new String[arr.size()][7];
		for(int i=0;i<arr.size();i++)
		{
			for(int j=0;j<6;j++)
				ans[i][j]=arr.get(i).get(j);
		}
		return ans;
	}
    
    @Override
    public String [][] allApprovedApplication() {
		ArrayList<ArrayList<String>> arr=new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select * from applicationstatus");
			ResultSetMetaData rsmd = result.getMetaData();
			while(result.next())
			{
				ArrayList<String> temp=new ArrayList<>();
				temp.add(result.getString(1));
				temp.add(result.getString(2));
				temp.add(result.getString(3));
				temp.add(result.getString(4));
				temp.add(result.getString(5));
				temp.add(result.getString(6));
				temp.add(result.getString(7));//1-2-9-10-11-12
				arr.add(temp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		String ans[][]=new String[arr.size()][7];
		for(int i=0;i<arr.size();i++)
		{
			for(int j=0;j<7;j++)
				ans[i][j]=arr.get(i).get(j);
		}
		return ans;
	}
    
    public int getId() {
		try {
			Statement statement = conn.createStatement();
			ResultSet idResult=statement.executeQuery("select max(applicationId) from loanApplication");
			if(idResult.next())
				return idResult.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

    public String approveApplication(int id)
	{
		String s = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet r=statement.executeQuery("select applicationstatus from loanapplication where applicationId="+id);
			if(r.next())
			{
				String status=r.getString(1);
				if(status.equals("approved"))
					return "The loan is already approved";
				else if(status.equals("rejected"))
					return "Cannot Approve a rejected loan";
			}
			else
			{
				return "No loan application exists with the given id";
			}
			int result=statement.executeUpdate("update loanapplication set applicationstatus = 'approved' where applicationId="+id);
			ApplicationStatusDAOImpl a= new ApplicationStatusDAOImpl();
			a.createApplicationStatus(id);
			return "Your loan has been approved";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return s;
	}
    
    public String rejectApplication(int id) {
    	String s = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet r=statement.executeQuery("select applicationstatus from loanapplication where applicationId="+id);
			if(r.next())
			{
				String status=r.getString(1);
				if(status.equals("approved"))
					return "Cannot reject an approved loan";
				else if(status.equals("rejected"))
					return "The application is already rejected";
			}
			else
			{
				return "No loan application exists with the given id";
			}
			int result=statement.executeUpdate("update loanapplication set applicationstatus = 'rejected' where applicationId="+id);

			return "Loan application has been rejected";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return s;
    }
    
    public String[][] allLoanUid(int id) {
		ArrayList<ArrayList<String>> arr=new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select * from loanapplication where customerId="+id);
			ResultSetMetaData rsmd = result.getMetaData();
			while(result.next())
			{
				ArrayList<String> temp=new ArrayList<>();
				temp.add(result.getString(1)); 
				temp.add(result.getString(10));
				temp.add(result.getString(11));
				temp.add(result.getString(12));
				temp.add(result.getString(14));
				arr.add(temp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		String ans[][]=new String[arr.size()][7];
		for(int i=0;i<arr.size();i++)
		{
			for(int j=0;j<5;j++)
				ans[i][j]=arr.get(i).get(j);
		}
		return ans;
	}
    
    

}