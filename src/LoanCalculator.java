import javax.swing.JOptionPane;

public class LoanCalculator {
	public static void showLoanCalculatorOptions() {
        String[] options = {"Eligibility Calculator", "EMI Calculator"};
        int choice = JOptionPane.showOptionDialog(null, "Which type of calculator would you like to use?", "Loan Calculator",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showEligibilityCalculator();
        } else if (choice == 1) {
            showEMICalculator();
        }
    }

    private static void showEligibilityCalculator() {
        try {
            String input = JOptionPane.showInputDialog(null, "Enter your net monthly salary:", "Eligibility Calculator", JOptionPane.QUESTION_MESSAGE);
            if (input != null) {
                double netMonthlySalary = Double.parseDouble(input);
                double eligibility = calculateEligibility(netMonthlySalary);
                JOptionPane.showMessageDialog(null, "Based on your net monthly salary, your maximum eligible loan amount is: Rs." + String.format("%.2f", eligibility), "Eligibility Result", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void showEMICalculator() {
        try {
            String principalInput = JOptionPane.showInputDialog(null, "Enter the loan principal amount:", "EMI Calculator", JOptionPane.QUESTION_MESSAGE);
            String annualInterestRateInput = JOptionPane.showInputDialog(null, "Enter the annual interest rate (in %):", "EMI Calculator", JOptionPane.QUESTION_MESSAGE);
            String tenureInput = JOptionPane.showInputDialog(null, "Enter the loan tenure (in years):", "EMI Calculator", JOptionPane.QUESTION_MESSAGE);

            if (principalInput != null && annualInterestRateInput != null && tenureInput != null) {
                double principal = Double.parseDouble(principalInput);
                double annualInterestRate = Double.parseDouble(annualInterestRateInput);
                int tenureInYears = Integer.parseInt(tenureInput);
                double emi = calculateEMI(principal, annualInterestRate, tenureInYears);
                JOptionPane.showMessageDialog(null, "The EMI for your loan is: Rs." + String.format("%.2f", emi), "EMI Result", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Methods for calculations
    public static double calculateEligibility(double netMonthlySalary) {
        return 60 * (0.6 * netMonthlySalary);
    }

    public static double calculateEMI(double principal, double annualInterestRate, int tenureInYears) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int tenureInMonths = tenureInYears * 12;
        return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureInMonths)) /
                (Math.pow(1 + monthlyInterestRate, tenureInMonths) - 1);
    }
}
