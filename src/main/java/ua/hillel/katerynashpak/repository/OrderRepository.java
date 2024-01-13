package ua.hillel.katerynashpak.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.hillel.katerynashpak.model.OrderRecord;
@Repository
public interface OrderRepository extends CrudRepository<OrderRecord, Integer> {
}