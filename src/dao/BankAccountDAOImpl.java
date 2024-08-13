package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountDAOImpl implements BankAccountDAO{
	Connection conn = null;

    public BankAccountDAOImpl() {
        try {
            System.out.println("Registering driver...");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("Driver registered...");

            System.out.println("Trying to connect to the DB");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeloan", "root", "MySQL");
            System.out.println("Connected to the DB: " + conn);
        } catch (Exception e) {
            System.out.println("Problem: " + e);
        }
    }
    
    @Override
    public BankAccount showAccount(int accNo) {
        BankAccount account = null;
        String query = "SELECT accNo, customerId, name, balance FROM bankAccount WHERE customerId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, accNo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                account = new BankAccount();
                account.setAccNo(rs.getInt("accNo"));
                account.setCustomerId(rs.getInt("customerId"));
                account.setName(rs.getString("name"));
                account.setBalance(rs.getDouble("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
    
    @Override
//    public String addBalance(double loan, int acc) {
//        String resultMessage = "";
//        System.out.println(loan + " " + acc);
//        
//        // Check if the account exists using customerId
//        String checkQuery = "SELECT accNo FROM bankAccount WHERE customerId = ?";
//        
//        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
//            checkStmt.setInt(1, acc);
//            try (ResultSet rs = checkStmt.executeQuery()) {
//                if (rs.next()) {
//                    // Account exists, retrieve accNo and add the loan amount to the balance
//                    int existingAccNo = rs.getInt("accNo");
//                    System.out.println(existingAccNo);
//                    
//                    String updateQuery = "UPDATE bankAccount SET balance = balance + ? WHERE accNo = ?";
//                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
//                        updateStmt.setDouble(1, loan);
//                        updateStmt.setInt(2, existingAccNo);
//                        int rowsUpdated = updateStmt.executeUpdate();
//                        if (rowsUpdated > 0) {
//                            resultMessage = "Balance added to your account";
//                        }
//                    }
//                } else {
//                    // Account does not exist, create a new account
//                    String insertQuery = "INSERT INTO bankAccount (customerId, name, balance) VALUES (?, ?, ?)";
//                    try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
//                        insertStmt.setInt(1, acc);
//                        System.out.println();
//                        UserDAOImpl u = new UserDAOImpl();
//                        insertStmt.setString(2, u.getName(acc));
//                        insertStmt.setDouble(3, loan);  // Set the initial balance as the loan amount
//                        int rowsInserted = insertStmt.executeUpdate();
//                        if (rowsInserted > 0) {
//                            resultMessage = "Account created and balance added";
//                        }
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            resultMessage = "Error occurred while processing the transaction.";
//        }
//
//        return resultMessage;
//    }
    
    public String addBalance(double loan, int acc) {
        String resultMessage = "";
        System.out.println(loan + " " + acc);
        
        // Check if the account exists using customerId
        String checkQuery = "SELECT accNo FROM bankAccount WHERE customerId = ?";
        
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, acc);
            
            // Execute the query and obtain the ResultSet
            ResultSet rs2 = checkStmt.executeQuery();
            
            if (rs2.next()) {
                // Account exists, retrieve accNo and add the loan amount to the balance
                int existingAccNo = rs2.getInt("accNo");
                System.out.println(existingAccNo);
                
                String updateQuery = "UPDATE bankAccount SET balance = balance + ? WHERE accNo = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setDouble(1, loan);
                    updateStmt.setInt(2, existingAccNo);
                    int rowsUpdated = updateStmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        resultMessage = "Balance added to your account";
                    }
                }
            } else {
                // Account does not exist, create a new account
                String insertQuery = "INSERT INTO bankAccount (customerId, name, balance) VALUES (?, ?, ?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setInt(1, acc);
                    
                    // Assuming UserDAOImpl is defined and gets the user's name by customer ID
                    UserDAOImpl u = new UserDAOImpl();
                    String name = u.getName(acc);
                    insertStmt.setString(2, name);
                    insertStmt.setDouble(3, loan);  // Set the initial balance as the loan amount
                    
                    int rowsInserted = insertStmt.executeUpdate();
                    if (rowsInserted > 0) {
                        resultMessage = "Account created and balance added";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultMessage = "Error occurred while processing the transaction.";
        }

        return resultMessage;
    }
    
}