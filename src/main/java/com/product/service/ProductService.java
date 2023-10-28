package com.product.service;

import java.util.List;

import com.product.DTO.ProductDTO;
import com.product.entity.Product;

public interface ProductService {

    Product getbyId(Long id);

    Product insert(Product product);

    Product update(Product product, Long id);

    Boolean delete(Long id);

    List<Product> getAll();

    Product mapToEntity(ProductDTO product);

    ProductDTO mapToDto(Product product);

}
