package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ReimbursementsDAOImpl implements ReimbursementDAO {
	
	Connection connection;
	
	public ReimbursementsDAOImpl(Connection conn) {
		connection = conn;
	}

	public void insertRequest(int id, String name, double amount) {
		String sql = "INSERT INTO reimbursements "
				+ "(EmployeeID, EmployeeName, Amount, Status)"
				+ "VALUES (?, ?, ?, PENDING)";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			prepStatement.setInt(1, id);
			prepStatement.setString(2, name);
			prepStatement.setDouble(3, amount);
			prepStatement.executeUpdate();
		}
		
		catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void updateRequest(int id, String response) {
		String sql = "UPDATE reimbursements "
				+ "SET Status = ?"
				+ "WHERE ReimburseID = ?";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			prepStatement.setString(1, response);
			prepStatement.setInt(2, id);
			prepStatement.executeUpdate();
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
	}

}
