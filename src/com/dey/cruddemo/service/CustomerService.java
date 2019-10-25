package com.dey.cruddemo.service;

import com.dey.cruddemo.entity.Customer;
import com.dey.cruddemo.entity.Project;

import java.util.LinkedHashSet;

public interface CustomerService {

    public LinkedHashSet<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public void delete(int id);

    Project getProjectByName(String name, int id);
}
