package main;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import utils.ConnectionUtil;
import controllers.LoginController;
import controllers.ReimbursementController;
import controllers.StatisticsController;

import java.sql.Connection;
import java.util.Random;
import daos.ReimbursementsDAOImpl;
import daos.StatisticsDAOImpl;
import controllers.ReimbursementController;

public class Driver {
    public static void main(String[] args) {
    	Javalin app = Javalin.create().start(42069);
        ReimbursementController.init(app);
        LoginController.init(app);
        StatisticsController.init(app);
        
        app.config.addStaticFiles("/static", Location.CLASSPATH);
        
		app.after(ctx -> {
			ctx.res.addHeader("Access-Control-Allow-Origin", "null");
		});
    }
}
