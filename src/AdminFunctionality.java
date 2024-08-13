


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
//	public static void showAdminApprove(){
//        JPanel panel = new JPanel(new GridLayout(2, 2));
//
//        JTextField customerIdField = new JTextField();
//
//        panel.add(new JLabel("Application ID:"));
//        panel.add(customerIdField);
//        // Define custom button labels
//        JButton approve = new JButton("Approve");
//        JButton reject = new JButton("Reject");
//
//        // Add buttons to the panel
//        panel.add(approve);
//        panel.add(reject);
//        
//        approve.addActionListener(e->{
//        	System.out.println("runned");
//        });
//        
//    }
	

	public static void showAdminApprove() {
        // Create a modal dialog
        JDialog dialog = new JDialog((Frame) null, "Approval/Rejection Dialog", true);
        dialog.setLayout(new GridLayout(3, 2));
        
        // Create components
        JLabel label = new JLabel("Application ID:");
        JTextField textField = new JTextField();
        JButton approveButton = new JButton("Approve");
        JButton rejectButton = new JButton("Reject");

        // Add components to the dialog
        dialog.add(label);
        dialog.add(textField);
        dialog.add(approveButton);
        dialog.add(rejectButton);
        
        // Set dialog size and location
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);

        // Add action listeners
        approveButton.addActionListener(e -> {
            approveAction(textField.getText());
            dialog.dispose(); // Close the dialog after action
        });

        rejectButton.addActionListener(e -> {
            rejectAction(textField.getText());
            dialog.dispose(); // Close the dialog after action
        });

        // Show the dialog
        dialog.setVisible(true);
    }

    private static void approveAction(String applicationId) {
        // Method for "Approve" button
//        System.out.println("Approve action called with input: " + input);
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
        // Method for "Reject" button
//        System.out.println("Reject action called with input: " + input);
    	LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
        String s = a.rejectApplication(Integer.parseInt(applicationId));
        JOptionPane.showMessageDialog(null, s);
    }
	    
	

	
	
	private static void rejectLoan(String applicationId) {
		// TODO Auto-generated method stub
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
        String s = a.approveApplication(Integer.parseInt(applicationId));
        JOptionPane.showMessageDialog(null, s);
	}


	private static void approveLoan(String applicationId) {
//        String applicationId = customerIdField.getText();
        LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
        String s = a.approveApplication(Integer.parseInt(applicationId));
        JOptionPane.showMessageDialog(null, s);
    }
	public static void showPending() {
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
		String[][] data = a.allPendingApplication();
		// Column names
        String[] columnNames = {"ApplicationID", "CustomerID", "Employer Name", "Monthly Income", "Loan Amount", "Tenure"};

        // Create a table model and set it to the JTable
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JFrame and set its properties
        JFrame frame = new JFrame("Pending Loans");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 300);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}
	
	public static void showRejected() {
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
		String[][] data = a.allRejectedApplication();
		// Column names
        String[] columnNames = {"ApplicationID", "CustomerID", "Employer Name", "Monthly Income", "Loan Amount", "Tenure"};

        // Create a table model and set it to the JTable
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JFrame and set its properties
        JFrame frame = new JFrame("Rejected Loans");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 300);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}
	
	public static void showApproved() {
//		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
//		
//		JOptionPane.showMessageDialog(null, a.allApprovedApplication());
        
		LoanApplicationDAOImpl a = new LoanApplicationDAOImpl();
		String[][] data = a.allApprovedApplication();
		// Column names
        String[] columnNames = {"ApplicationID", "CustomerID", "Loan Amount", "Interest Rate", "Start Date", "End Date", "EMI"};

        // Create a table model and set it to the JTable
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JFrame and set its properties
        JFrame frame = new JFrame("Approved Loans");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	            // Create a JScrollPane and add the table to it
	            JScrollPane scrollPane = new JScrollPane(table);

	            // Create a JFrame and set its properties
	            JFrame frame = new JFrame("Table Example");
//	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(700, 300);
	            frame.setLayout(new BorderLayout());
	            frame.add(scrollPane, BorderLayout.CENTER);
	            frame.setVisible(true);
	            frame.setLocationRelativeTo(null);
	        }
	}
	
}
