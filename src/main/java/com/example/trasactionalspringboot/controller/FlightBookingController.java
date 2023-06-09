package com.example.trasactionalspringboot.controller;

import com.example.trasactionalspringboot.Service.FlightBookingService;
import com.example.trasactionalspringboot.dto.FlightBookingAcknowledgement;
import com.example.trasactionalspringboot.dto.FlightBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FlightBookingController {
    @Autowired
    private FlightBookingService service;


    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
        return service.bookFlightTicket(request);
    }


}
