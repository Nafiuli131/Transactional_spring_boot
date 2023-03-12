package com.example.trasactionalspringboot.repository;

import com.example.trasactionalspringboot.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
