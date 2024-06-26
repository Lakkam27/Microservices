package com.lakkam.Prodouct.Repository;

import com.lakkam.Prodouct.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
