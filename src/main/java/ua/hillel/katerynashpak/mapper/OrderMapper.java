package ua.hillel.katerynashpak.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ua.hillel.katerynashpak.dto.OrderRecordDto;
import ua.hillel.katerynashpak.model.OrderRecord;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class}, implementationName = "CustomOrderMapper")
@Component("customOrderMapper")
public interface OrderMapper {

    @Mapping(target = "products", source = "products")
    OrderRecordDto orderToOrderDto(OrderRecord order);

    @Mapping(target = "products", source = "products")
    OrderRecord orderDtoToOrder(OrderRecordDto dto);

    List<OrderRecordDto> toOrderDtoList(Iterable<OrderRecord> orders);
}