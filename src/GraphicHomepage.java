import javax.swing.*;
import java.awt.*;

public class GraphicHomepage {

    private static JPanel mainPanel; 
    private static JFrame frame; 
    private static JButton loginButton; 
    private static JLabel customerIdLabel; 
    private static JButton logoutButton; 
    private static JLabel copyright; 

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(GraphicHomepage::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Home Loan Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); 

       
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8, 1, 10, 10));

        loginButton = new JButton("Log in / Register");
        JButton applyLoanButton = new JButton("Apply for a New Loan");
        JButton checkStatusButton = new JButton("Check Loan Status");
        JButton loanCalculatorButton = new JButton("Loan Calculator");
        JButton aboutUsButton = new JButton("About Us");
        JButton faqsButton = new JButton("FAQs");
        JButton exitButton = new JButton("Exit");
        JLabel copyright = new JLabel("Copyright 2024-25 LOAN / HOME", JLabel.CENTER);

       
        
        mainPanel.add(loginButton);
        mainPanel.add(applyLoanButton);
        mainPanel.add(checkStatusButton);
        mainPanel.add(loanCalculatorButton);
        mainPanel.add(aboutUsButton);
        mainPanel.add(faqsButton);
        mainPanel.add(exitButton);
        mainPanel.add(copyright);

        
        frame.add(mainPanel);

        
        loginButton.addActionListener(e -> LoginRegister.showLoginRegisterOptions());
        applyLoanButton.addActionListener(e -> {
        	if(Globals.custId==0) {
        		LoginRegister.showLoginRegisterOptions();
        	}
        	else {
        		ApplyLoan.showLoanApplicationPage();
        	}
         });
        checkStatusButton.addActionListener(e -> LoanStatus.showCheckLoanStatusDialog());
        loanCalculatorButton.addActionListener(e -> LoanCalculator.showLoanCalculatorOptions());
        aboutUsButton.addActionListener(e -> AboutUs.showAboutUs());
        faqsButton.addActionListener(e -> FAQs.showFAQs());
        exitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    public static void login(String customerId) {
        mainPanel.removeAll();

        customerIdLabel = new JLabel("Customer ID: " + customerId, JLabel.CENTER);
        

        logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(e -> logout());
        

        JButton applyLoanButton = new JButton("Apply for a New Loan");
        JButton checkStatusButton = new JButton("Check Loan Status");
        JButton loanCalculatorButton = new JButton("Loan Calculator");
        JButton accountDetailsButton = new JButton("Check Account Details");
        JButton faqsButton = new JButton("FAQs");
        JButton exitButton = new JButton("Exit");

        mainPanel.add(customerIdLabel);
        mainPanel.add(applyLoanButton);
        mainPanel.add(checkStatusButton);
        mainPanel.add(loanCalculatorButton);
        mainPanel.add(accountDetailsButton);
        mainPanel.add(faqsButton);
        mainPanel.add(exitButton);
        mainPanel.add(logoutButton);
        
        applyLoanButton.addActionListener(e -> {
        	if(Globals.custId==0) {
        		LoginRegister.showLoginRegisterOptions();
        	}
        	else {
        		ApplyLoan.showLoanApplicationPage();
        	}
         });
        checkStatusButton.addActionListener(e -> LoanStatus.showCheckLoanStatusDialog());
        loanCalculatorButton.addActionListener(e -> LoanCalculator.showLoanCalculatorOptions());
        accountDetailsButton.addActionListener(e -> BankBalance.displayAccountDetails());
        faqsButton.addActionListener(e -> FAQs.showFAQs());
        exitButton.addActionListener(e -> System.exit(0));
        logoutButton.addActionListener(e -> logout());

        frame.revalidate();
        frame.repaint();
    }
    
    public static void adminLogin(String customerId) {
        mainPanel.removeAll();

        customerIdLabel = new JLabel("Customer ID(Admin): " + customerId, JLabel.CENTER);
        

        logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(e -> logout());
        

        JButton approveLoans = new JButton("Approve/Reject Loans");
        JButton approvedLoans = new JButton("See Approved Loans");
        JButton pendingLoans = new JButton("See Pending Loans");
        JButton rejectedLoans = new JButton("See Rejected Loans");
        JButton faqsButton = new JButton("Show all loans of a user");
        JButton exitButton = new JButton("Exit");

        mainPanel.add(customerIdLabel);
        mainPanel.add(approveLoans);
        mainPanel.add(approvedLoans);
        mainPanel.add(pendingLoans);
        mainPanel.add(rejectedLoans);
        mainPanel.add(faqsButton);
        mainPanel.add(exitButton);
        mainPanel.add(logoutButton);
        
        approveLoans.addActionListener(e -> AdminFunctionality.showAdminApprove());
        approvedLoans.addActionListener(e -> AdminFunctionality.showApproved());
        pendingLoans.addActionListener(e -> AdminFunctionality.showPending());
        rejectedLoans.addActionListener(e -> AdminFunctionality.showRejected());
        faqsButton.addActionListener(e -> AdminFunctionality.showApplication());
        exitButton.addActionListener(e -> System.exit(0));
        logoutButton.addActionListener(e -> logout());

        frame.revalidate();
        frame.repaint();
    }
    


    private static void logout() {
    	 mainPanel.removeAll();

         copyright = new JLabel("Copyright 2024-25 LOAN / HOME", JLabel.CENTER);
         

         loginButton = new JButton("Log in / Register");
         

         JButton applyLoanButton = new JButton("Apply for a New Loan");
         JButton checkStatusButton = new JButton("Check Loan Status");
         JButton loanCalculatorButton = new JButton("Loan Calculator");
         JButton aboutUsButton = new JButton("About Us");
         JButton faqsButton = new JButton("FAQs");
         JButton exitButton = new JButton("Exit");

         mainPanel.add(loginButton);
         mainPanel.add(applyLoanButton);
         mainPanel.add(checkStatusButton);
         mainPanel.add(loanCalculatorButton);
         mainPanel.add(aboutUsButton);
         mainPanel.add(faqsButton);
         mainPanel.add(exitButton);
         mainPanel.add(copyright);
         
         loginButton.addActionListener(e -> LoginRegister.showLoginRegisterOptions());
         applyLoanButton.addActionListener(e -> {
        	if(Globals.custId==0) {
        		LoginRegister.showLoginRegisterOptions();
        	}
        	else {
        		ApplyLoan.showLoanApplicationPage();
        	}
         });
         checkStatusButton.addActionListener(e -> LoanStatus.showCheckLoanStatusDialog());
         loanCalculatorButton.addActionListener(e -> LoanCalculator.showLoanCalculatorOptions());
         aboutUsButton.addActionListener(e -> AboutUs.showAboutUs());
         faqsButton.addActionListener(e -> FAQs.showFAQs());
         exitButton.addActionListener(e -> System.exit(0)); 


         frame.revalidate();
         frame.repaint();
         Globals.custId=0;
    }

}
