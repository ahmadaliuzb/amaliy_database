package uz.akhmad.amaliy_database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akhmad.amaliy_database.entity.Product;
import uz.akhmad.amaliy_database.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void saveAll(List<Product> products) {
        productRepository.saveAll(products);
    }


}
