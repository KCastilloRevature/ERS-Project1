package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	
	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		Properties props = new Properties();
		FileReader fr;
		try {
			fr = new FileReader("src/main/resources/connection.properties");
			props.load(fr);
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure()
						.setProperty("hibernate.connection.url", props.getProperty("url"))
						.setProperty("hibernate.connection.username", props.getProperty("username"))
						.setProperty("hibernate.connection.password", props.getProperty("password"))
						.buildSessionFactory();
			}
			
			catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		
//		System.out.println("Testing Session: " + sessionFactory);
//		try {
//			System.out.println("Testing Current Session: " + sessionFactory.getCurrentSession());
//		}
//		
//		catch (HibernateException e) {
//			e.printStackTrace();
//		}
		return sessionFactory.getCurrentSession();
	}
}
