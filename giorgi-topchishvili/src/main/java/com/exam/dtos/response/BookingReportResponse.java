package com.exam.dtos.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingReportResponse {

    @JsonProperty("hotelName")
    private String hotelName;

    @JsonProperty("rentRoom")
    private Integer rentRoom;

    @JsonProperty("totalAmount")
    private BigDecimal totalAmount;

}
