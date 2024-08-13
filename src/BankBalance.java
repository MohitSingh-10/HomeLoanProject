import java.awt.GridLayout;

import javax.swing.*;

import dao.BankAccount;
import dao.BankAccountDAOImpl;

public class BankBalance {
//	public static void accountDetails(){
//		BankAccountDAOImpl b = new BankAccountDAOImpl();
//		BankAccount data = b.showAccount(Globals.custId);
//		displayAccountDetails(data);
//	}
	public static void displayAccountDetails() {
        // Create a new JFrame
		BankAccountDAOImpl b = new BankAccountDAOImpl();
		BankAccount data = b.showAccount(Globals.custId);
		
        JFrame frame = new JFrame("Bank Account Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 1)); // 4 rows, 1 column

        // Create JLabels to display the account details
        JLabel accNoLabel = new JLabel("Account Number: " + data.getAccNo());
        JLabel customerIdLabel = new JLabel("Customer ID: " + data.getCustomerId());
        JLabel nameLabel = new JLabel("Name: " + data.getName());
        JLabel balanceLabel = new JLabel("Balance: $" + data.getBalance());

        // Add labels to the frame
        frame.add(accNoLabel);
        frame.add(customerIdLabel);
        frame.add(nameLabel);
        frame.add(balanceLabel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
