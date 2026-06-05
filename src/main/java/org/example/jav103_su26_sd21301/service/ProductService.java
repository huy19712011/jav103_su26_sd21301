package org.example.jav103_su26_sd21301.service;

import org.example.jav103_su26_sd21301.entity.Product;
import org.example.jav103_su26_sd21301.repository.ProductRepository;

import java.util.List;

public class ProductService {

    ProductRepository productRepository = new ProductRepository();

    public List<Product> getProducts() {

        return productRepository.getProducts();
    }

    public Product getProductById(Long id) {

        return productRepository.getProductById(id);
    }

    public void updateProduct(Product product) {

        productRepository.updateProduct(product);
    }

    public void deleteProduct(long id) {

        productRepository.deleteProduct(id);
    }

    public void addProduct(Product product) {

        productRepository.addProduct(product);
    }

}
