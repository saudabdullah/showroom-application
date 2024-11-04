package com.car.showroom.cars.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarShowroomsResponse {

    private String vin;
    private String maker;
    private String model;
    private int modelYear;
    private double price;
    private String ShowRoomName;
    private long contactNumber;
}
