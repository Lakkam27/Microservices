package com.example.Cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Cart", "com.lakkam"})
@EnableJpaRepositories(basePackages = {"com.example.Cart.Repository", "com.lakkam.Repository", "com.lakkam.Prodouct.Repository"})
public class CartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
	}
}