package com.exam.controllers;


import com.exam.dtos.request.HotelCreationRequest;
import com.exam.dtos.response.HotelResponse;
import com.exam.services.HotelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelController {

    private final HotelServiceImpl hotelService;

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody HotelCreationRequest hotelDto) {
        return ResponseEntity.ok(hotelService.createHotel(hotelDto));
    }

    @GetMapping
    public ResponseEntity<List<HotelResponse>> getHotels() {
        return ResponseEntity.ok(hotelService.getHotels());
    }


}