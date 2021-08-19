package ru.geekbrains.mvc.service;

import ru.geekbrains.mvc.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findProductById(int id);

    boolean addProduct(Product product);

    boolean deleteProduct(int id);
}