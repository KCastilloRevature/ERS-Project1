package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import utils.ConnectionUtil;
import daos.EmployeeDAOImpl;
import daos.ReimbursementsDAOImpl;
import daos.StatisticsDAOImpl;
import models.Reimbursement;
import models.Employees;
import models.Statistics;

public class LoginController {
	private static Javalin javalin;
	
	public static void init(Javalin app) {
		javalin = app;
		app.post("/login", LoginController::login);
	}
	
	public static void login(Context ctx) {
		//System.out.println("reached login");
		String username = ctx.formParam("userName");
		String password = ctx.formParam("password");
		
		EmployeeDAOImpl dao = new EmployeeDAOImpl(ConnectionUtil.getConnection());
		Employees employee = dao.getByUsernameandPassword(username, password);
		if (employee == null) {
			ctx.status(403);
			ctx.redirect("/loginFail.html");
		}
		
		else {
			if (employee.isManager()) {
//				System.out.println("reached Manager Page");
				ctx.redirect("/managerPage.html");
			}
			
			else {
				ctx.redirect("/employeePage.html");
			}
		}
	}
}
