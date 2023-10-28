package com.product.service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.DTO.ProductDTO;
import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    ObjectMapper mapper;

    @Override
    public Product insert(Product product) {
        final Product result = productRepository.save(product);
        return result;
    }

    @Override
    public Product update(Product product, Long id) {
        Product result = getbyId(id);

        if (result != null) {
            result.setName(product.getName());
            result.setDesc(product.getDesc());
            result.setPrice(product.getPrice());
            result.setType(product.getType());
            result.setAmount(product.getAmount());
            productRepository.save(product);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        Product result = getbyId(id);

        if (result != null) {
            productRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> result = productRepository.findAll();
        return result;
    }

    @Override
    public Product getbyId(Long id) {

        Optional<Product> result = productRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public ProductDTO mapToDto(Product product) {
        return mapper.convertValue(product, ProductDTO.class);
    }

    @Override
    public Product mapToEntity(ProductDTO productDto) {
        return mapper.convertValue(productDto, Product.class);
    }
}
