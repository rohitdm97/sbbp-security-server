package com.rohitdm97.sbbpserver.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.rohitdm97.sbbpserver.model.Product;
import com.rohitdm97.sbbpserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        final List<Product> all = productRepository.findAll();
        if (SecurityUtils.getSubject().isPermitted("product:read:*")) {
            return all;
        } else if (SecurityUtils.getSubject().isPermitted("product:read")) {
            return all.stream().limit(3).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
