package com.rohitdm97.sbbpserver.controller;

import java.util.List;

import com.rohitdm97.sbbpserver.model.Product;
import com.rohitdm97.sbbpserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/product")

@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public List<Product> getAll() {
        return productService.getAll();
    }

}
