package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection connection;
	
	public EmployeeDAOImpl(Connection conn) {
		connection = conn;
	}

	@Override
	public void createEmployee(String name) {
		String sql = "INSERT INTO employees (EmployeeName, IsManager) "
				+ "VALUES (?, FALSE)";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			prepStatement.setString(1, name);
			prepStatement.executeUpdate();
		}
		
		catch (SQLException s) {
			s.printStackTrace();
		}
	}

	@Override
	public void createManager(String name) {
		String sql = "INSERT INTO employees (EmployeeName, IsManager) "
				+ "VALUES (?, TRUE)";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			prepStatement.setString(1, name);
			prepStatement.executeUpdate();
		}
		
		catch (SQLException s) {
			s.printStackTrace();
		}
	}

}
