package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;
	static {
		// 1.加载核心配置文件
		cfg = new Configuration();
		cfg.configure();
		// 2.创建SessionFactory对象
		sessionFactory = cfg.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//提供返回值为本地线程绑定的session方法
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	public static void main(String[] args) {

	}
}
