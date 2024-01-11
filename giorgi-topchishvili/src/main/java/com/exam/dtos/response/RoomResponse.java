package com.exam.dtos.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse extends AuditDto {


    @JsonProperty("id")
    private Long id;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("isOccupied")
    private Boolean isOccupied;

}
