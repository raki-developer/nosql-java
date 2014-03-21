package raki.shop.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import raki.shop.model.Customer;
import raki.shop.model.Order;

public class CustomerRepositoryImpl implements CustomerRepository {
    protected EntityManager entityManager;
    
    public CustomerRepositoryImpl(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
    }
    
    public Customer get(String id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    public void remove(Customer customer) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(customer);
        tx.commit();
    }

    public void save(Customer customer) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(customer);
        tx.commit();
    }

    public void update(Customer customer) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(customer);
        tx.commit();
    }
    
    public List<Customer> findByFirstName(String firstName) {
        Query query = entityManager.createQuery("select c from Customer c where c.firstName = :firstName");
        query.setParameter("firstName", firstName);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    public List<Customer> findByPhone(String phone) {
//        Query query = entityManager.createQuery("select c from Customer c JOIN c.phones p where p = :phone");
        Query query = entityManager.createQuery("select c from Customer c where c.phones = :phone");
        query.setParameter("phone", phone);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    public List<Order> getOrders(String id) {
        Query query = entityManager.createQuery("select c.orders from Customer c where c.id = :id");
        query.setParameter("id", id);
        List<Order> orders = query.getResultList();
        return orders;
    }
    
}
