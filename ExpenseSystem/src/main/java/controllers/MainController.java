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
		ReimbursementsDAOImpl dao = new ReimbursementsDAOImpl(ConnectionUtil.getConnection());
		String name = ctx.pathParam("employeeName");
		int id = Integer.parseInt(ctx.pathParam("reimbID"));
		
		String[] jsonObject = jsonParser(ctx.body());
		double amount = Double.parseDouble(jsonObject[1]);
		
		dao.insertRequest(id, name, amount);
	}
	
	public static void updateRequest(Context ctx) {
		ReimbursementsDAOImpl dao = new ReimbursementsDAOImpl(ConnectionUtil.getConnection());
		int id = Integer.parseInt(ctx.pathParam("reimbID"));
		String response = ctx.pathParam("decision");
		
		dao.updateRequest(id, response);
	}
	
	public static String[] jsonParser(String json) {
		String[] finishedJSON = new String[2];
		String[] parser = json.split("\"");
		finishedJSON[0] = parser[1];
		parser = parser[2].split(":");
		parser = parser[1].split("}");
		finishedJSON[1] = parser[0];
		return finishedJSON;
	}

}
