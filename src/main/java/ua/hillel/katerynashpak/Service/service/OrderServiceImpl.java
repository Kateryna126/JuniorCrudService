package ua.hillel.katerynashpak.Service.service;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public abstract class OrderServiceImpl implements OrderService {
    private Map<Integer, Order> orders = new HashMap<>();

    @Override
    public Order getOrder(int id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void updateOrder(int id, Order order) {
        orders.put(id, order);
    }

    @Override
    public void deleteOrder(int id) {
        orders.remove(id);
    }
}
