package com.itheima.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * @author KLH 2017-4-20 <br/>
	 *         查询客户列表信息 <br/>
	 * @return
	 */
	@Override
	public List<Customer> findAll() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> list = null;
		try {

			list = customerDao.findAll();

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @author KLH 2017-4-20 <br/>
	 *         保存客户的执行的方法 <br/>
	 * @return
	 */
	@Override
	public void save(Customer customer) {

		customerDao.save(customer);

	}
}
