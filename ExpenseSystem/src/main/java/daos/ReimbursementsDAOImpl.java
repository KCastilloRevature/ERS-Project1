package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Reimbursement;
import utils.HibernateSessionFactory;
public class ReimbursementsDAOImpl implements ReimbursementDAO {
	
	Connection connection;
	
	public ReimbursementsDAOImpl(Connection conn) {
		connection = conn;
	}
	

	public void insertRequest(Reimbursement reimbursement) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(reimbursement);
			tx.commit();
		}
		
		catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		finally {
			session.close();
		}
	}

	public void updateRequest(int reimbID, String status) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql = "update Reimbursement r "
					+ "set r.status=?1 "
					+ "where r.reimburseID=?2";
			Query q = session.createQuery(hql);
			q.setParameter(1, status);
			q.setParameter(2, reimbID);
			q.executeUpdate();
			tx.commit();
		}
		
		catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		finally {
			session.close();
		}
	}
	
	public List<Reimbursement> getAllRequests() {
		List<Reimbursement> result = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			result = s.createQuery("FROM Reimbursement", Reimbursement.class).getResultList();
			tx.commit();
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
