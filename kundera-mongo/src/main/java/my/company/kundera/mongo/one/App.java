package my.company.kundera.mongo.one;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        EntityManager em = emf.createEntityManager();
      
        EntityTransaction tx = em.getTransaction();
        
        tx.commit();
        
        em.close();
        emf.close();
    }
}
