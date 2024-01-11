package com.exam.dtos.response;

import com.exam.enums.RecordState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AuditDto {

    @JsonProperty("createdDate")
    private Instant createdDate;

    @JsonProperty("lastModifiedDate")
    private Instant lastModifiedDate;

    @JsonProperty("recordState")
    private RecordState recordState;

}
