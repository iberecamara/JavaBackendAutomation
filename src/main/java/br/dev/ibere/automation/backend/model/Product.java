package br.dev.ibere.automation.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    @JsonProperty
    private String title;
    @JsonProperty
    private String description;
    @JsonProperty
    private String category;
    @JsonProperty
    private BigDecimal price;
    @JsonProperty
    private BigDecimal discountPercentage;
    @JsonProperty
    private BigDecimal rating;
    @JsonProperty
    private Integer stock;
    @JsonProperty
    private List<String> tags;
    @JsonProperty
    private String brand;
    @JsonProperty
    private String sku;
    @JsonProperty
    private Integer weight;
    @JsonProperty
    private Dimensions dimensions;
    @JsonProperty
    private String warrantyInformation;
    @JsonProperty
    private String shippingInformation;
    @JsonProperty
    private String availabilityStatus;
    @JsonProperty
    private List<Review> reviews;
    @JsonProperty
    private String returnPolicy;
    @JsonProperty
    private Integer minimumOrderQuantity;
    @JsonProperty
    private Meta meta;
    @JsonProperty
    private String thumbnail;
    @JsonProperty
    private List<String> images;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isDeleted;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String deletedOn;

}
