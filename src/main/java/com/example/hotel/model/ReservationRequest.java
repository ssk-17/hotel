package com.example.hotel.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReservationRequest {
    @NotBlank
    private String hotelName;

    @NotNull
    private Integer roomNumber;
}
