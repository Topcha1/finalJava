package com.exam.repositories;


import com.exam.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelsRepo extends JpaRepository<HotelEntity, Long> {
}
