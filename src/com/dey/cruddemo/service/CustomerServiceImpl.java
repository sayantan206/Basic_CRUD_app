package com.dey.cruddemo.service;

import com.dey.cruddemo.dao.CustomerDAO;
import com.dey.cruddemo.entity.Customer;
import com.dey.cruddemo.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public LinkedHashSet<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        Customer savedCustomer = customerDAO.getCustomerById(customer.getId());
        if (savedCustomer == null)
            customerDAO.saveCustomer(customer);
        else {
            customerDAO.updateCustomer(customer);
        }
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        customerDAO.delete(id);
    }

    @Override
    @Transactional
    public Project getProjectByName(String name, int id) {
        return customerDAO.getProjectByName(name, id);
    }
}
