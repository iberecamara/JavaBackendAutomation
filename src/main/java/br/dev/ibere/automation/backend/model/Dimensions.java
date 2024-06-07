package br.dev.ibere.automation.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Dimensions {

    @JsonProperty
    private BigDecimal width;
    @JsonProperty
    private BigDecimal height;
    @JsonProperty
    private BigDecimal depth;

}
