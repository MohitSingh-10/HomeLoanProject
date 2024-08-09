import javax.swing.JOptionPane;

public class FAQs {

	public static void showFAQs() {
        String faqs = "=========================================FAQs=========================================\n\n" +
                      "---1. For what purpose can I seek a first time home loan?\n" +
                      "You can generally seek a first time home loan for buying a house or a flat,\n" +
                      "renovation, extension and repairs to your existing house. Most banks have a separate \n" +
                      "policy for those who are going for a second house. Please remember to seek specific \n" +
                      "clarifications on the above-mentioned issues from your commercial bank.\n\n" +
                      "---2. What is an EMI?\n" +
                      "You repay the loan in Equated Monthly Installments (EMIs) comprising both \n" +
                      "principal and interest. Repayment by way of EMI starts from the month following the \n" +
                      "month in which you take full disbursement.\n\n" +
                      "---3. What documents are generally sought for a loan approval?\n" +
                      "In addition to all legal documents relating to the house being bought, banks \n" +
                      "will also ask you to submit Identity and Residence Proof, latest salary slip (authenticated \n" +
                      "by the employer and self attested for employees ) and Form 16 ( for business persons/ \n" +
                      "self-employed ) and last 6 months bank statements / Balance Sheet, as applicable . You also \n" +
                      "need to submit the completed application form along with your photograph. Loan applications \n" +
                      "form would give a checklist of documents to be attached with the application.\n\n" +
                      "---4. How does tenure affect cost of loan?\n" +
                      "The longer the tenure of the loan, the lesser will be your monthly EMI outflow. \n" +
                      "Shorter tenures mean greater EMI burden, but your loan is repaid faster. If you have a \n" +
                      "short-term cash flow mismatch, your bank may increase the tenure of the loan, and your EMI \n" +
                      "burden comes down. But longer tenures mean payment of larger interest towards the loan and \n" +
                      "make it more expensive.\n";
        
        JOptionPane.showMessageDialog(null, faqs, "FAQs", JOptionPane.INFORMATION_MESSAGE);
    }
	

}
