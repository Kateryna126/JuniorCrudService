package ua.hillel.katerynashpak.service.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.hillel.katerynashpak.model.Product;
import ua.hillel.katerynashpak.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
    }

    @Test
    void shouldReturnProductWhenGetProductIsCalled() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Product result = productService.getProduct(1);

        assertEquals(product, result);
        verify(productRepository).findById(1);
    }

    @Test
    void shouldReturnAllProductsWhenGetAllProductsIsCalled() {
        List<Product> products = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertEquals(products, result);
        verify(productRepository).findAll();
    }

    @Test
    void shouldSaveProductWhenCreateProductIsCalled() {
        when(productRepository.save(product)).thenReturn(product);

        productService.createProduct(product);

        verify(productRepository).save(product);
    }

    @Test
    void shouldUpdateProductWhenUpdateProductIsCalled() {
        when(productRepository.existsById(1)).thenReturn(true);

        productService.updateProduct(1, product);

        verify(productRepository).save(product);
    }

    @Test
    void shouldDeleteProductWhenDeleteProductIsCalled() {
        doNothing().when(productRepository).deleteById(1);

        productService.deleteProduct(1);

        verify(productRepository).deleteById(1);
    }
}

