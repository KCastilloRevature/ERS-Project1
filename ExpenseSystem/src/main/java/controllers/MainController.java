package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import utils.ConnectionUtil;
import daos.ReimbursementsDAOImpl;
import daos.StatisticsDAOImpl;

public class MainController {
	private static Javalin javalin;
	
	public static void init(Javalin app) {
		javalin = app;
		
		app.put("/employee/:employeeName/reimb/:reimbID", MainController::insertRequest);
		app.put("/reimb/:reimbID/decision/:decision", MainController::updateRequest);
	}
	
	public static void insertRequest(Context ctx) {
		
	}
	
	public static void updateRequest(Context ctx) {
		
	}
}
