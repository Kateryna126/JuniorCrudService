package ua.hillel.katerynashpak.service.repository;

import org.springframework.data.repository.CrudRepository;
import ua.hillel.katerynashpak.service.model.OrderRecord;

public interface OrderRepository extends CrudRepository<OrderRecord, Integer> {
}