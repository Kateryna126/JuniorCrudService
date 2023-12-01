package ua.hillel.katerynashpak.Service.service;

import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderService {
    ua.hillel.katerynashpak.Service.service.Order getOrder(int id);
    List<ua.hillel.katerynashpak.Service.service.Order> getAllOrders();
    void addOrder(Order order);
    void updateOrder(int id, Order order);

    void addOrder(ua.hillel.katerynashpak.Service.service.Order order);

    void updateOrder(int id, ua.hillel.katerynashpak.Service.service.Order order);

    void deleteOrder(int id);
}
