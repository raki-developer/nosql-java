package raki.shop.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import raki.shop.repository.CustomerRepository;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerRepository customerRepository = appContext.getBean(CustomerRepository.class);
    }
}
