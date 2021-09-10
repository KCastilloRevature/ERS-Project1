package models;

public class Employees {
	private int id;
	private String name;
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
