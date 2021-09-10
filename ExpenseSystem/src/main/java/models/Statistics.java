package models;

public class Statistics {
	private int reimburseID;
	private int employeeID;
	private int timesSpent;
	private double totalSpent;
	private double averageSpent;

	public Statistics() {
		super();
	}
	
	public Statistics(int reimburseID, int employeeID, int timesSpent, double totalSpent, double averageSpent) {
		super();
		this.reimburseID = reimburseID;
		this.employeeID = employeeID;
		this.timesSpent = timesSpent;
		this.totalSpent = totalSpent;
		this.averageSpent = averageSpent;
	}

	public int getReimburseID() {
		return reimburseID;
	}

	public void setReimburseID(int reimburseID) {
		this.reimburseID = reimburseID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getTimesSpent() {
		return timesSpent;
	}

	public void setTimesSpent(int timesSpent) {
		this.timesSpent = timesSpent;
	}

	public double getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(double totalSpent) {
		this.totalSpent = totalSpent;
	}

	public double getAverageSpent() {
		return averageSpent;
	}

	public void setAverageSpent(double averageSpent) {
		this.averageSpent = averageSpent;
	}
	
}
