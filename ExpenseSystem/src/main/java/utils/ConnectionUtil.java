package utils;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection connection;
	
	private ConnectionUtil() {
		
	}
	
	//jdbc:mariadb://database-1.cxfkqgcnbbyk.us-west-1.rds.amazonaws.com:3306/ReimburseDB?user=admin&password=Ldrago72
	
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties props = new Properties();
				FileReader connectionProperties = new FileReader("src/main/resources/connection.properties");
				props.load(connectionProperties);
				
				String connectionString = "jdbc:mariadb://" 
				+ props.getProperty("endpoint") + ":" 
				+ props.getProperty("port") + "/"
				+ props.getProperty("DBName") + "?user="
				+ props.getProperty("username") + "&password="
				+ props.getProperty("password");
						
				connection = DriverManager.getConnection(connectionString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
}
