package com.example.hotel.service;

import com.example.hotel.model.ReservationRequest;
import org.springframework.http.ResponseEntity;

public interface HotelService {
    ResponseEntity<Boolean> reserve(ReservationRequest reservationRequest);
}
