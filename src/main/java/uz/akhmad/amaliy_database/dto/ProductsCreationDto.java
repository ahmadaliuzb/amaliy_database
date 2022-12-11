package uz.akhmad.amaliy_database.dto;

import uz.akhmad.amaliy_database.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsCreationDto {
    private List<Product> products;

    public ProductsCreationDto() {
        this.products = new ArrayList<>();
    }

    public ProductsCreationDto(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
