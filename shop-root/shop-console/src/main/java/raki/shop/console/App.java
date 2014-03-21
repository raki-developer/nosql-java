package raki.shop.console;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import raki.shop.model.Address;
import raki.shop.model.Customer;
import raki.shop.model.Item;
import raki.shop.model.Order;
import raki.shop.repository.CustomerRepository;
import raki.shop.repository.CustomerRepositoryImpl;

public class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerRepository customerRepository = appContext.getBean(CustomerRepository.class);


        Customer c1 = new Customer();
        c1.setId(UUID.randomUUID().toString());
        c1.setFirstName("Brad");
        c1.setLastName("Pit");
        
        Address address = new Address();
        address.setCity("London");
        address.setPostCode("44-333");
        address.setStreet("Test");
        
        c1.getPhones().add("333-333-111");
        
        customerRepository.save(c1);
        
        System.out.println(c1.getId());
    }
}
