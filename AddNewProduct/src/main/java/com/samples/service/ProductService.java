package com.samples.service;

import java.util.List;

import com.samples.domain.ProductInfo;
import com.samples.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductService {
	public void addProductInfo(ProductInfo product) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			session.save(product);

			txn.commit();

		} catch (Exception ex) {
			if (txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	public List<ProductInfo> getProductInfo() {
		List<ProductInfo> product = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			product = session.createQuery("from ProductInfo").list();

			txn.commit();

		} catch (Exception ex) {
			if (txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return product;
	}

}
