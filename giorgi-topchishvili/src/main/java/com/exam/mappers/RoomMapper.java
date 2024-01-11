package com.exam.mappers;

import com.exam.dtos.request.RoomCreationRequest;
import com.exam.dtos.response.RoomResponse;
import com.exam.entities.HotelEntity;
import com.exam.entities.RoomEntity;
import com.exam.enums.RecordState;

public class RoomMapper {

    public static RoomEntity mapRequestToEntity(RoomCreationRequest request, HotelEntity hotel) {
        return RoomEntity.builder()
                .price(request.getPrice())
                .isOccupied(false)
                .hotel(hotel)
                .recordState(RecordState.ACTIVE)
                .build();
    }

    public static RoomResponse mapEntityToResponse(RoomEntity entity) {
        return RoomResponse.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .isOccupied(entity.getIsOccupied())
                .createdDate(entity.getCreatedDate())
                .lastModifiedDate(entity.getLastModifiedDate())
                .recordState(entity.getRecordState())
                .build();
    }

}
