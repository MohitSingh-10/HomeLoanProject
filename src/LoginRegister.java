import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginRegister {
	public static void showLoginRegisterOptions() {
        String[] options = {"Log In", "Register"};
        int choice = JOptionPane.showOptionDialog(null, "Please select an option:", "Log in / Register",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showLoginDialog();
        } else if (choice == 1) {
            JOptionPane.showMessageDialog(null, "You chose Register.");
            // Add functionality for registering
        }
    }

    private static void showLoginDialog() {
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JTextField customerIdField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("Customer ID:"));
        panel.add(customerIdField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Log In", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String customerId = customerIdField.getText();
            String password = new String(passwordField.getPassword());
            login(customerId, password);
        }
    }

    private static void login(String customerId, String password) {
        // Placeholder for login validation
        JOptionPane.showMessageDialog(null, "Logged in successfully with Customer ID: " + customerId, "Login", JOptionPane.INFORMATION_MESSAGE);
        
        // Update the main panel to reflect the login
        GraphicHomepage.login(customerId);
    }

    
}
