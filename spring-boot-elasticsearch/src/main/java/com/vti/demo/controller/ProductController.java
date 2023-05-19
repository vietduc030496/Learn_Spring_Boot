package com.vti.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.document.Product;
import com.vti.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public Iterable<Product> getAll() {
        return productService.getProducts();
    }

    @PostMapping("/insert")
    public Product insert(@RequestBody Product product) {
        return productService.insertProduct(product);
    }
    
    @GetMapping("/find-name")
    public List<Product> custom(@RequestParam("q") String name) throws IOException {
        return productService.findByName(name);
    }

}
