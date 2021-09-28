package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "statistics")
public class Statistics {
	@Id
	@Column(name = "EmployeeID")
	private int employeeID;
	@Column(name = "NumReimburse")
	private int timesSpent;
	@Column(name = "TotalSpent")
	private double totalSpent;
	@Column(name = "AverageSpent")
	private double averageSpent;

	public Statistics() {
		super();
	}
	
	public Statistics(int employeeID, int timesSpent, double totalSpent, double averageSpent) {
		super();
		this.employeeID = employeeID;
		this.timesSpent = timesSpent;
		this.totalSpent = totalSpent;
		this.averageSpent = averageSpent;
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
