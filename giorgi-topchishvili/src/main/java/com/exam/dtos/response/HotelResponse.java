package com.exam.dtos.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class HotelResponse extends AuditDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
