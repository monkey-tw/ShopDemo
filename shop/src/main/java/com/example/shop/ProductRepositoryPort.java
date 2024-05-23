package com.example.shop;

import com.example.shop.Product;
import java.util.List;

public interface ProductRepositoryPort {
    List<Product> getProducts(int page, int size);
}