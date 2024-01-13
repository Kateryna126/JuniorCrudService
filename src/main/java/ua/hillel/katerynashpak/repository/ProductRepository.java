package ua.hillel.katerynashpak.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.hillel.katerynashpak.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}