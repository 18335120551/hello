package com.itheima.web.action;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	/**
	 * @author KLH 2017-4-23 <br/>
	 *         用户模块:登录功能
	 * @return
	 */
	public String login() {
		UserService userService = new UserServiceImpl();
		User existUser = userService.login(user);
		if (existUser != null) {
			//登录成功,将用户信息存入session中
			ServletActionContext.getRequest().getSession().setAttribute("user", existUser);
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "用户名或密码错误!!");
			return LOGIN;
		}

	}

}
