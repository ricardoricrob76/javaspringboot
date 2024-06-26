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
public class OwnerPostDTO {

    // Usuario que está colocando o carro para venda.. pessoa que irá postar os carros para venda..
    private String name;
    private String type;
    private String contactNumber;

}
