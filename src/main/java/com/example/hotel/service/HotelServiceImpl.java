package com.example.hotel.service;

import com.example.hotel.model.ReservationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class HotelServiceImpl implements HotelService {

    Map<String, Set<Integer>> reservedHotelRooms = new HashMap<>();

    @Override
    public ResponseEntity<Boolean> reserve(ReservationRequest reservationRequest) {
        String unifiedHotelName = unifiedHotel(reservationRequest.getHotelName());
        int roomNumber = reservationRequest.getRoomNumber();
        Set<Integer> reservedRooms;
        if (reservedHotelRooms.containsKey(unifiedHotelName)) {
            reservedRooms = reservedHotelRooms.get(unifiedHotelName);
            if (reservedRooms.contains(roomNumber))
                return ResponseEntity.status(HttpStatus.CONFLICT).body(false);
            reservedRooms.add(roomNumber);
        } else {
            reservedRooms = new HashSet<>();
            reservedRooms.add(roomNumber);
            reservedHotelRooms.put(unifiedHotelName, reservedRooms);
        }
        return ResponseEntity.ok(true);
    }

    private String unifiedHotel(String hotelName) {
        hotelName = hotelName.toLowerCase();
        hotelName = hotelName.trim();

        return hotelName;
    }
}
