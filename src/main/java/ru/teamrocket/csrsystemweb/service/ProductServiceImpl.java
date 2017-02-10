package ru.teamrocket.csrsystemweb.service;

import com.sun.jersey.api.NotFoundException;
import ru.teamrocket.csrsystemweb.dao.ProductDAOImpl;
import ru.teamrocket.csrsystemweb.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Kate on 07.02.2017.
 */

@Path("/products")
public class ProductServiceImpl implements ProductService{

    private ProductDAOImpl productDAO = new ProductDAOImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getProducts() {
        List<Product> products = productDAO.getProducts();
        if (products == null) {
            throw new NotFoundException("Product are not found");
        }
        GenericEntity<List<Product>> generic = new GenericEntity<List<Product>>(products){};
        return Response.ok(generic).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Product getProductById(@PathParam("id") int id) {
        Product product = productDAO.getProductById(id);
        if (product == null) {
            throw new NotFoundException("Product " + id + " is not found");
        }
        return product;
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertProduct(Product product) {
        if (product == null) {
            throw new NotFoundException("Client is null");
        }
        productDAO.createProduct(product);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteProduct(@PathParam("id") int id) {
        productDAO.deleteProduct(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateProduct(Product product) {
        productDAO.updateProduct(product);
        if (product == null) {
            throw new NotFoundException("Product " + product.getProductId() + " is not found");
        }
        return Response.status(Response.Status.OK).build();
    }
}
