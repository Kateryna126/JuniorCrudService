package ua.hillel.katerynashpak.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hillel.katerynashpak.model.Product;
import ua.hillel.katerynashpak.repository.ProductRepository;
import ua.hillel.katerynashpak.service.jpa.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(int id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
        }
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

