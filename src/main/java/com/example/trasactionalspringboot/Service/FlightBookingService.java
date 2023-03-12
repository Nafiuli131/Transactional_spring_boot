package com.example.trasactionalspringboot.Service;

import com.example.trasactionalspringboot.dto.FlightBookingAcknowledgement;
import com.example.trasactionalspringboot.dto.FlightBookingRequest;
import com.example.trasactionalspringboot.entity.PassengerInfo;
import com.example.trasactionalspringboot.entity.PaymentInfo;
import com.example.trasactionalspringboot.repository.PassengerInfoRepository;
import com.example.trasactionalspringboot.repository.PaymentInfoRepository;
import com.example.trasactionalspringboot.util.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Service
public class FlightBookingService {
    @Autowired
    PaymentInfoRepository paymentInfoRepository;
    @Autowired
    PassengerInfoRepository passengerInfoRepository;
    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
        FlightBookingAcknowledgement flightBookingAcknowledgement = new FlightBookingAcknowledgement();
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);
        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        flightBookingAcknowledgement.setStatus("SUCCESS");
        flightBookingAcknowledgement.setPassengerInfo(passengerInfo);
        flightBookingAcknowledgement.setPnrNo(UUID.randomUUID().toString().split("-")[0]);
        flightBookingAcknowledgement.setTotalFare(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return flightBookingAcknowledgement;
    }
}
