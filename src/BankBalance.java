import java.awt.GridLayout;

import javax.swing.*;

import dao.BankAccount;
import dao.BankAccountDAOImpl;

public class BankBalance {
	public static void displayAccountDetails() {
		BankAccountDAOImpl b = new BankAccountDAOImpl();
		BankAccount data = b.showAccount(Globals.custId);
		
        JFrame frame = new JFrame("Bank Account Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 1));

        JLabel accNoLabel = new JLabel("Account Number: " + data.getAccNo());
        JLabel customerIdLabel = new JLabel("Customer ID: " + data.getCustomerId());
        JLabel nameLabel = new JLabel("Name: " + data.getName());
        JLabel balanceLabel = new JLabel("Balance: $" + data.getBalance());

        frame.add(accNoLabel);
        frame.add(customerIdLabel);
        frame.add(nameLabel);
        frame.add(balanceLabel);

        frame.setVisible(true);
    }
}
