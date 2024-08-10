package dao;

public interface UserDAO {
	void createUser(User user);
	String login(int customerId,String password);
}
