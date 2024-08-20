package com.Akhil.Product_service.Service;

import com.Akhil.Product_service.Payload.ProductRequest;
import com.Akhil.Product_service.Payload.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);

    public void deleteProductById(long productId);
}