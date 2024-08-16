import java.util.Scanner;

public class HomeLoanHomepage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
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

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
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
                            break;
                        case 2:
                            System.out.println("You chose Register.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1 or 2.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("You chose to Apply for a New Loan.");
                    break;
                case 3:
                    System.out.println("You chose to Check Loan Status.");
                    break;
                case 4:
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
                            break;
                        case 2:
                            System.out.println("You chose EMI Calculator.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1 or 2.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("You chose About Us.");
                    break;
                case 6:
                    System.out.println("You chose FAQs.");
                    break;
                case 7:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
            System.out.println(); 
        } while (choice != 7);

        scanner.close();
    }
}
