package ru.teamrocket.csrsystemweb.service;

import ru.teamrocket.csrsystemweb.model.Product;
import javax.ws.rs.core.Response;

/**
 * Created by Kate on 07.02.2017.
 */

public interface ProductService {
    Product getProductById(int id);
    Response getProducts();
    Response insertProduct(Product product);
    Response deleteProduct(int id);
    Response updateProduct(Product product);
}
