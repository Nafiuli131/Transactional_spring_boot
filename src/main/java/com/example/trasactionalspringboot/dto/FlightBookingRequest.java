package com.example.trasactionalspringboot.dto;

import com.example.trasactionalspringboot.entity.PassengerInfo;
import com.example.trasactionalspringboot.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
