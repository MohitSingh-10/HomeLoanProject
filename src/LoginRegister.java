import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.User;
import dao.UserDAOImpl;

public class LoginRegister {
	public static void showLoginRegisterOptions() {
        String[] options = {"Log In", "Register"};
        int choice = JOptionPane.showOptionDialog(null, "Please select an option:", "Log in / Register",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showLoginDialog();
        } else if (choice == 1) {
            showRegisterDialog();
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
        //JOptionPane.showMessageDialog(null, "Logged in successfully with Customer ID: " + customerId, "Login", JOptionPane.INFORMATION_MESSAGE);
    	UserDAOImpl user=new UserDAOImpl();
    	String ans=user.login(Integer.parseInt(customerId),password);
        // Update the main panel to reflect the login
    	if(ans.equals("No user exists with the given customer Id")) {
    		JOptionPane.showMessageDialog(null,"No user exists with the given customer Id", "login", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(ans.equals("Wrong password entered")) {
    		JOptionPane.showMessageDialog(null,"Wrong password entered", "login", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else {
    		if(ans.substring(17).equals("true")) {
    			GraphicHomepage.adminLogin(customerId);
    			Globals.custId = Integer.parseInt(customerId);
    			
    		}
    		else {
    			GraphicHomepage.login(customerId);
    			Globals.custId = Integer.parseInt(customerId);
    			System.out.println(Globals.custId);
    		}
    	}
        
    }
    
    private static void showRegisterDialog() {
        JPanel panel = new JPanel(new GridLayout(7, 2));

        JTextField firstNameField = new JTextField();
        JTextField middleNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneNumberField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField(); // For confirming password

        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Middle Name:"));
        panel.add(middleNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Confirm Password:"));
        panel.add(confirmPasswordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Register", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String fName = firstNameField.getText();
            String mName = middleNameField.getText();
            String lName = lastNameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (password.equals(confirmPassword)) {
                register(fName, mName, lName, email, phoneNumber, password);
            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void register(String fName, String mName, String lName, String email, String phoneNumber, String password) {
        // Handle registration logic here
//        System.out.println("Registration Details:");
//        System.out.println("Name: " + name);
//        System.out.println("Email: " + email);
//        System.out.println("Phone Number: " + phoneNumber);
//        System.out.println("Password: " + password);
        
        User user=new User();
		user.setAdmin(0);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setFname(fName);
		user.setMname(mName);
		user.setLname(lName);
		UserDAOImpl useri=new UserDAOImpl();
		useri.createUser(user);
//		int id = user.getCustomerId();
//		JOptionPane.showMessageDialog(null, "Your Customer ID : "+id);
    }


    
}
