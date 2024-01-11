package com.exam.mappers;

import com.exam.dtos.request.HotelCreationRequest;
import com.exam.dtos.response.HotelResponse;
import com.exam.entities.HotelEntity;
import com.exam.enums.RecordState;

public class HotelMapper {

    public static HotelEntity mapRequestToEntity(HotelCreationRequest request) {
        return HotelEntity.builder()
                .name(request.getName())
                .recordState(RecordState.ACTIVE)
                .build();
    }

    public static HotelResponse mapEntityToResponse(HotelEntity entity) {
        return HotelResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdDate(entity.getCreatedDate())
                .lastModifiedDate(entity.getLastModifiedDate())
                .recordState(entity.getRecordState())
                .build();
    }


}
