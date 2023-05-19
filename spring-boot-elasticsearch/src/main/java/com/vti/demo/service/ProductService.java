package com.vti.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.demo.document.Product;
import com.vti.demo.repositories.ProductRepository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepo;

    @Autowired
    private ElasticsearchClient esClient;

    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product insertProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product product1 = productRepo.findById(id).get();
        product1.setPrice(product.getPrice());
        return productRepo.save(product1);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name) throws IOException {
        Query query = Query.of(q -> q.match(m -> m.field("name").query(name).fuzziness("1")));
        SearchRequest searchRequest = SearchRequest.of(builder -> builder.index(List.of("products")).query(query));
        SearchResponse<Product> searchResponse = esClient.search(searchRequest, Product.class);

        List<Product> products = new ArrayList<>();
        for (Hit<Product> hit : searchResponse.hits().hits()) {
            products.add(hit.source());
        }
        return products;
    }

}
