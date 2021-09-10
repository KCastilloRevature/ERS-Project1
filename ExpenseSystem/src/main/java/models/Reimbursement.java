package models;

public class Reimbursement {
	private int reimburseID;
	private int employeeID;
	private String employeeName;
	private double amount;
	private String status;	
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimburseID, int employeeID, String employeeName, double amount, String status) {
		super();
		this.reimburseID = reimburseID;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.amount = amount;
		this.status = status;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
