package ua.hillel.katerynashpak.service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("product")
public class Product {
    @Id
    private int id;
    private String name;
    private double cost;

}

