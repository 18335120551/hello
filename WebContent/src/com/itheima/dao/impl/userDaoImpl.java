package com.itheima.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;

public class userDaoImpl implements UserDao {

	/**
	 * @author KLH 2017-4-23 <br/>
	 *         用户模块:登录功能
	 * @return
	 */
	@Override
	@SuppressWarnings("all")
	public User login(User user) {
		Session session = HibernateUtils.getCurrentSession();

		Query query = session.createQuery("from User where user_name = ? and user_password = ?");
		query.setParameter(0, user.getUser_name());
		query.setParameter(1, user.getUser_password());
		User existUser = (User) query.uniqueResult();

		return existUser;
	}

}
