package ua.hillel.katerynashpak.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ua.hillel.katerynashpak.model.Product;
import ua.hillel.katerynashpak.dto.ProductDto;

import java.util.List;

@Mapper
@Component
public interface ProductMapper {
    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto dto);
    List<Product> productsToModel(List<ProductDto> dtos);
    List<ProductDto> productsFromModel(List<Product> products);
}
