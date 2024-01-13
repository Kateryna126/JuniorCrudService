package ua.hillel.katerynashpak.converter;

import org.springframework.stereotype.Component;
import ua.hillel.katerynashpak.model.Product;
import ua.hillel.katerynashpak.dto.OrderRecordDto;
import ua.hillel.katerynashpak.dto.ProductDto;
import ua.hillel.katerynashpak.model.OrderRecord;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;


@Component
public class OrderConverter {
    public ProductDto convertProductToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCost(product.getCost());
        // Заповніть інші поля DTO тут
        return dto;
    }

    public List<ProductDto> convertProductListToDtoList(List<Product> products) {
        List<ProductDto> dtos = new ArrayList<>();
        for (Product product : products) {
            dtos.add(convertProductToDto(product));
        }
        return dtos;
    }
    public OrderRecordDto convertToDto(OrderRecord orderRecord) {
        OrderRecordDto dto = new OrderRecordDto();
        dto.setId(orderRecord.getId());
        dto.setDate(orderRecord.getDate());
        dto.setCost(orderRecord.getCost());
        dto.setProducts(convertProductListToDtoList(orderRecord.getProducts()));
        return dto;
    }
    public OrderRecordDto fromModel(OrderRecord order) {
        return OrderRecordDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .cost(order.getCost())
                .products(productsFromModel(order.getProducts()))
                .build();
    }

    public List<OrderRecordDto> fromModel(Iterable<OrderRecord> orders) {
        List<OrderRecordDto> orderDtos = new ArrayList<>();
        for (OrderRecord order : orders) {
            orderDtos.add(fromModel(order));
        }
        return orderDtos;
    }

    public OrderRecord toModel(OrderRecordDto dto) {
        return OrderRecord.builder()
                .date(dto.getDate())
                .cost(dto.getCost())
                .products(productsToModel(dto.getProducts()))
                .build();
    }

    public OrderRecord toModel(OrderRecord order, OrderRecordDto dto) {
        order.setDate(dto.getDate());
        order.setCost(dto.getCost());
        order.setProducts(productsToModel(dto.getProducts()));
        order.setDate(dto.getDate());
        return order;
    }

    private List<ProductDto> productsFromModel(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        if (isNotEmpty(products)) {
            for (Product product : products) {
                ProductDto dto = ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .cost(product.getCost())
                        .build();
                productDtos.add(dto);
            }
        }
        return productDtos;
    }

    private List<Product> productsToModel(List<ProductDto> dtos) {
        List<Product> products = new ArrayList<>();
        if (isNotEmpty(dtos)) {
            for (ProductDto dto : dtos) {
                Product product = Product.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .cost(dto.getCost())
                        .build();
                products.add(product);
            }
        }
        return products;
    }
}
