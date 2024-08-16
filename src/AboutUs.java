import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutUs {
	public static void showAboutUs() {
        String aboutUs = "About Us\n\n" +
                         "Welcome to Home Loan Solutions!\n\n" +
                         "At Home Loan Solutions, our mission is to help you achieve your dream of owning a home with ease and confidence. We understand that securing a home loan can be a complex and daunting process, which is why we are dedicated to providing you with clear, straightforward, and personalized financial solutions.\n\n" +
                         "Who We Are\n\n" +
                         "Founded in [Year], Home Loan Solutions is a leading provider of home loan services committed to making home ownership accessible to everyone. Our team of experienced financial advisors and mortgage experts is here to guide you through every step of the loan application process, from pre-approval to closing.\n\n" +
                         "Our Services\n\n" +
                         "- Home Purchase Loans: We offer competitive rates and flexible terms for purchasing your new home.\n" +
                         "- Refinancing: Lower your monthly payments or access your home's equity with our refinancing options.\n" +
                         "- Home Equity Loans: Tap into the equity of your current home for renovations, debt consolidation, or other needs.\n" +
                         "- Pre-Approval: Get a head start on your home buying journey with our quick and easy pre-approval process.\n\n" +
                         "Why Choose Us?\n\n" +
                         "- Expert Advice: Our knowledgeable team is dedicated to providing you with expert advice tailored to your financial situation.\n" +
                         "- Personalized Solutions: We offer a range of loan products designed to meet your unique needs and goals.\n" +
                         "- Transparency: We believe in clear and honest communication, ensuring you understand every aspect of your loan.\n" +
                         "- Customer-Centric Approach: Your satisfaction is our priority. We are here to support you throughout the entire loan process and beyond.\n\n" +
                         "Our Commitment\n\n" +
                         "At Home Loan Solutions, we are committed to building lasting relationships with our clients. Our goal is to help you make informed decisions and secure the best loan options available. We take pride in our reputation for integrity, professionalism, and excellence in customer service.\n\n" +
                         "Get in Touch\n\n" +
                         "We are here to help you every step of the way. If you have any questions or need assistance, please feel free to contact us at:\n\n" +
                         "- Phone: [Your Phone Number]\n" +
                         "- Email: [Your Email Address]\n" +
                         "- Address: [Your Office Address]\n\n" +
                         "Thank you for choosing Home Loan Solutions. We look forward to helping you find the perfect home loan for your needs.";

        JTextArea textArea = new JTextArea(20, 50); 
        textArea.setText(aboutUs);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "About Us", JOptionPane.INFORMATION_MESSAGE);
    }
}
