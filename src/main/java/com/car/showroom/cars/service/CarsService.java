package com.car.showroom.cars.service;

import com.car.showroom.cars.DTO.request.CarRequestDTO;
import com.car.showroom.cars.DTO.response.CarShowroomsResponse;
import org.springframework.data.domain.Page;

public interface CarsService {

    public void saveCar(CarRequestDTO carRequestDTO);
    public Page<CarShowroomsResponse> getCarsList(String showRoomName, String maker, String model, String vin, int modelYear, double price, int size, int page);
}
