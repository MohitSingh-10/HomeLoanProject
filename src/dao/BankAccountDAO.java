package dao;

public interface BankAccountDAO {
	
	BankAccount showAccount(int accNo);
    String addBalance(double loan, int acc);

}