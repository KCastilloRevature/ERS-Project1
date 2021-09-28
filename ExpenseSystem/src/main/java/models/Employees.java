package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "employees")
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(allocationSize = 1, name = "employeeIDsequence", sequenceName = "auto-increment")
	@Column(name = "EmployeeID")
	private int id;
	@Column(name = "UserName")
	private String UserName;
	@Column(name = "Password")
	private String Password;
	@Column(name = "EmployeeName")
	private String name;
	@Column(name = "IsManager")
	private boolean isManager;
	
	public Employees() {
		super();
	}

	public Employees(int id, String name, boolean isManager) {
		super();
		this.id = id;
		this.name = name;
		this.isManager = isManager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
}
