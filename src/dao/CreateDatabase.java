package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDatabase {
    public static void main(String[] args) {
        // Load the driver
        try {
            System.out.println("Registering driver...");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("Driver registered...");

            System.out.println("Trying to connect to the DB");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeloan", "root", "MySQL");
            System.out.println("Connected to the DB: " + conn);

            conn.setAutoCommit(false);  // Transaction management started

            // Create User table
            PreparedStatement userTable = conn.prepareStatement("CREATE TABLE User (" +
                    "customerId INT PRIMARY KEY AUTO_INCREMENT," +
                    "password VARCHAR(255)," +
                    "admin BOOLEAN," +
                    "email VARCHAR(255)," +
                    "phoneNumber VARCHAR(20)," +
                    "fname VARCHAR(255)," +
                    "mname VARCHAR(255)," +
                    "lname VARCHAR(255)" +
                    ");");

            // Create PersonalDetails table
            PreparedStatement personalDetailsTable = conn.prepareStatement("CREATE TABLE PersonalDetails (" +
                    "customerId INT PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "emailId VARCHAR(255)," +
                    "age INT," +
                    "dob DATETIME," +
                    "panNumber VARCHAR(20)," +
                    "aadharNo BIGINT," +
                    "phoneNumber VARCHAR(20)," +
                    "gender CHAR(1)," +
                    "nationality VARCHAR(100)," +
                    "FOREIGN KEY (customerId) REFERENCES User(customerId)" +
                    ");");

            // Create LoanApplication table
            PreparedStatement createLoanApplication = conn.prepareStatement("CREATE TABLE LoanApplication (" +
                    "applicationId INT PRIMARY KEY AUTO_INCREMENT," +
                    "customerId INT," +
                    "location VARCHAR(255)," +
                    "name VARCHAR(255)," +
                    "estimatedCost DOUBLE," +
                    "employmentType VARCHAR(255)," +
                    "retirementAge INT," +
                    "organization VARCHAR(255)," +
                    "employerName VARCHAR(255)," +
                    "monthlyIncome DOUBLE," +
                    "loanAmount DOUBLE," +
                    "tenure INT," +
                    "rateOfInterest DOUBLE," +
                    "applicationStatus VARCHAR(255)," +
                    "submissionDate DATETIME," +
                    "maxLoanAmount DOUBLE," +
                    "FOREIGN KEY (customerId) REFERENCES User(customerId)" +
                    ");");

            // Create ApplicationStatus table
            PreparedStatement createApplicationStatusTable = conn.prepareStatement("CREATE TABLE ApplicationStatus (" +
                    "applicationId INT PRIMARY KEY," +
                    "customerId INT," +
                    "loanAmount DOUBLE," +
                    "interestRate DOUBLE," +
                    "startDate DATETIME," +
                    "endDate DATETIME," +
                    "emi DOUBLE," +
                    "FOREIGN KEY (applicationId) REFERENCES LoanApplication(applicationId)," +
                    "FOREIGN KEY (customerId) REFERENCES User(customerId)" +
                    ");");

            // Create Documents table
            PreparedStatement createDocumentsTable = conn.prepareStatement("CREATE TABLE Documents (" +
                    "customerId INT PRIMARY KEY," +
                    "panCard BOOLEAN DEFAULT FALSE," +
                    "voterId BOOLEAN DEFAULT FALSE," +
                    "salarySlip BOOLEAN DEFAULT FALSE," +
                    "loa BOOLEAN DEFAULT FALSE," +
                    "nocFromBuilder BOOLEAN DEFAULT FALSE," +
                    "agreementToSale BOOLEAN DEFAULT FALSE," +
                    "FOREIGN KEY (customerId) REFERENCES User(customerId)" +
                    ");");

            // Execute all table creation statements
            userTable.execute();
            personalDetailsTable.execute();
            createLoanApplication.execute();
            createApplicationStatusTable.execute();
            createDocumentsTable.execute();

            conn.commit();
            System.out.println("Tables created successfully!");

            // Close resources
            userTable.close();
            personalDetailsTable.close();
            createLoanApplication.close();
            createApplicationStatusTable.close();
            createDocumentsTable.close();
            conn.close();
            System.out.println("All DB resources are closed...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}