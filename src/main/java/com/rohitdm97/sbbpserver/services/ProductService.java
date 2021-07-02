package com.rohitdm97.sbbpserver.services;

import java.util.Collections;
import java.util.List;

import com.rohitdm97.sbbpserver.entity.Product;
import com.rohitdm97.sbbpserver.entity.Product_;
import com.rohitdm97.sbbpserver.repository.ProductRepository;
import com.rohitdm97.sbbpserver.services.request.ProductQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getProducts(ProductQuery query) {
        if (query == null) {
            return productRepository.findAll();
        }
        Page<Product> page = productRepository.findAll(toSpec(query), toPage(query));
        return page.isEmpty() ? Collections.emptyList() : page.getContent();
    }

    private Pageable toPage(ProductQuery query) {
        return PageRequest.of(query.getPageIdx(), query.getPageSize());
    }

    private Specification<Product> toSpec(ProductQuery request) {
        final String word = request.getWord() == null ? null : request.getWord().toLowerCase();
        return (root, query, cb) -> cb.and(
                cb.like(cb.lower(root.get(Product_.name)), word)
        );
    }

}
