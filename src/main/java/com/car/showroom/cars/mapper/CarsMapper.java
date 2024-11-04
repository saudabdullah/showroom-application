package com.car.showroom.cars.mapper;

import com.car.showroom.cars.DTO.request.CarRequestDTO;
import com.car.showroom.cars.DTO.response.CarShowroomsResponse;
import com.car.showroom.cars.entity.Cars;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface CarsMapper {
    @Mapping(source = "vin" , target = "vin")
    Cars mapToCarsEntity(CarRequestDTO carRequestDTO);

    @Mapping(source = "showRoom.name",target = "ShowRoomName")
    @Mapping(source = "showRoom.contactNumber",target = "contactNumber")
    CarShowroomsResponse mapToDto(Cars Cars);
}
