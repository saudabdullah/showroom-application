package com.car.showroom.cars.service;

import com.car.showroom.cars.DTO.request.CarRequestDTO;
import com.car.showroom.cars.DTO.response.CarShowroomsResponse;
import com.car.showroom.cars.components.CarSpecification;
import com.car.showroom.cars.entity.Cars;
import com.car.showroom.cars.mapper.CarsMapper;
import com.car.showroom.cars.repository.CarsRepository;
import com.car.showroom.exception.ErrorCode;
import com.car.showroom.exception.ShowRoomNotFound;
import com.car.showroom.showrooms.DTO.response.ShowroomsResponseDTO;
import com.car.showroom.showrooms.entity.ShowRooms;
import com.car.showroom.showrooms.repository.ShowRoomsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarsServiceImpl implements CarsService {
    private final Logger log = LoggerFactory.getLogger(CarsServiceImpl.class);
    private final CarsRepository carsRepository;
    private final CarsMapper carsMapper;
    private final ShowRoomsRepository showRoomsRepository;

    @Override
    public void saveCar(CarRequestDTO carRequestDTO) {
        log.info("saving car to showroom {}",carRequestDTO);
        ShowRooms showRooms = showRoomsRepository.findByCommercialRegistrationNumber(carRequestDTO.getCommercialRegistrationNumber()).orElseThrow(()-> new ShowRoomNotFound(ErrorCode.SHOWROOM_NOT_FOUND));
        Cars cars = carsMapper.mapToCarsEntity(carRequestDTO);
        cars.setShowRoom(showRooms);
        carsRepository.save(cars);
        log.info("car saved successfully");

    }

    @Override
    public Page<CarShowroomsResponse> getCarsList(String showRoomName, String maker, String model, String vin, int modelYear, double price, int size, int page) {
        Specification<Cars> spec = Specification.where(CarSpecification.hasMaker(maker))
                .and(CarSpecification.hasModel(model))
                .and(CarSpecification.hasVin(vin))
                .and(CarSpecification.hasPrice(price))
                .and(CarSpecification.hasShowroomName(showRoomName))
                .and(CarSpecification.hasModelYear(modelYear));

        Pageable pageable = PageRequest.of(page, size);

        Page<Cars> cars = carsRepository.findAll(spec, pageable);
        Page<CarShowroomsResponse> carShowroomsResponses = mapToDTOPage(cars);
        return carShowroomsResponses;
    }

    private Page<CarShowroomsResponse> mapToDTOPage(Page<Cars> cars) {
        List<CarShowroomsResponse> dtoList = cars.getContent().stream()
                .map(carsMapper::mapToDto)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, cars.getPageable(), cars.getTotalElements());
    }

}
