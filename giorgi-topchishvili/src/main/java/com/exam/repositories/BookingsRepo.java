package com.exam.repositories;


import com.exam.entities.BookingEntity;
import com.exam.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public interface BookingsRepo extends JpaRepository<BookingEntity, Long> {


    List<BookingEntity> findAllByRoom(RoomEntity room);

    List<BookingEntity> findAllByValidUntilAfter(Instant after);

    @Query("select count (*) from BookingEntity b where b.room.hotel.id=:id")
    Integer getBookingCountByHotelId(Long id);

    @Query("select SUM(DATEDIFF(b.createdDate, b.validUntil)) from BookingEntity b where b.room.hotel.id=: id")
    Long getBookingDaysCountByHotelId(Long id);

    @Query("select SUM(b.room.price) from BookingEntity b where b.room.hotel.id = :id")
    BigDecimal getPriceByHotelId(Long id);

}
