import java.awt.*;
import javax.swing.*;
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
		System.out.println(ans);
		JOptionPane.showMessageDialog(null, ans);
//		JPanel panel = new JPanel();
//        panel.setPreferredSize(new Dimension(400, 300));
//        System.out.println(ans);
//        JLabel label = new JLabel(ans);
//        panel.add(label);
//
//        JOptionPane.showMessageDialog(null, panel, "Loan Status", JOptionPane.INFORMATION_MESSAGE);
    

    }
}
