package ru.teamrocket.csrsystemweb.dao;

import ru.teamrocket.csrsystemweb.model.Product;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */
public interface ProductDAO {
    Product getProductById(int id);
    List<Product> getProducts();
    void createProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
}
