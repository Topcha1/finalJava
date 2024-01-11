package com.exam.repositories;


import com.exam.entities.HotelEntity;
import com.exam.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomsRepo extends JpaRepository<RoomEntity, Long> {

    List<RoomEntity> findAllByIsOccupied(Boolean isOccupied);

    List<RoomEntity> findAllByIsOccupiedAndHotel(Boolean isOccupied, HotelEntity hotel);

    List<RoomEntity> findAllByHotel(HotelEntity hotel);
}
