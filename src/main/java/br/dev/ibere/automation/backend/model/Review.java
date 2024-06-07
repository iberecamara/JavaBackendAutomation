package br.dev.ibere.automation.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Review {

    @JsonProperty
    private Integer rating;
    @JsonProperty
    private String comment;
    @JsonProperty
    private String date;
    @JsonProperty
    private String reviewerName;
    @JsonProperty
    private String reviewerEmail;

}
