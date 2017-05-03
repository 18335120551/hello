package com.itheima.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private static final long serialVersionUID = 1L;
	// 模型驱动使用的对象
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {

		return customer;
	}

	/**
	 * @author KLH 2017-4-20 <br/>
	 *         查询客户列表信息 <br/>
	 * @return
	 */
	public String findAll() {
		// Spring整合web工厂
		ServletContext servletContext = ServletActionContext.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		// 2.调用业务层的方法查询所有客户
		List<Customer> list = customerService.findAll();
		// 3.获取值栈并将数据保存到值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		return "findAll";
	}

	/**
	 * @author KLH 2017-4-20 <br/>
	 *         跳转到客户的添加页面 <br/>
	 * @return
	 */
	public String saveUI() {

		return "saveUI";
	}

	/**
	 * @author KLH 2017-4-20 <br/>
	 *         保存客户的执行的方法 <br/>
	 * @return
	 */
	@SuppressWarnings("all")
	public String save() {
		// 传统方式
		/*
		 * CustomerService customerService = new CustomerServiceImpl();<br/>
		 * customerService.save(customer);
		 */
		// Spring的方式进行操作
		/*
		 * ApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * CustomerService customerService = (CustomerService)
		 * applicationContext.getBean("customerService");
		 * customerService.save(customer);
		 */

		// Spring整合web工厂
		ServletContext servletContext = ServletActionContext.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		customerService.save(customer);

		return "saveSuccess";
	}
}
