package br.dev.ibere.automation.backend.rest.client.product.category;

import br.dev.ibere.automation.backend.model.ProductCategory;

import java.util.List;

public interface ProductCategoryRest {

    List<ProductCategory> all();

    List<String> list();

}
