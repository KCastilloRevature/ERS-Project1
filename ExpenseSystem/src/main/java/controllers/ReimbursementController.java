package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import utils.ConnectionUtil;

import java.util.List;

import org.json.JSONObject;

import daos.ReimbursementsDAOImpl;
import daos.StatisticsDAOImpl;
import models.Reimbursement;
import models.Employees;
import models.Statistics;

public class ReimbursementController {
	private static Javalin javalin;
	
	public static void init(Javalin app) {
		javalin = app;
		
		app.post("/request", ReimbursementController::insertRequest);
		app.get("/request/employee", ReimbursementController::getRequest);
		app.get("/request/manager", ReimbursementController::getRequest);
		app.post("/request/approve", ReimbursementController::updateRequestApprove);
		app.post("/request/deny", ReimbursementController::updateRequestDeny);
	}
	
	public static void insertRequest(Context ctx) {
		ReimbursementsDAOImpl dao = new ReimbursementsDAOImpl(ConnectionUtil.getConnection());
		Integer employeeID = Integer.parseInt(ctx.formParam("EmployeeID"));
		String name = ctx.formParam("Name");
		Integer amount = Integer.parseInt(ctx.formParam("amount"));
		String reason = ctx.formParam("reason");
		Reimbursement newRequest = new Reimbursement(1, employeeID, name, amount, reason, "PENDING");
		dao.insertRequest(newRequest);
		ctx.redirect("employeePage.html");
//		ctx.redirect("C:\\Users\\sonic\\Desktop\\Revature Training\\Java Enviornment\\ExpenseSystem\\frontend\\employeePortals\\employeePage.html");
	}
	
	public static void updateRequestApprove(Context ctx) {
		ReimbursementsDAOImpl dao = new ReimbursementsDAOImpl(ConnectionUtil.getConnection());
//		System.out.println(ctx.body());
		JSONObject json = new JSONObject(ctx.body());
		int reimbID = json.getInt("id");
		String status = json.getString("status");
		dao.updateRequest(reimbID, status);
		
		StatisticsDAOImpl statDAO = new StatisticsDAOImpl(ConnectionUtil.getConnection());
		int amount = json.getInt("amount");
		int emlpoyeeID = json.getInt("employeeID");
		statDAO.updateStatistics(amount, emlpoyeeID);
	}
	
	public static void updateRequestDeny(Context ctx) {
		ReimbursementsDAOImpl dao = new ReimbursementsDAOImpl(ConnectionUtil.getConnection());
//		System.out.println(ctx.body());
		JSONObject json = new JSONObject(ctx.body());
		int reimbID = json.getInt("id");
		String status = json.getString("status");
		dao.updateRequest(reimbID, status);
	}
	
	public static void getRequest(Context ctx) {
		ReimbursementsDAOImpl dao = new ReimbursementsDAOImpl(ConnectionUtil.getConnection());
		List<Reimbursement> result = dao.getAllRequests();
		ctx.json(result);
	}

}
