package com.exam.mappers;

import com.exam.dtos.request.BookingCreationRequest;
import com.exam.dtos.response.BookingResponse;
import com.exam.entities.BookingEntity;
import com.exam.entities.RoomEntity;
import com.exam.enums.RecordState;

import java.math.BigDecimal;

public class BookingMapper {

    public static BookingEntity mapRequestToEntity(BookingCreationRequest request, RoomEntity room, BigDecimal bookingPrice) {
        return BookingEntity.builder()
                .validUntil(request.getValidUntil())
                .bookingPrice(bookingPrice)
                .room(room)
                .recordState(RecordState.ACTIVE)
                .build();
    }

    public static BookingResponse mapEntityToResponse(BookingEntity entity) {
        return BookingResponse.builder()
                .id(entity.getId())
                .validUntil(entity.getValidUntil())
                .roomId(entity.getRoom().getId())
                .bookingPrice(entity.getBookingPrice())
                .createdDate(entity.getCreatedDate())
                .lastModifiedDate(entity.getLastModifiedDate())
                .recordState(entity.getRecordState())
                .build();
    }


}
