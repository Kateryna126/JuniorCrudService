package ua.hillel.katerynashpak.service.service.order.jpa;



import ua.hillel.katerynashpak.service.model.OrderRecord;

import java.util.List;

public interface OrderService {
    OrderRecord getOrder(int id);
    List<OrderRecord> getAllOrders();
    void createOrder(OrderRecord order);
    void updateOrder(int id, OrderRecord order);
    void deleteOrder(int id);
}
