package com.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.DTO.ProductDTO;
import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @PostMapping("/insert")
    public ProductDTO create(@RequestBody ProductDTO request) {
        final Product product = productService.mapToEntity(request);
        final Product result = productService.insert(product);
        return productService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody ProductDTO request) {
        final Product product = productService.mapToEntity(request);
        final Product result = productService.update(product, id);
        return result;
    }

    @GetMapping("/all")
    public List<ProductDTO> getAll() {
        return productService.getAll().stream().map(product -> productService.mapToDto(product))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return productService.delete(id);
    }

    @GetMapping("/test")
    public String getHome() {
        return "Hello World";
    }
}
