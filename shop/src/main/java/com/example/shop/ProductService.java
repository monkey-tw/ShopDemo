package com.example.shop;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Cacheable(cacheNames = "products", key = "#page + '-' + #size")
    public List<Product> getProducts(int page, int size) {
        // 从数据源获取商品列表
        return getDefaultProducts(page, size);
    }

    private List<Product> getDefaultProducts(int page, int size) {
        // 返回默认商品列表
        return List.of(
                new Product("https://example.com/product1.jpg", "Product 1", 9.99, 10),
                new Product("https://example.com/product2.jpg", "Product 2", 14.99, 5)
        );
    }
}
