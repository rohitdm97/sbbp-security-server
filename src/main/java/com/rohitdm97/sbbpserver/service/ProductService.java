package com.rohitdm97.sbbpserver.service;

import java.util.List;

import com.rohitdm97.sbbpserver.model.Product;
import com.rohitdm97.sbbpserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

}
