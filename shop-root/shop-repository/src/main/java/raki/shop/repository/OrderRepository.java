package raki.shop.repository;

import raki.shop.model.Order;

public interface OrderRepository {
    public Order get(String id);
    public void remove(Order customer);
    public void save(Order customer);
    public void update(Order customer);
}
