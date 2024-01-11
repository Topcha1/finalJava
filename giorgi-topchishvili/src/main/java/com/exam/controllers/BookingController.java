package com.exam.controllers;


import com.exam.dtos.request.BookingCreationRequest;
import com.exam.dtos.response.BookingReportResponse;
import com.exam.dtos.response.BookingResponse;
import com.exam.services.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingServiceImpl bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingCreationRequest request, @RequestParam Long roomId) {
        return ResponseEntity.ok(bookingService.createBooking(request, roomId));
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getBookings() {
        return ResponseEntity.ok(bookingService.getBookings());
    }

    @GetMapping("/bookingsReport")
    public ResponseEntity<List<BookingReportResponse>> getBookingsReport() {
        return ResponseEntity.ok(bookingService.getBookingsReport());
    }
}
