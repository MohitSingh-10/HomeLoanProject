package dao;

import java.util.List;

public interface LoanApplicationDAO {
	
	void createApplication(LoanApplication app);
    LoanApplication readApplication(int applicationId);
    List<LoanApplication> readApplications(int userId);
    void updateApplication(LoanApplication app);
    void deleteApplication(int applicationId);

}