package ua.hillel.katerynashpak.service.jpa;

import org.springframework.stereotype.Service;
import ua.hillel.katerynashpak.model.Product;

import java.util.List;
public interface ProductService {
    Product getProduct(int id);
    List<Product> getAllProducts();
    void createProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
}
