package ru.geekbrains.mvc.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.mvc.dao.ProductDB;
import ru.geekbrains.mvc.domain.Product;
import ru.geekbrains.mvc.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductDB databaseConnection;

    @Autowired
    public ProductRepositoryImpl(ProductDB databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public List<Product> findAll() {
        return databaseConnection.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return databaseConnection.findById(id);
    }

    @Override
    public boolean save(Product product) {
        return databaseConnection.save(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        Optional<Product> product = findProductById(id);
        return product.filter(databaseConnection::delete).isPresent();
    }

    @Override
    public boolean updateProduct(Product product) {
        return databaseConnection.update(product);
    }

    @Override
    public List<Product> findProductsByCategoryId(Long id) {
        return databaseConnection.findProductsByCategoryId(id);
    }
}
