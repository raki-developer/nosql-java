package raki.shop.repository;

import raki.shop.model.Customer;

public interface CustomerRepository {
    public Customer get(String id);
    public void remove(Customer customer);
    public void save(Customer customer);
    public void update(Customer customer);
}
