package com.lakkam.Prodouct.Controllers;

import com.lakkam.Prodouct.Product.Product;
import com.lakkam.Prodouct.Service.ProductService;
import com.lakkam.Prodouct.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("{productid}")
    public ResponseEntity<Product> getSpecific(@PathVariable long productid){
        return new ResponseEntity<>(productService.getSpecific(productid), HttpStatus.OK);

    }
    @PostMapping()
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.ok().body("added ");
    }
    @DeleteMapping("{productid}")
    public ResponseEntity<String> deleteProduct(@PathVariable long productid){
        productService.deleteProduct(productid);
        return new ResponseEntity<>("Product is sucessfilly delleted ",HttpStatus.OK);
    }
}
