package raki.shop.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import raki.shop.model.Item;

public class ItemRepositoryImpl implements ItemRepository {

    protected EntityManager entityManager;
    
    public ItemRepositoryImpl(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
    }
    
    public Item get(String id) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Item customer = entityManager.find(Item.class, id);
        tx.commit();
        return customer;
    }

    public void remove(Item item) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(item);
        tx.commit();
    }

    public void save(Item item) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(item);
        tx.commit();
    }

    public void update(Item item) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(item);
        tx.commit();
    }
    
    
}
