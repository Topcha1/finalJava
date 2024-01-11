package com.exam.services;


import com.exam.aspect.Loggable;
import com.exam.dtos.request.RoomCreationRequest;
import com.exam.dtos.response.RoomResponse;
import com.exam.entities.HotelEntity;
import com.exam.entities.RoomEntity;
import com.exam.enums.RecordState;
import com.exam.exception.CoreException;
import com.exam.mappers.RoomMapper;
import com.exam.repositories.HotelsRepo;
import com.exam.repositories.RoomsRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl {

    public static final String ROOM_CANT_BE_ADDED = "room can't be added to that hotel";
    public static final String HOTEL_WITH_ID_NOT_FOUND = "hotel with id %d not found";

    private final RoomsRepo roomsRepo;

    private final HotelsRepo hotelsRepo;

    @Loggable
    @Transactional
    public RoomResponse createRoom(RoomCreationRequest request, Long hotelId) {

        Optional<HotelEntity> byId = hotelsRepo.findById(hotelId);
        if (byId.isEmpty() || byId.get().getRecordState().equals(RecordState.INACTIVE)) {
            throw new CoreException(ROOM_CANT_BE_ADDED);
        }

        RoomEntity saved = roomsRepo.save(RoomMapper.mapRequestToEntity(request, byId.get()));

        return RoomMapper.mapEntityToResponse(saved);

    }

    @Loggable
    public List<RoomResponse> getFreeRooms() {
        return getRoomsByState(false);
    }

    @Loggable
    public List<RoomResponse> getOccupiedRooms() {
        return getRoomsByState(true);
    }

    private List<RoomResponse> getRoomsByState(Boolean isOccupied) {
        return roomsRepo.findAllByIsOccupied(isOccupied).stream()
                .map(RoomMapper::mapEntityToResponse)
                .toList();
    }

    public List<RoomResponse> getFreeRoomsFromHotel(Long hotelId) {

        Optional<HotelEntity> hotelOpt = hotelsRepo.findById(hotelId);

        if (hotelOpt.isEmpty()) {
            throw new CoreException(String.format(HOTEL_WITH_ID_NOT_FOUND, hotelId));
        }

        return roomsRepo.findAllByIsOccupiedAndHotel(false, hotelOpt.get()).stream()
                .map(RoomMapper::mapEntityToResponse)
                .toList();
    }
}
