package ua.hillel.katerynashpak.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hillel.katerynashpak.service.model.OrderRecord;
import ua.hillel.katerynashpak.service.repository.OrderRepository;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderRecord getOrder(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderRecord> getAllOrders() {
        return (List<OrderRecord>) orderRepository.findAll();
    }

    @Override
    public void createOrder(OrderRecord orderRecord) {
        orderRepository.save(orderRecord);
    }

    @Override
    public void updateOrder(int id, OrderRecord orderRecord) {
        if (orderRepository.existsById(id)) {
            orderRecord.setId(id);
            orderRepository.save(orderRecord);
        }
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}


