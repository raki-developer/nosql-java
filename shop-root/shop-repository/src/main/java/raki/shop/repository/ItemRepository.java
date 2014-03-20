package raki.shop.repository;

import raki.shop.model.Item;

public interface ItemRepository {
    public Item get(String id);
    public void remove(Item customer);
    public void save(Item customer);
    public void update(Item customer);
}
