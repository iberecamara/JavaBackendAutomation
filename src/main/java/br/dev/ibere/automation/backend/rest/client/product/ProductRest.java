package br.dev.ibere.automation.backend.rest.client.product;

import br.dev.ibere.automation.backend.model.Product;

import java.util.List;

public interface ProductRest {

    List<Product> all();

    Product byId(Integer id);

    List<Product> search(String searchTerm);

    List<Product> byCategory(String category);

    Product add(Product product);

    Product update(Product product);

    Product delete(Integer id);

}
