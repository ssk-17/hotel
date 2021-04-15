package com.example.hotel.resource;

import com.example.hotel.model.ReservationRequest;
import com.example.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class HotelResource {

    private HotelService hotelService;

    @Autowired
    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("reservation")
    public ResponseEntity<Boolean> reserve(@Valid @RequestBody @NotNull
                                                   ReservationRequest reservationRequest) {
        return hotelService.reserve(reservationRequest);
    }
}
