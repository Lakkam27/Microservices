package com.lakkam.Prodouct.Service;

import com.lakkam.Prodouct.Product.Product;
import com.lakkam.Prodouct.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSpecific(long productid ) {
        return productRepository.findById(productid).orElse(null);

    }
    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long productid) {
        productRepository.deleteById(productid);
    }
}
