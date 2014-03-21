package raki.kundera.neo4j;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("neo4j");
        EntityManager em = emf.createEntityManager();

        Customer c1 = new Customer();
        c1.setId(UUID.randomUUID().toString());
        c1.getPhones().add("111-222-333");
        c1.setFirstName("Test");
        
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
        
//        Query q = em.createQuery("select c from Customer c");
//        List<Customer> customers = q.getResultList();
//        
//        for(Customer c : customers) {
//            System.out.println(c);
//        }

        em.close();
        emf.close();
    }
}
