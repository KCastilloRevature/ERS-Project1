package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import utils.ConnectionUtil;

import java.util.List;

import daos.EmployeeDAOImpl;
import daos.ReimbursementsDAOImpl;
import daos.StatisticsDAOImpl;
import models.Reimbursement;
import models.Employees;
import models.Statistics;

public class StatisticsController {
	private static Javalin javalin;
	
	public static void init(Javalin app) {
		javalin = app;
		app.get("/statistics", StatisticsController::getStatistics);
	}
	
	public static void getStatistics(Context ctx) {
		StatisticsDAOImpl dao = new StatisticsDAOImpl(ConnectionUtil.getConnection());
		List<Statistics> result = dao.getStatistics();
		ctx.json(result);
	}
}
