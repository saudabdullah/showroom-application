package com.car.showroom.cars.controller;

import com.car.showroom.cars.DTO.request.CarRequestDTO;
import com.car.showroom.cars.DTO.response.CarShowroomsResponse;
import com.car.showroom.cars.service.CarsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarsController {
    private final Logger log = LoggerFactory.getLogger(CarsController.class);
    private final CarsService carsService;

    @PostMapping
    public ResponseEntity<HttpEntity> createCar(@RequestBody @Valid CarRequestDTO carRequestDTO){

        log.info("received request to create new car");
        carsService.saveCar(carRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<CarShowroomsResponse>> getCarsShowRooms( @RequestParam(required = false) String maker,
                                                                        @RequestParam(required = false) String model,
                                                                        @RequestParam(required = false, defaultValue = "0") int modelYear,
                                                                        @RequestParam(required = false) String showRoomName,
                                                                        @RequestParam(required = false) String vin,
                                                                        @RequestParam(required = false, defaultValue = "0") double price,
                                                                        @RequestParam(required = false, defaultValue = "0") int page,
                                                                        @RequestParam(required = false, defaultValue = "10") int size){

        return new ResponseEntity<>(carsService.getCarsList(showRoomName,maker,model,vin,modelYear,price,size,page),HttpStatus.OK);
    }
}
