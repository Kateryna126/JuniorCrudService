package ua.hillel.katerynashpak.service.data;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.hillel.katerynashpak.dto.OrderRecordDto;
import ua.hillel.katerynashpak.mapper.OrderMapper;
import ua.hillel.katerynashpak.repository.OrderRepository;
import ua.hillel.katerynashpak.model.OrderRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderServiceImpl orderService;
    private OrderRecordDto orderRecordDto;

    @BeforeEach
    public void setUp() {
        orderRecordDto = new OrderRecordDto();
    }

    @Test
    void shouldReturnOrderWhenGetOrderIsCalled() {
        lenient().when(orderRepository.findById(1)).thenReturn(Optional.of(new OrderRecord()));
        when(orderMapper.orderToOrderDto(any(OrderRecord.class))).thenReturn(orderRecordDto);

        OrderRecordDto result = orderService.getOrderById(1);

        assertEquals(orderRecordDto, result);
        verify(orderRepository).findById(1);
    }

    @Test
    void shouldReturnAllOrdersWhenGetAllOrdersIsCalled() {
        List<OrderRecord> orderRecords = new ArrayList<>();
        lenient().when(orderRepository.findAll()).thenReturn(orderRecords);
        List<OrderRecordDto> orderRecordDtos = orderRecords.stream()
                .map(orderService::convertToDto)
                .collect(Collectors.toList());

        List<OrderRecordDto> result = orderService.getOrders();

        assertEquals(orderRecordDtos, result);
        verify(orderRepository).findAll();
    }


    @Test
    void shouldSaveOrderWhenCreateOrderIsCalled() {
        when(orderMapper.orderDtoToOrder(any(OrderRecordDto.class))).thenReturn(new OrderRecord());

        orderService.createOrder(orderRecordDto);

        verify(orderRepository).save(any(OrderRecord.class));
    }

    @Test
    void shouldUpdateOrderWhenUpdateOrderIsCalled() {
        lenient().when(orderRepository.existsById(1)).thenReturn(true);
        lenient().when(orderRepository.findById(1)).thenReturn(Optional.of(new OrderRecord()));
        lenient().when(orderMapper.orderDtoToOrder(any(OrderRecordDto.class))).thenReturn(new OrderRecord());

        orderService.updateOrder(1, orderRecordDto);

        verify(orderRepository).save(any(OrderRecord.class));
    }


    @Test
    void shouldDeleteOrderWhenDeleteOrderIsCalled() {
        doNothing().when(orderRepository).deleteById(1);

        orderService.deleteOrder(1);

        verify(orderRepository).deleteById(1);
    }
}



