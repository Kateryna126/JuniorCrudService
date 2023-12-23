package ua.hillel.katerynashpak.service.service.order.data;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.hillel.katerynashpak.service.model.OrderRecord;
import ua.hillel.katerynashpak.service.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;
    private OrderRecord orderRecord;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderRecord = new OrderRecord();
    }

    @Test
    public void shouldReturnOrderWhenGetOrderIsCalled() {
        when(orderRepository.findById(1)).thenReturn(Optional.of(orderRecord));

        OrderRecord result = orderService.getOrder(1);

        assertEquals(orderRecord, result);
        verify(orderRepository).findById(1);
    }

    @Test
    public void shouldReturnAllOrdersWhenGetAllOrdersIsCalled() {
        List<OrderRecord> orderRecords = new ArrayList<>();
        when(orderRepository.findAll()).thenReturn(orderRecords);

        List<OrderRecord> result = orderService.getAllOrders();

        assertEquals(orderRecords, result);
        verify(orderRepository).findAll();
    }

    @Test
    public void shouldSaveOrderWhenCreateOrderIsCalled() {
        when(orderRepository.save(orderRecord)).thenReturn(orderRecord);

        orderService.createOrder(orderRecord);

        verify(orderRepository).save(orderRecord);
    }

    @Test
    public void shouldUpdateOrderWhenUpdateOrderIsCalled() {
        when(orderRepository.existsById(1)).thenReturn(true);

        orderService.updateOrder(1, orderRecord);

        verify(orderRepository).save(orderRecord);
    }

    @Test
    public void shouldDeleteOrderWhenDeleteOrderIsCalled() {
        doNothing().when(orderRepository).deleteById(1);

        orderService.deleteOrder(1);

        verify(orderRepository).deleteById(1);
    }

}


