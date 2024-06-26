    package com.example.Cart.Repository;

    import com.example.Cart.Cart.Cart;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.Optional;
    @Repository
    public interface CartRepository extends JpaRepository<Cart,Long> {
        @Override
        Optional<Cart> findById(Long cartId);

        Cart findByUserId(long userId);
    }
