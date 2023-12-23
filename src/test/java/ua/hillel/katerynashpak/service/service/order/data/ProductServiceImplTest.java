package ua.hillel.katerynashpak.service.service.order.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.hillel.katerynashpak.service.model.Product;
import ua.hillel.katerynashpak.service.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        product = new Product();
    }

    @Test
    public void shouldReturnProductWhenGetProductIsCalled() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Product result = productService.getProduct(1);

        assertEquals(product, result);
        verify(productRepository).findById(1);
    }

    @Test
    public void shouldReturnAllProductsWhenGetAllProductsIsCalled() {
        List<Product> products = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertEquals(products, result);
        verify(productRepository).findAll();
    }

    @Test
    public void shouldSaveProductWhenCreateProductIsCalled() {
        when(productRepository.save(product)).thenReturn(product);

        productService.createProduct(product);

        verify(productRepository).save(product);
    }

    @Test
    public void shouldUpdateProductWhenUpdateProductIsCalled() {
        when(productRepository.existsById(1)).thenReturn(true);

        productService.updateProduct(1, product);

        verify(productRepository).save(product);
    }

    @Test
    public void shouldDeleteProductWhenDeleteProductIsCalled() {
        doNothing().when(productRepository).deleteById(1);

        productService.deleteProduct(1);

        verify(productRepository).deleteById(1);
    }
}

