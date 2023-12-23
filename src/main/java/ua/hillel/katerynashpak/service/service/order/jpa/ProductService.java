package ua.hillel.katerynashpak.service.service.order.jpa;

import ua.hillel.katerynashpak.service.model.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(int id);
    List<Product> getAllProducts();
    void createProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
}
