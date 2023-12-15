package ua.hillel.katerynashpak.service.repository;


import org.springframework.data.repository.CrudRepository;
import ua.hillel.katerynashpak.service.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}