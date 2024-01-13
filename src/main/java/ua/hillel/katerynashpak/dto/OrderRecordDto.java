package ua.hillel.katerynashpak.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRecordDto {
    private int id;
    private Date date;
    private double cost;
    private List<ProductDto> products;
}
