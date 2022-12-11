package uz.akhmad.amaliy_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.akhmad.amaliy_database.entity.Product;

import java.util.List;
import java.util.UUID;

@RequestMapping
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
