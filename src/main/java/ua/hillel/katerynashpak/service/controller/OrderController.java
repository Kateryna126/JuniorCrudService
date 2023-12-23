package ua.hillel.katerynashpak.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.hillel.katerynashpak.service.model.OrderRecord;
import ua.hillel.katerynashpak.service.service.order.jpa.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public OrderRecord getOrder(@PathVariable int id) {
        return orderService.getOrder(id);
    }

    @GetMapping
    public List<OrderRecord> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public void createOrder(@RequestBody OrderRecord order) {
        orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody OrderRecord order) {
        orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}