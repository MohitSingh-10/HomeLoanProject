import java.util.Scanner;

public class HomeLoanHomepage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Print the homepage layout
            System.out.println("--------------------------------------------------");
            System.out.println("                 Home Loan Application            ");
            System.out.println("--------------------------------------------------");
            System.out.println("Welcome to the Home Loan Application Portal!");
            System.out.println();
            System.out.println("Please choose an option:");
            System.out.println("1. Log in / Register");
            System.out.println("2. Apply for a New Loan");
            System.out.println("3. Check Loan Status");
            System.out.println("4. Loan Calculator");
            System.out.println("5. About Us");
            System.out.println("6. FAQs");
            System.out.println("7. Exit");
            System.out.println();
            System.out.print("Enter your choice (1-7): ");

            // Read user input
            choice = scanner.nextInt();

            // Process user input with a switch statement
            switch (choice) {
                case 1:
                    // Log in / Register functionality
                    System.out.println("You chose Log in / Register.");
                    System.out.println("Please select an option:");
                    System.out.println("1. Log In");
                    System.out.println("2. Register");
                    System.out.println();
                    System.out.print("Enter your choice (1-2): ");

                    int loginRegisterChoice = scanner.nextInt();

                    switch (loginRegisterChoice) {
                        case 1:
                            System.out.println("You chose Log In.");
                            // Add functionality for logging in
                            break;
                        case 2:
                            System.out.println("You chose Register.");
                            // Add functionality for registering
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1 or 2.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("You chose to Apply for a New Loan.");
                    // Add functionality for applying for a new loan
                    break;
                case 3:
                    System.out.println("You chose to Check Loan Status.");
                    // Add functionality to check loan status
                    break;
                case 4:
                    // Loan Calculator functionality
                    System.out.println("You chose Loan Calculator.");
                    System.out.println("Which type of calculator would you like to use?");
                    System.out.println("1. Eligibility Calculator");
                    System.out.println("2. EMI Calculator");
                    System.out.println();
                    System.out.print("Enter your choice (1-2): ");

                    int calculatorChoice = scanner.nextInt();
                    
                    switch (calculatorChoice) {
                        case 1:
                            System.out.println("You chose Eligibility Calculator.");
                            // Add functionality for eligibility calculator
                            break;
                        case 2:
                            System.out.println("You chose EMI Calculator.");
                            // Add functionality for EMI calculator
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1 or 2.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("You chose About Us.");
                    // Add functionality to show information about the company
                    break;
                case 6:
                    System.out.println("You chose FAQs.");
                    // Add functionality to show frequently asked questions
                    break;
                case 7:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
            System.out.println(); // Print a blank line for better readability
        } while (choice != 7);

        // Close the scanner
        scanner.close();
    }
}
