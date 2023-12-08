package ua.hillel.katerynashpak.service.model;

import ua.hillel.katerynashpak.service.model.Product;

import java.util.Date;
import java.util.List;

public class OrderRecord {
    private int id;
    private Date date;
    private double cost;
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
