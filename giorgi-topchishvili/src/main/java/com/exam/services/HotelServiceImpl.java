package com.exam.services;


import com.exam.aspect.Loggable;
import com.exam.dtos.request.HotelCreationRequest;
import com.exam.dtos.response.HotelResponse;
import com.exam.entities.HotelEntity;
import com.exam.mappers.HotelMapper;
import com.exam.repositories.HotelsRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl {

    private final HotelsRepo hotelsRepo;

    @Loggable
    @Transactional
    public HotelResponse createHotel(HotelCreationRequest request) {

        HotelEntity saved = hotelsRepo.save(HotelMapper.mapRequestToEntity(request));

        return HotelMapper.mapEntityToResponse(saved);

    }

    @Loggable
    public List<HotelResponse> getHotels() {

        return hotelsRepo.findAll().stream()
                .map(HotelMapper::mapEntityToResponse)
                .toList();

    }

}
