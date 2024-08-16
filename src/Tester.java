import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import dao.ApplicationStatusDAOImpl;
import dao.LoanApplicationDAOImpl;
import dao.User;
import dao.UserDAOImpl;
public class Tester{
	//for register
	@Test
	public void reg()
	{
		User user=new User();
		user.setAdmin(1);
		user.setEmail("syedmehdi@gmail.com");
		user.setPassword("1234569");
		user.setPhoneNumber("961255636");
		user.setFname("Jack");
		user.setMname("and");
		user.setLname("Jill");
		UserDAOImpl useri=new UserDAOImpl();
		useri.createUser(user);
	}
	@Test
	public void getId()
	{
		UserDAOImpl user=new UserDAOImpl();
		Assertions.assertTrue(user.getId()==8);
	}
	
	//for login
	@Test
	public void noCustomerId()
	{
		UserDAOImpl user=new UserDAOImpl();
		Assertions.assertTrue(user.login(50,"123").equals("No user exists with the given customer Id"));
	}
	
	@Test
	public void wrongPassword()
	{
		UserDAOImpl user=new UserDAOImpl();
		Assertions.assertTrue(user.login(1,"1234").equals("Wrong password entered"));
	}
	
	@Test
	public void correctLogin()
	{
		UserDAOImpl user=new UserDAOImpl();
		Assertions.assertTrue(user.login(4,"123").substring(0,16).equals("Successful Login"));
	}
	//for getting loan amount
	@Test
	public void loanAmount()
	{
		ApplicationStatusDAOImpl a=new ApplicationStatusDAOImpl();
		System.out.println("Loan amount = "+a.getLoanAmount(1));
		Assertions.assertTrue(a.getLoanAmount(1)==50000);
	}
	// for status checking
	@Test
	public void approvalPendingTest() {
		ApplicationStatusDAOImpl a=new ApplicationStatusDAOImpl();
		String ans=a.getApplicationStatus(1,"2003-07-02");
		Assertions.assertTrue(ans.equals("The approval of loan is still pending"));
	}
	
	@Test
	public void dobTest() {
		ApplicationStatusDAOImpl a=new ApplicationStatusDAOImpl();
		String ans=a.getApplicationStatus(1,"2003-05-02");
		System.out.println(ans);
		Assertions.assertTrue(ans.equals("Your date of birth is incorrect"));
	}
	
	@Test
	public void applicationNumberTest()
	{
		ApplicationStatusDAOImpl a=new ApplicationStatusDAOImpl();
		String ans=a.getApplicationStatus(5,"2003-07-02");
		Assertions.assertTrue(ans.equals("there is no loan application with that number"));
	}
	
//	@Test
	public void applicationStatusAddingTest()
	{
		ApplicationStatusDAOImpl a=new ApplicationStatusDAOImpl();
		a.createApplicationStatus(1); 	
	}
	//for admin
	@Test
	public void allPending()
	{
		LoanApplicationDAOImpl a=new LoanApplicationDAOImpl();
		a.allPendingApplication();
	}
	
	@Test
	public void approveLoan()
	{
		LoanApplicationDAOImpl a= new LoanApplicationDAOImpl();
		a.approveApplication(24);
	}
}






