package my.company.simple.crud;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App 
{
    public static void main( String[] args )
    {
        
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.getPhones().add("999-545-139");
        customer.getPhones().add("666-545-433");
        customer.getPhones().add("453-907-877");
        
        Address address = new Address();
        address.setCity("London");
        address.setPostCode("4303-443");
        address.setStreet("St bridge");
        
        customer.setAddress(address);
        
        Order order = new Order();
        order.setDate(new Date());
        
        Item item1 = new Item();
        item1.setCount(3);
        item1.setName("Book");
        item1.setPrice(BigDecimal.valueOf(5.99));
        
        Item item2 = new Item();
        item2.setCount(6);
        item2.setName("Beer");
        item2.setPrice(BigDecimal.valueOf(2.99));
        
        order.getItems().add(item1);
        order.getItems().add(item2);
        
        customer.getOrders().add(order);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        em.persist(customer);
//        tx.commit();
        
        Query query = em.createQuery("select c.orders from Customer c where c.id = :id");
        query.setParameter("id", "ff80808144e3df320144e3df351b0000");
        List<Order> orders = query.getResultList();
        
        for(Order o : orders) {
            System.out.println(o.getDate());
        }
        
        em.close();
        emf.close();
    }
}
