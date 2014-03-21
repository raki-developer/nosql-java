package raki.shop.repository;

import java.util.List;
import raki.shop.model.Customer;
import raki.shop.model.Order;

public interface CustomerRepository {
    public Customer get(String id);
    public void remove(Customer customer);
    public void save(Customer customer);
    public void update(Customer customer);
    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByPhone(String phone);
    public List<Order> getOrders(String id);
}
