package com.exam.dtos.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse extends AuditDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("validUntil")
    private Instant validUntil;

    @JsonProperty("bookingPrice")
    private BigDecimal bookingPrice;

    @JsonProperty("hotelId")
    private Long roomId;

}
