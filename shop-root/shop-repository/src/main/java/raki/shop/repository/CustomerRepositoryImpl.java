package raki.shop.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import raki.shop.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {
    
    protected EntityManager entityManager;
    
    public CustomerRepositoryImpl(EntityManager em) {
        entityManager = em;
    }
    
    public Customer get(String id) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.find(Customer.class, id);
        tx.commit();
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
    
}
