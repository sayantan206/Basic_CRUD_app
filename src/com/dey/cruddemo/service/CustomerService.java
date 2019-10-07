package com.dey.cruddemo.service;

import com.dey.cruddemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public void delete(int id);
}
