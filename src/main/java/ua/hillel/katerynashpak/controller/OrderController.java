package ua.hillel.katerynashpak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ua.hillel.katerynashpak.controller.response.ApiResponse;
import ua.hillel.katerynashpak.dto.OrderRecordDto;
import ua.hillel.katerynashpak.service.jpa.OrderService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v6/orders")
@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ApiResponse<List<OrderRecordDto>> getOrders() {
        ApiResponse<List<OrderRecordDto>> response = new ApiResponse<>();
        List<OrderRecordDto> orders = orderService.getOrders();
        if (!CollectionUtils.isEmpty(orders)) {
            response.setSuccess(true);
            response.setData(orders);
        }
        return response;
    }

    @Transactional
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderRecordDto> getOrderById(@PathVariable("orderId") Integer orderId) {
        OrderRecordDto order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public void createOrder(@RequestBody OrderRecordDto order) {
        orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody OrderRecordDto order) {
        orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}