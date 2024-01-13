package ua.hillel.katerynashpak.service.data;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hillel.katerynashpak.converter.OrderConverter;
import ua.hillel.katerynashpak.dto.OrderRecordDto;
import ua.hillel.katerynashpak.mapper.OrderMapper;
import ua.hillel.katerynashpak.repository.OrderRepository;
import ua.hillel.katerynashpak.model.OrderRecord;
import ua.hillel.katerynashpak.service.jpa.OrderService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderConverter orderConverter, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
        this.orderMapper = orderMapper;
    }

    public OrderRecordDto convertToDto(OrderRecord orderRecord) {
        OrderRecordDto dto = new OrderRecordDto();
        dto.setId(orderRecord.getId());
        dto.setDate(orderRecord.getDate());
        dto.setCost(orderRecord.getCost());
        return dto;
    }

    @Transactional
    @Override
    public OrderRecordDto getOrderById(int id) {
        Optional<OrderRecord> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            OrderRecord order = orderOptional.get();
            order.getProducts().size();
            return orderMapper.orderToOrderDto(order);
        }
        return null;
    }


    @Override
    public List<OrderRecordDto> getOrders() {
        Iterable<OrderRecord> orderIterable = orderRepository.findAll();
        List<OrderRecord> orders = StreamSupport.stream(orderIterable.spliterator(), false)
                .toList();

        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createOrder(OrderRecordDto dto) {
        OrderRecord orderRecord = orderMapper.orderDtoToOrder(dto);
        orderRepository.save(orderRecord);
    }

    @Override
    public void updateOrder(int id, OrderRecordDto dto) {
        Optional<OrderRecord> existingOrderOpt = orderRepository.findById(id);
        if (existingOrderOpt.isPresent()) {
            OrderRecord existingOrder = existingOrderOpt.get();
            OrderRecord updatedOrder = orderMapper.orderDtoToOrder(dto);
            updatedOrder.setId(existingOrder.getId()); // Preserve the ID of the existing order
            orderRepository.save(updatedOrder);
        }
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}