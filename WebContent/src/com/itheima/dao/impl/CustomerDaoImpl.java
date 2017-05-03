package com.itheima.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	/**
	 * @author KLH 2017-4-20 <br/>
	 *         查询客户列表信息 <br/>
	 * @return
	 */
	@Override
	@SuppressWarnings("all")
	public List<Customer> findAll() {
		Session session = HibernateUtils.getCurrentSession();

		return session.createQuery("from Customer").list();
	}

	/**
	 * @author KLH 2017-4-20 <br/>
	 *         保存客户的执行的方法 <br/>
	 * @return
	 */
	@Override
	public void save(Customer customer) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(customer);

		transaction.commit();
		session.close();
	}

}
