package com.rohitdm97.sbbpserver.repository;

import java.util.List;

import com.rohitdm97.sbbpserver.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product> {

    List<Product> findAll();

}
