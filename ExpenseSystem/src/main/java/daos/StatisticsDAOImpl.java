package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Reimbursement;
import models.Statistics;
import utils.HibernateSessionFactory;

public class StatisticsDAOImpl implements StatisticsDAO {
	
	Connection connection;
	
	public StatisticsDAOImpl(Connection conn) {
		connection = conn;
	}

	@Override
	public void updateStatistics(int amount, int employeeID) {
		String sql = "UPDATE statistics "
				+ "SET TotalSpent = TotalSpent + ? "
				+ "WHERE EmployeeID = ?";
		
		String sql2 = "UPDATE statistics "
				+ "SET AverageSpent = SUM(TotalSpent) / SUM(NumReimburse) "
				+ "WHERE EmployeeID = ?";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			prepStatement.setInt(1, amount);
			prepStatement.setInt(2, employeeID);
			prepStatement.execute();
			
			PreparedStatement prepStatement2 = connection.prepareStatement(sql2);
			prepStatement2.setInt(1, employeeID);
			prepStatement.execute();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Statistics> getStatistics() {
		List<Statistics> result = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			result = s.createQuery("FROM Statistics", Statistics.class).getResultList();
			tx.commit();
		}
		
		catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		finally {
			s.close();
		}
		
		return result;
	}

}
