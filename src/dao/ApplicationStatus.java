package dao;
/*applicationId	customerId    loanAmount    	interestRate		startDate	endDate 	emi 	
	(int)pk		(int)fk		double		double			DateTime	DateTime	double  */
public class ApplicationStatus {
	int applicationId;
	int customerId;
	double loanAmount;
	double interestRate;
	String startDate;
	String endDate;
	double emi;
	public int getApplicationId() {
		return applicationId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public double getEmi() {
		return emi;
	}
}
