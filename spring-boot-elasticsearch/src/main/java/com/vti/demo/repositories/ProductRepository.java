package com.vti.demo.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.vti.demo.document.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {

}
