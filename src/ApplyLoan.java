import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ApplyLoan{
	public static void showLoanApplicationPage() {
		 
		// Income Details Fields
	    String[] employmentTypes = { "Salaried", "Self-Employed", "Freelancer", "Retired", "Unemployed" };
	    JComboBox<String> employmentTypeDropdown = new JComboBox<>(employmentTypes);
	    JTextField organizationField = new JTextField();
	    JTextField employerNameField = new JTextField();
 
	    JTextField retirementAgeField = new JTextField();
 
	    // Loan Details Fields
	    JTextField applicationIdField = new JTextField();
	    JTextField loanAmountField = new JTextField();
	    JTextField tenureField = new JTextField();
	    JTextField rateOfInterestField = new JTextField();
	    JTextField monthlyIncomeField = new JTextField();
	    JTextField maxLoanAmountField = new JTextField();
	    JTextField emiField = new JTextField();
	    JTextField applicationStatusField = new JTextField();
	    JTextField submissionDateField = new JTextField();
 
	    // Personal Details Fields
	    JTextField personalCustomerIdField = new JTextField();
	    JTextField nameField = new JTextField();
	    JTextField emailIdField = new JTextField();
	    JTextField ageField = new JTextField();
	    JTextField dobField = new JTextField();
	    JTextField pannumberField = new JTextField();
	    JTextField aadharnoField = new JTextField();
	    JTextField phoneNumberField = new JTextField();
	    String[] genderTypes = { "Female", "Male", "Non-binary", "Other" };
	    JComboBox<String> genderDropdown = new JComboBox<>(genderTypes);
	    JTextField nationalityField = new JTextField();
 
	    // Document Uploads Fields
	    JButton nocFromBuilderButton = new JButton("Upload");
	    JLabel nocFromBuilderLabel = new JLabel("NOC from Builder: Not Uploaded");
	    JButton loaButton = new JButton("Upload");
	    JLabel loaLabel = new JLabel("Letter of Agreement (LOA): Not Uploaded");
	    JButton panButton = new JButton("Upload");
	    JLabel panLabel = new JLabel("PAN: Not Uploaded");
	    JButton voterIdButton = new JButton("Upload");
	    JLabel voterIdLabel = new JLabel("Voter ID: Not Uploaded");
	    JButton salarySlipButton = new JButton("Upload");
	    JLabel salarySlipLabel = new JLabel("Salary Slip: Not Uploaded");
	    JButton agreementToSaleButton = new JButton("Upload");
	    JLabel agreementToSaleLabel = new JLabel("Agreement to Sale: Not Uploaded");
 
	 // Calculate Button
	    JButton calculateButton = new JButton("Calculate Max Loan Amount & EMI");
 
	    // JFrame and main panel setup
	    JFrame frame = new JFrame("Loan Application Form");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(900, 700); // Adjust the size as needed
 
	    JPanel panel = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(5, 5, 5, 5); // Add padding
 
	    // Income Details Section
	    JPanel incomeDetailsPanel = new JPanel(new GridLayout(6, 2, 10, 10));
	    incomeDetailsPanel.setBorder(BorderFactory.createTitledBorder("Income Details"));
	    incomeDetailsPanel.add(new JLabel("Employment Type:"));
	    incomeDetailsPanel.add(employmentTypeDropdown);
	    incomeDetailsPanel.add(new JLabel("Organization:"));
	    incomeDetailsPanel.add(organizationField);
	    incomeDetailsPanel.add(new JLabel("Employer Name:"));
	    incomeDetailsPanel.add(employerNameField);
	    incomeDetailsPanel.add(new JLabel("Monthly Income:"));
	    incomeDetailsPanel.add(monthlyIncomeField);
	    incomeDetailsPanel.add(new JLabel("Retirement Age:"));
	    incomeDetailsPanel.add(retirementAgeField);
 
	    // Loan Details Section
	    JPanel loanDetailsPanel = new JPanel(new GridLayout(8, 2, 10, 10));
	    loanDetailsPanel.setBorder(BorderFactory.createTitledBorder("Loan Details"));
	    loanDetailsPanel.add(new JLabel("Application ID:"));
	    int appId = generateApplicationId();
	    applicationIdField.setText(String.valueOf(appId));
	    applicationIdField.setEditable(false);
	    loanDetailsPanel.add(applicationIdField);
	    loanDetailsPanel.add(new JLabel("Loan Amount:"));
	    loanDetailsPanel.add(loanAmountField);
	    loanDetailsPanel.add(new JLabel("Tenure:"));
	    loanDetailsPanel.add(tenureField);
	    loanDetailsPanel.add(new JLabel("Rate of Interest:"));
	    rateOfInterestField.setText(String.valueOf(Globals.ROI) + "% p.a.");
	    rateOfInterestField.setEditable(false);
	    loanDetailsPanel.add(rateOfInterestField);
	    loanDetailsPanel.add(new JLabel("Application Status:"));
	    applicationStatusField.setText("Pending");
	    applicationStatusField.setEditable(false);
	    loanDetailsPanel.add(applicationStatusField);
	    loanDetailsPanel.add(new JLabel("Submission Date:"));
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String currentDate = LocalDate.now().format(formatter);
	    submissionDateField.setText(currentDate);
	    submissionDateField.setEditable(false);
	    loanDetailsPanel.add(submissionDateField);
	    loanDetailsPanel.add(new JLabel("Max Loan Amount:"));
	    maxLoanAmountField.setEditable(false);
	    loanDetailsPanel.add(maxLoanAmountField);
	    loanDetailsPanel.add(new JLabel("EMI:"));
	    emiField.setEditable(false);
	    loanDetailsPanel.add(emiField); 
 
	    JPanel calculate = new JPanel(new GridLayout(1, 2, 1, 1));
	    calculate.add(calculateButton);
 
	    // Personal Details Section
	    JPanel personalDetailsPanel = new JPanel(new GridLayout(10, 2, 10, 10));
	    personalDetailsPanel.setBorder(BorderFactory.createTitledBorder("Personal Details"));
	    personalDetailsPanel.add(new JLabel("Customer ID:"));
	    personalDetailsPanel.add(personalCustomerIdField);
	    personalDetailsPanel.add(new JLabel("Name:"));
	    personalDetailsPanel.add(nameField);
	    personalDetailsPanel.add(new JLabel("Email ID:"));
	    personalDetailsPanel.add(emailIdField);
	    personalDetailsPanel.add(new JLabel("Age:"));
	    personalDetailsPanel.add(ageField);
	    personalDetailsPanel.add(new JLabel("Date of Birth:"));
	    personalDetailsPanel.add(dobField);
	    personalDetailsPanel.add(new JLabel("PAN Number:"));
	    personalDetailsPanel.add(pannumberField);
	    personalDetailsPanel.add(new JLabel("Aadhar Number:"));
	    personalDetailsPanel.add(aadharnoField);
	    personalDetailsPanel.add(new JLabel("Phone Number:"));
	    personalDetailsPanel.add(phoneNumberField);
	    personalDetailsPanel.add(new JLabel("Gender:"));
	    personalDetailsPanel.add(genderDropdown);
	    personalDetailsPanel.add(new JLabel("Nationality:"));
	    personalDetailsPanel.add(nationalityField);
 
	 // Submit Button
	    JButton submitButton = new JButton("Submit");
 
	    // Document Uploads Section
	    JPanel documentsPanel = new JPanel(new GridLayout(6, 2, 10, 10));
	    documentsPanel.setBorder(BorderFactory.createTitledBorder("Document Uploads"));
	    documentsPanel.add(new JLabel("NOC from Builder:"));
	    documentsPanel.add(nocFromBuilderButton);
	    nocFromBuilderButton.addActionListener(e -> {
	        int response = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct document?",
	                "Confirm Upload", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (response == JOptionPane.YES_OPTION) {
	            nocFromBuilderLabel.setText("NOC from Builder: Uploaded");
	        }
	    });
	    documentsPanel.add(nocFromBuilderLabel);
 
	    documentsPanel.add(new JLabel("Letter of Agreement (LOA):"));
	    documentsPanel.add(loaButton);
	    loaButton.addActionListener(e -> {
	        int response = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct document?",
	                "Confirm Upload", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (response == JOptionPane.YES_OPTION) {
	            loaLabel.setText("Letter of Agreement (LOA): Uploaded");
	        }
	    });
	    documentsPanel.add(loaLabel);
 
	    documentsPanel.add(new JLabel("PAN:"));
	    documentsPanel.add(panButton);
	    panButton.addActionListener(e -> {
	        int response = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct document?",
	                "Confirm Upload", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (response == JOptionPane.YES_OPTION) {
	            panLabel.setText("PAN: Uploaded");
	        }
	    });
	    documentsPanel.add(panLabel);
 
	    documentsPanel.add(new JLabel("Voter ID:"));
	    documentsPanel.add(voterIdButton);
	    voterIdButton.addActionListener(e -> {
	        int response = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct document?",
	                "Confirm Upload", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (response == JOptionPane.YES_OPTION) {
	            voterIdLabel.setText("Voter ID: Uploaded");
	        }
	    });
	    documentsPanel.add(voterIdLabel);
 
	    documentsPanel.add(new JLabel("Salary Slip:"));
	    documentsPanel.add(salarySlipButton);
	    salarySlipButton.addActionListener(e -> {
	        int response = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct document?",
	                "Confirm Upload", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (response == JOptionPane.YES_OPTION) {
	            salarySlipLabel.setText("Salary Slip: Uploaded");
	        }
	    });
	    documentsPanel.add(salarySlipLabel);
 
	    documentsPanel.add(new JLabel("Agreement to Sale:"));
	    documentsPanel.add(agreementToSaleButton);
	    agreementToSaleButton.addActionListener(e -> {
	        int response = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct document?",
	                "Confirm Upload", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (response == JOptionPane.YES_OPTION) {
	            agreementToSaleLabel.setText("Agreement to Sale: Uploaded");
	        }
	    });
	    documentsPanel.add(agreementToSaleLabel);
 
	    // Combine all sections into the main panel
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    panel.add(incomeDetailsPanel, gbc);
 
	    gbc.gridy++;
	    panel.add(loanDetailsPanel, gbc);
 
	    gbc.gridy++;
	    panel.add(calculate, gbc);
 
	    gbc.gridy++;
	    panel.add(personalDetailsPanel, gbc);
 
	    gbc.gridy++;
	    panel.add(documentsPanel, gbc);
 
	    gbc.gridy++;
	    gbc.anchor = GridBagConstraints.CENTER;
	    panel.add(submitButton, gbc);
 
	 // Add action listener to calculate button
	    calculateButton.addActionListener(e -> {
	        try {
	            double monthlyIncome = Double.parseDouble(monthlyIncomeField.getText());
	            double loanAmount = Double.parseDouble(loanAmountField.getText());
	            int tenure = Integer.parseInt(tenureField.getText());
	            double interestRate = 8.5;
 
	            // Example calculation logic
	            double maxLoanAmount = LoanCalculator.calculateEligibility(monthlyIncome); // Simple example
	            double emi = LoanCalculator.calculateEMI(loanAmount, interestRate, tenure); // Simplified EMI calculation
 
	            maxLoanAmountField.setText(String.format("%.2f", maxLoanAmount));
	            emiField.setText(String.format("%.2f", emi));
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    });
 
 
	    // Scroll pane for the main panel
	    JScrollPane scrollPane = new JScrollPane(panel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 
	    // Finalize the frame
	    frame.add(scrollPane);
	    frame.setVisible(true);
 
	}
	private static int generateApplicationId() {
		// Example: Generate application ID using timestamp
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}
	private static java.sql.Date parseDate(String dateString) {
	    try {
	        // Adjust the date format as per your input format
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date utilDate = sdf.parse(dateString);
	        return new java.sql.Date(utilDate.getTime());
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null; // Handle appropriately in production code
	    }
	}
}