import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Try {

    public static void showLoanApplicationPage() {
        // Create the frame
        JFrame frame = new JFrame("Loan Application Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700); // Adjust the size as needed

        // Create panels for different sections
        JPanel incomeDetailsPanel = createIncomeDetailsPanel();
        JPanel loanDetailsPanel = createLoanDetailsPanel();
        JPanel personalDetailsPanel = createPersonalDetailsPanel();
        JPanel documentsPanel = createDocumentsPanel();
        JPanel calculatePanel = createCalculatePanel();

        // Combine all sections into the main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(incomeDetailsPanel, gbc);

        gbc.gridy++;
        mainPanel.add(loanDetailsPanel, gbc);

        gbc.gridy++;
        mainPanel.add(calculatePanel, gbc);

        gbc.gridy++;
        mainPanel.add(personalDetailsPanel, gbc);

        gbc.gridy++;
        mainPanel.add(documentsPanel, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit");
        mainPanel.add(submitButton, gbc);

        // Add action listener to calculate button
        addCalculateButtonListener(loanDetailsPanel);

        // Add scroll pane for the main panel
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Finalize the frame
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    private static JPanel createIncomeDetailsPanel() {
        String[] employmentTypes = { "Salaried", "Self-Employed", "Freelancer", "Retired", "Unemployed" };
        JComboBox<String> employmentTypeDropdown = new JComboBox<>(employmentTypes);
        JTextField organizationField = new JTextField();
        JTextField employerNameField = new JTextField();
        JTextField monthlyIncomeField = new JTextField();
        JTextField retirementAgeField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Income Details"));
        panel.add(new JLabel("Employment Type:"));
        panel.add(employmentTypeDropdown);
        panel.add(new JLabel("Organization:"));
        panel.add(organizationField);
        panel.add(new JLabel("Employer Name:"));
        panel.add(employerNameField);
        panel.add(new JLabel("Monthly Income:"));
        panel.add(monthlyIncomeField);
        panel.add(new JLabel("Retirement Age:"));
        panel.add(retirementAgeField);

        return panel;
    }

    private static JPanel createLoanDetailsPanel() {
        JTextField applicationIdField = new JTextField(String.valueOf(generateApplicationId()));
        applicationIdField.setEditable(false);
        JTextField loanAmountField = new JTextField();
        JTextField tenureField = new JTextField();
        JTextField rateOfInterestField = new JTextField("8.5% p.a.");
        rateOfInterestField.setEditable(false);
        JTextField maxLoanAmountField = new JTextField();
        maxLoanAmountField.setEditable(false);
        JTextField emiField = new JTextField();
        emiField.setEditable(false);
        JTextField applicationStatusField = new JTextField("Pending");
        applicationStatusField.setEditable(false);
        JTextField submissionDateField = new JTextField(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        submissionDateField.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Loan Details"));
        panel.add(new JLabel("Application ID:"));
        panel.add(applicationIdField);
        panel.add(new JLabel("Loan Amount:"));
        panel.add(loanAmountField);
        panel.add(new JLabel("Tenure:"));
        panel.add(tenureField);
        panel.add(new JLabel("Rate of Interest:"));
        panel.add(rateOfInterestField);
        panel.add(new JLabel("Application Status:"));
        panel.add(applicationStatusField);
        panel.add(new JLabel("Submission Date:"));
        panel.add(submissionDateField);
        panel.add(new JLabel("Max Loan Amount:"));
        panel.add(maxLoanAmountField);
        panel.add(new JLabel("EMI:"));
        panel.add(emiField);

        return panel;
    }

    private static JPanel createPersonalDetailsPanel() {
        String[] genderTypes = { "Female", "Male", "Non-binary", "Other" };
        JComboBox<String> genderDropdown = new JComboBox<>(genderTypes);

        JTextField personalCustomerIdField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailIdField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField dobField = new JTextField();
        JTextField pannumberField = new JTextField();
        JTextField aadharnoField = new JTextField();
        JTextField phoneNumberField = new JTextField();
        JTextField nationalityField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Personal Details"));
        panel.add(new JLabel("Customer ID:"));
        panel.add(personalCustomerIdField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email ID:"));
        panel.add(emailIdField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Date of Birth:"));
        panel.add(dobField);
        panel.add(new JLabel("PAN Number:"));
        panel.add(pannumberField);
        panel.add(new JLabel("Aadhar Number:"));
        panel.add(aadharnoField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderDropdown);
        panel.add(new JLabel("Nationality:"));
        panel.add(nationalityField);

        return panel;
    }

    private static JPanel createDocumentsPanel() {
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

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Document Uploads"));

        addUploadButton(panel, nocFromBuilderButton, nocFromBuilderLabel, "NOC from Builder");
        addUploadButton(panel, loaButton, loaLabel, "Letter of Agreement (LOA)");
        addUploadButton(panel, panButton, panLabel, "PAN");
        addUploadButton(panel, voterIdButton, voterIdLabel, "Voter ID");
        addUploadButton(panel, salarySlipButton, salarySlipLabel, "Salary Slip");
        addUploadButton(panel, agreementToSaleButton, agreementToSaleLabel, "Agreement to Sale");

        return panel;
    }

    private static JPanel createCalculatePanel() {
        JButton calculateButton = new JButton("Calculate Max Loan Amount & EMI");
        JPanel panel = new JPanel(new GridLayout(1, 1, 10, 10));
        panel.add(calculateButton);
        return panel;
    }

    private static void addUploadButton(JPanel panel, JButton button, JLabel label, String documentType) {
        panel.add(new JLabel(documentType + ":"));
        panel.add(button);
        button.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct document?",
                    "Confirm Upload", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                label.setText(documentType + ": Uploaded");
            }
        });
        panel.add(label);
    }

    private static void addCalculateButtonListener(JPanel loanDetailsPanel) {
        JButton calculateButton = (JButton) ((JPanel) ((JPanel) loanDetailsPanel.getParent()).getComponent(2)).getComponent(0);
        calculateButton.addActionListener(e -> {
            JTextField monthlyIncomeField = (JTextField) ((JPanel) loanDetailsPanel.getComponent(3)).getComponent(1);
            JTextField loanAmountField = (JTextField) ((JPanel) loanDetailsPanel.getComponent(1)).getComponent(1);
            JTextField tenureField = (JTextField) ((JPanel) loanDetailsPanel.getComponent(2)).getComponent(1);
            JTextField maxLoanAmountField = (JTextField) ((JPanel) loanDetailsPanel.getComponent(6)).getComponent(1);
            JTextField emiField = (JTextField) ((JPanel) loanDetailsPanel.getComponent(7)).getComponent(1);

            try {
                double monthlyIncome = Double.parseDouble(monthlyIncomeField.getText());
                double loanAmount = Double.parseDouble(loanAmountField.getText());
                int tenure = Integer.parseInt(tenureField.getText());
                double interestRate = 8.5;

                double maxLoanAmount = LoanCalculator.calculateEligibility(monthlyIncome);
                double emi = LoanCalculator.calculateEMI(loanAmount, interestRate, tenure);

                maxLoanAmountField.setText(String.format("%.2f", maxLoanAmount));
                emiField.setText(String.format("%.2f", emi));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private static int generateApplicationId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
