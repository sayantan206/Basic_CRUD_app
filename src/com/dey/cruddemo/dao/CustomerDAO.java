package com.dey.cruddemo.dao;

import com.dey.cruddemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    void delete(int id);
}
