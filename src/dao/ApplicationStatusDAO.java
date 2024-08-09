package dao;


public interface ApplicationStatusDAO {
	void createApplicationStatus(ApplicationStatus applicationStatus);
	String getApplicationStatus(int id,String date);
}

