package ua.hillel.katerynashpak.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public OrderRecord getOrder(int id) {
        String sql = "SELECT * FROM Hillel_service WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(OrderRecord.class));
    }

    @Override
    public List<OrderRecord> getAllOrders() {
        String sql = "SELECT * FROM Hillel_service";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderRecord.class));
    }


    @Override
    public void addOrder(OrderRecord orderRecord) {
        String sql = "INSERT INTO Hillel_service (id, date, cost, products) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderRecord.getId(), orderRecord.getDate(), orderRecord.getCost(), orderRecord.getProducts());
    }

    @Override
    public void updateOrder(int id, OrderRecord orderRecord) {
        String sql = "UPDATE Hillel_service SET date = ?, cost = ?, products = ? WHERE id = ?";
        jdbcTemplate.update(sql, orderRecord.getDate(), orderRecord.getCost(), orderRecord.getProducts(), id);
    }

    @Override
    public void deleteOrder(int id) {
        String sql = "DELETE FROM Hillel_service WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}


