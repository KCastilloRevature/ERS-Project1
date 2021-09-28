package daos;

import models.Reimbursement;

public interface ReimbursementDAO {
	public void insertRequest(Reimbursement reimbursement);
	public void updateRequest(int reimbID, String status);
}
