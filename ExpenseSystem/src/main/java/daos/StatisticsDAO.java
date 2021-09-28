package daos;

import java.util.List;

import models.Statistics;

public interface StatisticsDAO {
	public void updateStatistics(int amount, int employeeID);
	public List<Statistics> getStatistics();
}
