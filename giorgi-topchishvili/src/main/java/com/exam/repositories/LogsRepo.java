package com.exam.repositories;


import com.exam.entities.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepo extends JpaRepository<LogEntity, Long> {
}
