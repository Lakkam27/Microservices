package com.lakkam.Prodouct.Service;

import com.lakkam.Prodouct.Product.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSpecific(long productid);

    void addProduct(Product product);

    void deleteProduct(long productid);
}
