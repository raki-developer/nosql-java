package raki.shop.console;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import raki.shop.model.Address;
import raki.shop.model.Customer;
import raki.shop.model.Item;
import raki.shop.model.Order;
import raki.shop.repository.CustomerRepository;
import raki.shop.repository.CustomerRepositoryImpl;


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
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mongo");
        EntityManager em = emf.createEntityManager();

        CustomerRepository customerRepository = new CustomerRepositoryImpl(em);
        customerRepository.save(customer);
       
        em.close();
        emf.close();
    }
}
