package com.training.galaxe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.training.galaxe.config.HibernateUtil;
import com.training.galaxe.model.Product;

public class ProductDAOImpl implements ProductDAO {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(product);
		session.update(product);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product p =new Product(productId);
		session.delete(p);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product =new Product();
		product=session.get(Product.class, productId);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
		
		return product;
	}

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Product> products =new ArrayList<Product>();
//		products=session.createQuery("from Product").list();
		Query query=session.createQuery("from Product");
		products=query.list();
//		Product product =new Product();
//		product=session.get(Product.class, productId);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
		
		return products;
	
	}

	@Override
	public List<Product> getProduct(String productName) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		Product product =new Product();
		List<Product> products =new ArrayList<Product>();
//		products=session.get(Product.class, productName);
		return products;
	}

	@Override
	public List<Product> getProduct(int min, int max) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product =new Product();
		List<Product> products1 =new ArrayList<Product>();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.between("price", min, max));
		products1=criteria.list();
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		return products1;
		
		
	}

	@Override
	public String checkProductInventory(int productId, int quantityRequired) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByPrice(int price) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product =new Product();
		List<Product> products1 =new ArrayList<Product>();
		Criteria criteria = session.createCriteria(Product.class);
//		criteria.add(Restrictions.like("price", price);
		products1=criteria.list();
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		return products1;
		
	}

	@Override
	public boolean isProductExists(int productId) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product =new Product();
		product=session.get(Product.class, productId);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		if(product==null)
		{
			return false;
		}
		else {
			return true;
		}
		
		
		
	
		
		
	
	}

	@Override
	public List<Product> searchProduct(String productName, int price) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product =new Product();
		List<Product> products1 =new ArrayList<Product>();
		Criteria criteria =session.createCriteria(Product.class, productName);
		products1=criteria.list();
		List<Product> products2 =new ArrayList<Product>();
		criteria.add(Restrictions.like("productName", productName));
		products2=criteria.list();
		List<Product> products3 =new ArrayList<Product>();
		criteria.add(Restrictions.gt("price", price));
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		return products1;
	}

}
