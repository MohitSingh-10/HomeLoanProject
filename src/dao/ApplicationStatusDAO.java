package dao;


public interface ApplicationStatusDAO {
	void createApplicationStatus(int applicationStatus);
	String getApplicationStatus(int id,String date);
}

