package com.exam.controllers;


import com.exam.dtos.request.RoomCreationRequest;
import com.exam.dtos.response.RoomResponse;
import com.exam.services.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomServiceImpl roomService;

    @PostMapping
    public ResponseEntity<RoomResponse> createHotel(@RequestBody RoomCreationRequest request, @RequestParam Long hotelId) {
        return ResponseEntity.ok(roomService.createRoom(request, hotelId));
    }

    @GetMapping("/free")
    public ResponseEntity<List<RoomResponse>> getFreeRooms() {
        return ResponseEntity.ok(roomService.getFreeRooms());
    }

    @GetMapping("/occupied")
    public ResponseEntity<List<RoomResponse>> getOccupiedRooms() {
        return ResponseEntity.ok(roomService.getOccupiedRooms());
    }

    @GetMapping("/free/{hotelId}")
    public ResponseEntity<List<RoomResponse>> getFreeRoomsFromHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getFreeRoomsFromHotel(hotelId));
    }

}
