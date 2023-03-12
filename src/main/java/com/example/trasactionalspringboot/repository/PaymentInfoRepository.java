package com.example.trasactionalspringboot.repository;

import com.example.trasactionalspringboot.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}
