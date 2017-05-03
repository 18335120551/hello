package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerService {

	List<Customer> findAll();

	void save(Customer customer);

}
