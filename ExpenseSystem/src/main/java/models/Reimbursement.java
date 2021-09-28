package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "reimbursements")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReimburseID")
	private int reimburseID;
	@Column(name = "EmployeeID")
	private int employeeID;
//	@ManyToOne
//	private int employeeID_FK;
	@Column(name = "EmployeeName")
	private String employeeName;
	@Column(name = "Amount")
	private double amount;
	@Column(name = "Reason")
	private String reason;
	@Column(name = "Status")
	private String status;	
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimburseID, int employeeID, String employeeName, double amount, String reason, String status) {
		super();
		this.reimburseID = reimburseID;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.amount = amount;
		this.reason = reason;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
