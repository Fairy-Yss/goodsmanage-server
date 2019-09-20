package com.lqcool.dao.product;

import com.lqcool.model.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    public List<Product> findAllProducts() throws Exception;
}
