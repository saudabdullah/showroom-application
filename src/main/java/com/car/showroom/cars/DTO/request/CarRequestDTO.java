package com.car.showroom.cars.DTO.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarRequestDTO {


    private long commercialRegistrationNumber;
    private String vin;

    private String maker;

    private String model;

    private int modelYear;

    private double price;
}
