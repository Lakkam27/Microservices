package com.example.Cart.Controller;

import com.example.Cart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity) {
        return cartService.addItemToCart(userId, productId, quantity);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> delItemTFromCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity) {
        return cartService.delItemTFromCart(userId, productId, quantity);
    }
}
