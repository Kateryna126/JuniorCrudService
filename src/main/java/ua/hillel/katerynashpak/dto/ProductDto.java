package ua.hillel.katerynashpak.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private int id;
    private String name;
    private double cost;
}

