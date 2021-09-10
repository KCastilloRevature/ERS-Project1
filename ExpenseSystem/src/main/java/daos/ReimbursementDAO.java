package daos;

public interface ReimbursementDAO {
	public void insertRequest(int id, String name, double amount);
	public void updateRequest(int id, String response);
}
