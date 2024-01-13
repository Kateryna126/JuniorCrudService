package ua.hillel.katerynashpak.service.jpa;

import ua.hillel.katerynashpak.dto.OrderRecordDto;

import java.util.List;
public interface OrderService {
        OrderRecordDto getOrderById(int id);
        List<OrderRecordDto> getOrders();
        void createOrder(OrderRecordDto dto);
        void updateOrder(int id, OrderRecordDto dto);
        void deleteOrder(int id);
    }
