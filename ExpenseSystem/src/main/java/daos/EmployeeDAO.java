package daos;

import models.Employees;

public interface EmployeeDAO {
	public void createEmployee(Employees employee);
	public Employees getByUsernameandPassword(String username, String password);
}
