package com.itheima.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.userDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.HibernateUtils;

public class UserServiceImpl implements UserService {

	/**
	 * @author KLH 2017-4-23 <br/>
	 *         用户模块:登录功能
	 * @return
	 */
	@Override
	public User login(User user) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			UserDao userDao = new userDaoImpl();
			user = userDao.login(user);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return user;
	}

}
