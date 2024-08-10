import javax.swing.*;
import java.awt.*;

public class GraphicHomepage {

    private static JPanel mainPanel; // Reference to the main panel
    private static JFrame frame; // Reference to the main frame
    private static JButton loginButton; // Reference to the login/register button
    private static JLabel customerIdLabel; // Reference to the customer ID label
    private static JButton logoutButton; // Reference to the logout button
    private static JLabel copyright; //Reference to the copyright label

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(GraphicHomepage::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create the main frame
        frame = new JFrame("Home Loan Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center the window

        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8, 1, 10, 10)); // 8 rows, 1 column with gaps

        // Create buttons for each option
        loginButton = new JButton("Log in / Register");
        JButton applyLoanButton = new JButton("Apply for a New Loan");
        JButton checkStatusButton = new JButton("Check Loan Status");
        JButton loanCalculatorButton = new JButton("Loan Calculator");
        JButton aboutUsButton = new JButton("About Us");
        JButton faqsButton = new JButton("FAQs");
        JButton exitButton = new JButton("Exit");
        JLabel copyright = new JLabel("Copyright 2024-25 LOAN / HOME", JLabel.CENTER);

        // Add buttons to the panel
        
        mainPanel.add(loginButton);
        mainPanel.add(applyLoanButton);
        mainPanel.add(checkStatusButton);
        mainPanel.add(loanCalculatorButton);
        mainPanel.add(aboutUsButton);
        mainPanel.add(faqsButton);
        mainPanel.add(exitButton);
        mainPanel.add(copyright);

        // Add panel to frame
        frame.add(mainPanel);

        // Button action listeners
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
        exitButton.addActionListener(e -> System.exit(0)); // Exit the application

        // Set the frame to be visible
        frame.setVisible(true);
    }

    public static void login(String customerId) {
        // Remove all components from the panel
        mainPanel.removeAll();

        // Create and add customer ID label
        customerIdLabel = new JLabel("Customer ID: " + customerId, JLabel.CENTER);
        

        // Create and add log out button
        logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(e -> logout());
        

        // Re-add other buttons
        JButton applyLoanButton = new JButton("Apply for a New Loan");
        JButton checkStatusButton = new JButton("Check Loan Status");
        JButton loanCalculatorButton = new JButton("Loan Calculator");
        JButton aboutUsButton = new JButton("About Us");
        JButton faqsButton = new JButton("FAQs");
        JButton exitButton = new JButton("Exit");

        mainPanel.add(customerIdLabel);
        mainPanel.add(applyLoanButton);
        mainPanel.add(checkStatusButton);
        mainPanel.add(loanCalculatorButton);
        mainPanel.add(aboutUsButton);
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
        aboutUsButton.addActionListener(e -> AboutUs.showAboutUs());
        faqsButton.addActionListener(e -> FAQs.showFAQs());
        exitButton.addActionListener(e -> System.exit(0)); // Exit the application
        logoutButton.addActionListener(e -> logout());

        // Update the frame
        frame.revalidate();
        frame.repaint();
    }
    
    public static void adminLogin(String customerId) {
        // Remove all components from the panel
        mainPanel.removeAll();

        // Create and add customer ID label
        customerIdLabel = new JLabel("Customer ID(Admin): " + customerId, JLabel.CENTER);
        

        // Create and add log out button
        logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(e -> logout());
        

        // Re-add other buttons
        JButton approveLoans = new JButton("Approve Loans");
        JButton approvedLoans = new JButton("See Approved Loans");
        JButton pendingLoans = new JButton("See Pending Loans");
        JButton rejectedLoans = new JButton("See Rejected Loans");
        JButton faqsButton = new JButton("FAQs");
        JButton exitButton = new JButton("Exit");

        mainPanel.add(customerIdLabel);
        mainPanel.add(approveLoans);
        mainPanel.add(approvedLoans);
        mainPanel.add(pendingLoans);
        mainPanel.add(rejectedLoans);
        mainPanel.add(faqsButton);
        mainPanel.add(exitButton);
        mainPanel.add(logoutButton);
        
        approveLoans.addActionListener(e -> JOptionPane.showMessageDialog(frame, "You chose to approve loans"));
        approvedLoans.addActionListener(e -> JOptionPane.showMessageDialog(frame, "You chose to see approved loans"));
        pendingLoans.addActionListener(e -> JOptionPane.showMessageDialog(frame, "You chose to see pending loans"));
        rejectedLoans.addActionListener(e -> JOptionPane.showMessageDialog(frame, "You chose to see rejected loans"));
        faqsButton.addActionListener(e -> FAQs.showFAQs());
        exitButton.addActionListener(e -> System.exit(0)); // Exit the application
        logoutButton.addActionListener(e -> logout());

        // Update the frame
        frame.revalidate();
        frame.repaint();
    }
    
//    private static void showLoginRegisterOptions() {
//        String[] options = {"Log In", "Register"};
//        int choice = JOptionPane.showOptionDialog(null, "Please select an option:", "Log in / Register",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//
//        if (choice == 0) {
//            showLoginDialog();
//        } else if (choice == 1) {
//            JOptionPane.showMessageDialog(null, "You chose Register.");
//            // Add functionality for registering
//        }
//    }

//    private static void showLoginDialog() {
//        JPanel panel = new JPanel(new GridLayout(2, 2));
//
//        JTextField customerIdField = new JTextField();
//        JPasswordField passwordField = new JPasswordField();
//
//        panel.add(new JLabel("Customer ID:"));
//        panel.add(customerIdField);
//        panel.add(new JLabel("Password:"));
//        panel.add(passwordField);
//
//        int result = JOptionPane.showConfirmDialog(null, panel, "Log In", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//
//        if (result == JOptionPane.OK_OPTION) {
//            String customerId = customerIdField.getText();
//            String password = new String(passwordField.getPassword());
//            login(customerId, password);
//        }
//    }

//    private static void login(String customerId, String password) {
//        // Placeholder for login validation
//        JOptionPane.showMessageDialog(null, "Logged in successfully with Customer ID: " + customerId, "Login", JOptionPane.INFORMATION_MESSAGE);
//        
//        // Update the main panel to reflect the login
//        updateMainPanelAfterLogin(customerId);
//    }

//    private static void updateMainPanelAfterLogin(String customerId) {
//        // Remove all components from the panel
//        mainPanel.removeAll();
//
//        // Create and add customer ID label
//        customerIdLabel = new JLabel("Customer ID: " + customerId, JLabel.CENTER);
//        mainPanel.add(customerIdLabel);
//
//        // Create and add log out button
//        logoutButton = new JButton("Log Out");
//        logoutButton.addActionListener(e -> logout());
//        mainPanel.add(logoutButton);
//
//        // Re-add other buttons
//        JButton applyLoanButton = new JButton("Apply for a New Loan");
//        JButton checkStatusButton = new JButton("Check Loan Status");
//        JButton loanCalculatorButton = new JButton("Loan Calculator");
//        JButton aboutUsButton = new JButton("About Us");
//        JButton faqsButton = new JButton("FAQs");
//        JButton exitButton = new JButton("Exit");
//
//        mainPanel.add(applyLoanButton);
//        mainPanel.add(checkStatusButton);
//        mainPanel.add(loanCalculatorButton);
//        mainPanel.add(aboutUsButton);
//        mainPanel.add(faqsButton);
//        mainPanel.add(exitButton);
//
//        // Update the frame
//        frame.revalidate();
//        frame.repaint();
//    }

    private static void logout() {
        // Remove customer ID label and logout button
    	 mainPanel.removeAll();

         // Create and add customer ID label
         copyright = new JLabel("Copyright 2024-25 LOAN / HOME", JLabel.CENTER);
         

         // Create and add log out button
         loginButton = new JButton("Log in / Register");
        // loginButton.addActionListener(e -> LoginRegister.showLoginRegisterOptions());
         

         // Re-add other buttons
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
         exitButton.addActionListener(e -> System.exit(0)); // Exit the application


         // Update the frame
         frame.revalidate();
         frame.repaint();
         Globals.custId=0;
    }

//    private static void showCheckLoanStatusDialog() {
//        JPanel panel = new JPanel(new GridLayout(2, 2));
//
//        JTextField applicationIdField = new JTextField();
//        JTextField dobField = new JTextField();
//
//        panel.add(new JLabel("Application ID:"));
//        panel.add(applicationIdField);
//        panel.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
//        panel.add(dobField);
//
//        int result = JOptionPane.showConfirmDialog(null, panel, "Check Loan Status", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//
//        if (result == JOptionPane.OK_OPTION) {
//            String applicationId = applicationIdField.getText();
//            String dob = dobField.getText();
//            checkLoanStatus(applicationId, dob);
//        }
//    }
//
//    private static void checkLoanStatus(String applicationId, String dob) {
//        JOptionPane.showMessageDialog(null, "Checking status for Application ID: " + applicationId + " and Date of Birth: " + dob, "Loan Status", JOptionPane.INFORMATION_MESSAGE);
//    }

//    private static void showLoanCalculatorOptions() {
//        String[] options = {"Eligibility Calculator", "EMI Calculator"};
//        int choice = JOptionPane.showOptionDialog(null, "Which type of calculator would you like to use?", "Loan Calculator",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//
//        if (choice == 0) {
//            showEligibilityCalculator();
//        } else if (choice == 1) {
//            showEMICalculator();
//        }
//    }
//
//    private static void showEligibilityCalculator() {
//        try {
//            String input = JOptionPane.showInputDialog(null, "Enter your net monthly salary:", "Eligibility Calculator", JOptionPane.QUESTION_MESSAGE);
//            if (input != null) {
//                double netMonthlySalary = Double.parseDouble(input);
//                double eligibility = calculateEligibility(netMonthlySalary);
//                JOptionPane.showMessageDialog(null, "Based on your net monthly salary, your maximum eligible loan amount is: Rs." + String.format("%.2f", eligibility), "Eligibility Result", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private static void showEMICalculator() {
//        try {
//            String principalInput = JOptionPane.showInputDialog(null, "Enter the loan principal amount:", "EMI Calculator", JOptionPane.QUESTION_MESSAGE);
//            String annualInterestRateInput = JOptionPane.showInputDialog(null, "Enter the annual interest rate (in %):", "EMI Calculator", JOptionPane.QUESTION_MESSAGE);
//            String tenureInput = JOptionPane.showInputDialog(null, "Enter the loan tenure (in years):", "EMI Calculator", JOptionPane.QUESTION_MESSAGE);
//
//            if (principalInput != null && annualInterestRateInput != null && tenureInput != null) {
//                double principal = Double.parseDouble(principalInput);
//                double annualInterestRate = Double.parseDouble(annualInterestRateInput);
//                int tenureInYears = Integer.parseInt(tenureInput);
//                double emi = calculateEMI(principal, annualInterestRate, tenureInYears);
//                JOptionPane.showMessageDialog(null, "The EMI for your loan is: Rs." + String.format("%.2f", emi), "EMI Result", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    // Methods for calculations
//    public static double calculateEligibility(double netMonthlySalary) {
//        return 60 * (0.6 * netMonthlySalary);
//    }
//
//    public static double calculateEMI(double principal, double annualInterestRate, int tenureInYears) {
//        double monthlyInterestRate = annualInterestRate / 12 / 100;
//        int tenureInMonths = tenureInYears * 12;
//        return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureInMonths)) /
//                (Math.pow(1 + monthlyInterestRate, tenureInMonths) - 1);
//    }

//    private static void showAboutUs() {
//        // Create the content for the About Us page
//        String aboutUs = "About Us\n\n" +
//                         "Welcome to Home Loan Solutions!\n\n" +
//                         "At Home Loan Solutions, our mission is to help you achieve your dream of owning a home with ease and confidence. We understand that securing a home loan can be a complex and daunting process, which is why we are dedicated to providing you with clear, straightforward, and personalized financial solutions.\n\n" +
//                         "Who We Are\n\n" +
//                         "Founded in [Year], Home Loan Solutions is a leading provider of home loan services committed to making home ownership accessible to everyone. Our team of experienced financial advisors and mortgage experts is here to guide you through every step of the loan application process, from pre-approval to closing.\n\n" +
//                         "Our Services\n\n" +
//                         "- Home Purchase Loans: We offer competitive rates and flexible terms for purchasing your new home.\n" +
//                         "- Refinancing: Lower your monthly payments or access your home's equity with our refinancing options.\n" +
//                         "- Home Equity Loans: Tap into the equity of your current home for renovations, debt consolidation, or other needs.\n" +
//                         "- Pre-Approval: Get a head start on your home buying journey with our quick and easy pre-approval process.\n\n" +
//                         "Why Choose Us?\n\n" +
//                         "- Expert Advice: Our knowledgeable team is dedicated to providing you with expert advice tailored to your financial situation.\n" +
//                         "- Personalized Solutions: We offer a range of loan products designed to meet your unique needs and goals.\n" +
//                         "- Transparency: We believe in clear and honest communication, ensuring you understand every aspect of your loan.\n" +
//                         "- Customer-Centric Approach: Your satisfaction is our priority. We are here to support you throughout the entire loan process and beyond.\n\n" +
//                         "Our Commitment\n\n" +
//                         "At Home Loan Solutions, we are committed to building lasting relationships with our clients. Our goal is to help you make informed decisions and secure the best loan options available. We take pride in our reputation for integrity, professionalism, and excellence in customer service.\n\n" +
//                         "Get in Touch\n\n" +
//                         "We are here to help you every step of the way. If you have any questions or need assistance, please feel free to contact us at:\n\n" +
//                         "- Phone: [Your Phone Number]\n" +
//                         "- Email: [Your Email Address]\n" +
//                         "- Address: [Your Office Address]\n\n" +
//                         "Thank you for choosing Home Loan Solutions. We look forward to helping you find the perfect home loan for your needs.";
//
//        // Create a JTextArea to display the content
//        JTextArea textArea = new JTextArea(20, 50); // 20 rows, 50 columns
//        textArea.setText(aboutUs);
//        textArea.setEditable(false);
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
//
//        // Put the JTextArea in a JScrollPane
//        JScrollPane scrollPane = new JScrollPane(textArea);
//
//        // Create and display the dialog
//        JOptionPane.showMessageDialog(null, scrollPane, "About Us", JOptionPane.INFORMATION_MESSAGE);
//    }

//    private static void showFAQs() {
//        JOptionPane.showMessageDialog(null, "FAQs: Frequently Asked Questions", "FAQs", JOptionPane.INFORMATION_MESSAGE);
//    }
}
