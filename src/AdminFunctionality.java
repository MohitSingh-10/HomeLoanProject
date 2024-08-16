import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.ApplicationStatusDAOImpl;
import dao.BankAccountDAOImpl;
import dao.LoanApplicationDAOImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class AdminFunctionality {


	public static void showAdminApprove() {
        JDialog dialog = new JDialog((Frame) null, "Approval/Rejection Dialog", true);
        dialog.setLayout(new GridLayout(3, 2));
        
       
        JLabel label = new JLabel("Application ID:");
        JTextField textField = new JTextField();
        JButton approveButton = new JButton("Approve");
        JButton rejectButton = new JButton("Reject");

        dialog.add(label);
        dialog.add(textField);
        dialog.add(approveButton);
        dialog.add(rejectButton);
        
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);

        approveButton.addActionListener(e -> {
            approveAction(textField.getText());
            dialog.dispose();
        });

        rejectButton.addActionListener(e -> {
            rejectAction(textField.getText());
            dialog.dispose();
        });

        dialog.setVisible(true);
    }

    private static void approveAction(String applicationId) {
    	 LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
         String s = a.approveApplication(Integer.parseInt(applicationId));
         JOptionPane.showMessageDialog(null, s);
         if(s.equals("Your loan has been approved")) {
        	 BankAccountDAOImpl b = new BankAccountDAOImpl();
             ApplicationStatusDAOImpl ab = new ApplicationStatusDAOImpl();
             
             String ans = b.addBalance(ab.getLoanAmount(Integer.parseInt(applicationId)),ab.getCustomerId(Integer.parseInt(applicationId)) );
             JOptionPane.showMessageDialog(null, ans);
         }
        
    }

    private static void rejectAction(String applicationId) {
    	LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
        String s = a.rejectApplication(Integer.parseInt(applicationId));
        JOptionPane.showMessageDialog(null, s);
    }
	    
	

	
	
	private static void rejectLoan(String applicationId) {
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
        String s = a.approveApplication(Integer.parseInt(applicationId));
        JOptionPane.showMessageDialog(null, s);
	}


	private static void approveLoan(String applicationId) {
        LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
        String s = a.approveApplication(Integer.parseInt(applicationId));
        JOptionPane.showMessageDialog(null, s);
    }
	public static void showPending() {
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
		String[][] data = a.allPendingApplication();
	
        String[] columnNames = {"ApplicationID", "CustomerID", "Employer Name", "Monthly Income", "Loan Amount", "Tenure"};

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Pending Loans");
        frame.setSize(700, 300);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}
	
	public static void showRejected() {
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
		String[][] data = a.allRejectedApplication();
        String[] columnNames = {"ApplicationID", "CustomerID", "Employer Name", "Monthly Income", "Loan Amount", "Tenure"};

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Rejected Loans");
        frame.setSize(700, 300);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}
	
	public static void showApproved() {
        
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
		String[][] data = a.allApprovedApplication();
        String[] columnNames = {"ApplicationID", "CustomerID", "Loan Amount", "Interest Rate", "Start Date", "End Date", "EMI"};

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Approved Loans");
        frame.setSize(700, 300);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}
	
	public static void showApplication() {
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
		 JPanel panel = new JPanel(new GridLayout(1, 2));

	        JTextField applicationIdField = new JTextField();

	        panel.add(new JLabel("Application ID:"));
	        panel.add(applicationIdField);

	        int result = JOptionPane.showConfirmDialog(null, panel, "Application Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

	        if (result == JOptionPane.OK_OPTION) {
	            String applicationId = applicationIdField.getText();
	         
	            String[][] s = a.allLoanUid(Integer.parseInt(applicationId));
	            
	            String[] columnNames = {"ApplicationID", "Monthly Income", "Loan Amount", "Tenure", "Application Status"};

	            DefaultTableModel tableModel = new DefaultTableModel(s, columnNames);
	            JTable table = new JTable(tableModel);

	            JScrollPane scrollPane = new JScrollPane(table);

	            JFrame frame = new JFrame("Table Example");
	            frame.setSize(700, 300);
	            frame.setLayout(new BorderLayout());
	            frame.add(scrollPane, BorderLayout.CENTER);
	            frame.setVisible(true);
	            frame.setLocationRelativeTo(null);
	        }
	}
	
}
