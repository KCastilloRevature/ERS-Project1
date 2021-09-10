package main;

import io.javalin.Javalin;
import utils.ConnectionUtil;
import controllers.MainController;
import java.sql.Connection;
import java.util.Random;
import daos.ReimbursementsDAOImpl;
import daos.StatisticsDAOImpl;
import controllers.MainController;

public class Driver {
    public static void main(String[] args) {
    	Javalin app = Javalin.create().start(42069);
        MainController.init(app);
    }
}
