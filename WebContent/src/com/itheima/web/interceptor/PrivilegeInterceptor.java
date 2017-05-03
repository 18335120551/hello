package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	/**
	 * @author KLH 2017-4-25 <br/>
	 *         登录功能验证:判断用户是否已经登录
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User existUser = (User) session.getAttribute("user");
		if (existUser != null) {
			// 用户已经登录
			return invocation.invoke();
		} else {
			// 用户没有登录
			return "login";
		}
	}

}
