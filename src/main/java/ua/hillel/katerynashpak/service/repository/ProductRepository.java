package ua.hillel.katerynashpak.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.hillel.katerynashpak.service.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}