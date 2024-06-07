package br.dev.ibere.automation.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class Products {

    @JsonProperty
    private List<Product> products;
    @JsonProperty(required = false)
    private Integer total;
    @JsonProperty(required = false)
    private Integer skip;
    @JsonProperty(required = false)
    private Integer limit;

    public Products() {
        this.products = new ArrayList<>();
    }

}
