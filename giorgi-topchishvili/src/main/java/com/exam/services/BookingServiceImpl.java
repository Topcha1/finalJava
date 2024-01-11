package com.exam.services;


import com.exam.aspect.Loggable;
import com.exam.dtos.request.BookingCreationRequest;
import com.exam.dtos.response.BookingReportResponse;
import com.exam.dtos.response.BookingResponse;
import com.exam.entities.BookingEntity;
import com.exam.entities.RoomEntity;
import com.exam.enums.RecordState;
import com.exam.exception.CoreException;
import com.exam.mappers.BookingMapper;
import com.exam.repositories.BookingsRepo;
import com.exam.repositories.HotelsRepo;
import com.exam.repositories.RoomsRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl {

    public static final String CANT_BOOK_THAT_ROOM = "can't book that room";

    private final BookingsRepo bookingsRepo;

    private final RoomsRepo roomsRepo;

    private final HotelsRepo hotelsRepo;

    @Loggable
    @Transactional
    public BookingResponse createBooking(BookingCreationRequest request, Long roomId) {

        Optional<RoomEntity> byId = roomsRepo.findById(roomId);

        validateBookingCreationRequest(request, byId);

        byId.get().setIsOccupied(true);
        roomsRepo.save(byId.get());

        BigDecimal price = calculateBookingPrice(request.getValidUntil(), byId.get().getPrice());
        BookingEntity saved = bookingsRepo.save(BookingMapper.mapRequestToEntity(request, byId.get(), price));

        return BookingMapper.mapEntityToResponse(saved);
    }

    @Loggable
    public List<BookingResponse> getBookings() {
        return bookingsRepo.findAll().stream()
                .map(BookingMapper::mapEntityToResponse)
                .toList();
    }

    @Loggable
    public List<BookingReportResponse> getBookingsReport() {

        Instant minus = Instant.now().minus(Period.ofDays(365));
        List<BookingEntity> bookings = bookingsRepo.findAllByValidUntilAfter(minus);

        Map<String, BookingReportResponse> hotelReportMap = new HashMap<>();

        for (BookingEntity bookingEntity : bookings) {
            String hotelName = bookingEntity.getRoom().getHotel().getName();
            if (!hotelReportMap.containsKey(hotelName)) {
                hotelReportMap.put(bookingEntity.getRoom().getHotel().getName(), new BookingReportResponse(hotelName, 0, BigDecimal.ZERO));
            }

            BookingReportResponse bookingReportResponse = hotelReportMap.get(hotelName);
            bookingReportResponse.setRentRoom(bookingReportResponse.getRentRoom() + 1);
            bookingReportResponse.setTotalAmount(bookingReportResponse.getTotalAmount().add(bookingEntity.getBookingPrice()));

        }

        return hotelReportMap.values().stream().toList();
    }

    private void validateBookingCreationRequest(BookingCreationRequest request, Optional<RoomEntity> byId) {
        if (byId.isEmpty() ||
                byId.get().getRecordState().equals(RecordState.INACTIVE) ||
                byId.get().getIsOccupied() ||
                byId.get().getHotel().getRecordState().equals(RecordState.INACTIVE)) {

            throw new CoreException(CANT_BOOK_THAT_ROOM);
        }
    }

    private BigDecimal calculateBookingPrice(Instant validUntil, BigDecimal roomPrice) {
        long minutes = ChronoUnit.MINUTES.between(Instant.now(), validUntil);
        double days = ((minutes / 60.0) / 24.0);

        return roomPrice.multiply(BigDecimal.valueOf(days));
    }
}
