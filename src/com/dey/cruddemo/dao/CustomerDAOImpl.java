package com.dey.cruddemo.dao;

import com.dey.cruddemo.entity.Customer;
import com.dey.cruddemo.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public LinkedHashSet<Customer> getCustomers() {
        System.out.println("------------------------List---------------------------");
        Session session = sessionFactory.getCurrentSession();
        return new LinkedHashSet<>(session.createQuery("select c from Customer c left join fetch c.projects" +
                " order by c.lastName", Customer.class).list());
    }

    @Override
    public void saveCustomer(Customer customer) {
        System.out.println("------------------------Save---------------------------");
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        System.out.println("------------------------Update---------------------------");
        Session session = sessionFactory.getCurrentSession();
        session.merge(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        System.out.println("------------------------Get cust by id---------------------------");
        Session session = sessionFactory.getCurrentSession();
//        return session.get(Customer.class, id);
        LinkedHashSet<Customer> set = new LinkedHashSet<>(session.createQuery("select c from Customer c left join fetch c.projects" +
                " where c.id=:id", Customer.class)
                .setParameter("id", id)
                .list());

        Iterator<Customer> iterator = set.iterator();
        if(iterator.hasNext())
            return iterator.next();
        return null;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id= :custId");
        query.setParameter("custId", id);

        query.executeUpdate();
    }

    @Override
    public Project getProjectByName(String name, int id) {
        System.out.println("------------------------Get Project by name---------------------------");
        Session session = sessionFactory.getCurrentSession();
        Query<Project> query = session.createQuery("select p from Project p where " +
                "p.name=:name", Project.class);

        query.setParameter("name", name);

        List<Project> resultList = query.getResultList();
        if (resultList.isEmpty())
            return new Project(name);
        return resultList.get(0);
    }
}
