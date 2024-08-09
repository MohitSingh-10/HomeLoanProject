import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.ApplicationStatusDAOImpl;

public class LoanStatus {
	public static void showCheckLoanStatusDialog() {
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JTextField applicationIdField = new JTextField();
        JTextField dobField = new JTextField();

        panel.add(new JLabel("Application ID:"));
        panel.add(applicationIdField);
        panel.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
        panel.add(dobField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Check Loan Status", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            int applicationId = Integer.parseInt(applicationIdField.getText());
            String dob = dobField.getText();
            checkLoanStatus(applicationId, dob);
        }
    }

    private static void checkLoanStatus(int applicationId, String dob) {
    	ApplicationStatusDAOImpl a=new ApplicationStatusDAOImpl();
		String ans=a.getApplicationStatus(applicationId,dob);
		JOptionPane.showMessageDialog(null, ans);


    }
}
