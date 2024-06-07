package br.dev.ibere.automation.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Meta {

    @JsonProperty
    private String createdAt;
    @JsonProperty
    private String updatedAt;
    @JsonProperty
    private String barcode;
    @JsonProperty
    private String qrCode;

}
