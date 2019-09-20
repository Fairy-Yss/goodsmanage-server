package com.lqcool.service.product;

import com.lqcool.model.product.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    public abstract void addProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProducts();
    public List<Product> findAllProducts();
}
