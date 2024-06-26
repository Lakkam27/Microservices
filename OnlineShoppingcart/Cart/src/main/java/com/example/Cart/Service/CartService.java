package com.example.Cart.Service;

import com.example.Cart.Cart.Cart;
import com.example.Cart.Repository.CartRepository;
import com.lakkam.Entity.User;
import com.lakkam.Prodouct.Product.Product;
import com.lakkam.Prodouct.Repository.ProductRepository;
import com.lakkam.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    public ResponseEntity<String> addItemToCart(long userId, long productId, long quantity) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart(userId);
            cart = cartRepository.save(cart);
        }

        cart.addProduct(productId, (int) quantity);
        cartRepository.save(cart);

        return new ResponseEntity<>("Product added to cart successfully!", HttpStatus.OK);
    }

    public ResponseEntity<String> delItemTFromCart(Long userId, Long productId, Integer quantity) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
        }

        if (cart.getProductQuantities().containsKey(productId)) {
            int currentQuantity = cart.getProductQuantities().get(productId);
            if (currentQuantity < quantity) {
                return new ResponseEntity<>("Insufficient product quantity in cart", HttpStatus.OK);
            } else {
                if (currentQuantity == quantity) {
                    cart.getProductQuantities().remove(productId);
                } else {
                    cart.getProductQuantities().put(productId, currentQuantity - quantity);
                }
                cartRepository.save(cart);
                return new ResponseEntity<>("Product quantity reduced successfully", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("Product not found in cart", HttpStatus.NOT_FOUND);
        }
    }
}
