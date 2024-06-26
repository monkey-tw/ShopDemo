package com.example.shop;

import com.example.shop.Product;
import com.example.shop.ProductRepositoryPort;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    @Override
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