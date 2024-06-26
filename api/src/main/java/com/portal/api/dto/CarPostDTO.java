package com.portal.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CarPostDTO {  // Data Transfer Object (DTO) Trabalhar nas nossas classes Java..

    // Carro que vai ficar a venda..
    // Conceitos do DTOs.

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private String createdDate;
    private Long ownerID;
    private String ownerName;
    private String ownerType;
    private String contact;

}
