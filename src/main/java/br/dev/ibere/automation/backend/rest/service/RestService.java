package br.dev.ibere.automation.backend.rest.service;

import br.dev.ibere.automation.backend.model.Product;
import br.dev.ibere.automation.backend.model.ProductCategory;
import br.dev.ibere.automation.backend.rest.client.product.ProductRest;
import br.dev.ibere.automation.backend.rest.client.product.category.ProductCategoryRest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class RestService {

    @Autowired
    private ProductRest productRest;

    @Autowired
    private ProductCategoryRest productCategoryRest;

    public List<Product> getAllProducts() {
        return productRest.all();
    }

    public List<ProductCategory> getAllCategories() {
        return productCategoryRest.all();
    }

    public List<String> getAllCategoriesList() {
        return productCategoryRest.list();
    }

    public Product getProductById(Integer id) {
        return productRest.byId(id);
    }

    public List<Product> searchProductByKeyword(String keyword) {
        return productRest.search(keyword);
    }

    public List<Product> searchProductByCategory(String category) {
        return productRest.byCategory(category);
    }

    public Product createProduct(Product product) {
        return productRest.add(product);
    }

    public Product updateProduct(Product product) {
        return productRest.update(product);
    }

    public Product deleteProduct(Integer id) {
        return productRest.delete(id);
    }

}