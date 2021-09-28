package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Employees;
import utils.HibernateSessionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection connection;
	
	public EmployeeDAOImpl(Connection conn) {
		connection = conn;
	}
	
	@Override
	public void createEmployee(Employees employee) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			createEmployee(employee);
		}
		
		catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		finally {
			session.close();
		}
	}

	@Override
	public Employees getByUsernameandPassword(String username, String password) {
		Employees result = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employees> cq = cb.createQuery(Employees.class);
			Root<Employees> root = cq.from(Employees.class);
			Predicate getUser = cb.equal(root.get("UserName"), username);
			Predicate getPassword = cb.equal(root.get("Password"), password);
			Predicate getResult = cb.and(getUser, getPassword);
			cq.select(root).where(getResult);
			Query<Employees> query = s.createQuery(cq);
			result = query.uniqueResult();
		}
		
		catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		finally {
			s.close();
		}
		
		return result;
	}
}
