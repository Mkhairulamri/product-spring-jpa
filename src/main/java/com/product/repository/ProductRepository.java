package com.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // List<Product> findById(Long id);

    List<Product> findByMerchant(int merchant);

    List<Product> findByCategories(String categories);

    Optional<Product> findById(Long id);
}
