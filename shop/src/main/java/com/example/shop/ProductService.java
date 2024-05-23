package com.example.shop;

import com.example.shop.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    public List<Product> getProducts(int page, int size) {
        // 这里可以添加业务逻辑处理
        return productRepositoryPort.getProducts(page, size);
    }
}