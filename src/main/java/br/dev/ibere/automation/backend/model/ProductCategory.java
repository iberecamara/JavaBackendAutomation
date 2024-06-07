package br.dev.ibere.automation.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductCategory {

    @JsonProperty
    private String slug;
    @JsonProperty
    private String name;
    @JsonProperty
    private String url;

}
