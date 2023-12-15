package ua.hillel.katerynashpak.service.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("orders")
public class OrderRecord {
    @Id
    private int id;
    private Date date;
    private double cost;
    private List<Product> product;

}