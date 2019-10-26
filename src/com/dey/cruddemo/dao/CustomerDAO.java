package com.dey.cruddemo.dao;

import com.dey.cruddemo.entity.Customer;
import com.dey.cruddemo.entity.Project;

import java.util.LinkedHashSet;

public interface CustomerDAO {
    public LinkedHashSet<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public Customer getCustomerById(int id);

    void delete(int id);

    Project getProjectByName(String name, int id);
}
