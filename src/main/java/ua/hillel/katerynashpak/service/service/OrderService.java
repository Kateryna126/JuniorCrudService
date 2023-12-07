package ua.hillel.katerynashpak.service.service;



import java.util.List;

public interface OrderService {
    OrderRecord getOrder(int id);
    List<OrderRecord> getAllOrders();
    void addOrder(OrderRecord order);
    void updateOrder(int id, OrderRecord order);
    void deleteOrder(int id);
}
