package com.Akhil.Product_service.Repository;

import com.Akhil.Product_service.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
