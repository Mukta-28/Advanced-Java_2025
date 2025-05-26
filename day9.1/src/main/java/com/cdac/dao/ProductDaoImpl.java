package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Product;
import com.cdac.entities.User;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> addNewProduct() {
		
		
		Session session = getFactory().getCurrentSession();
		Session session2 = getFactory().getCurrentSession();
		System.out.println(session == session2);
		
		 */
			Transaction tx = session.beginTransaction();
			System.out.println(session.isOpen() + " " + session.isConnected());// t t
			try {
				List<Product> product = null;
				String jpql = "insert into p values";
				// 1. Get Session from SessionFactory
				Session session = getFactory().getCurrentSession();//getopensesion but we does not use this
				// 2. Begin Tx
				Transaction tx = session.beginTransaction();
				try {
					users = session.createQuery(jpql, User.class).getResultList();// select
					// users - list of persistent entities
					tx.commit();// flush - DML - no , close
				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					// re throw exc to the caller
					throw e;
				}

				return users;// users - list of DETACHED entities
			}
	}
	

}
