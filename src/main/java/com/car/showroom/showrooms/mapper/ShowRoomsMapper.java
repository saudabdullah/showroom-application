package com.car.showroom.showrooms.mapper;

import com.car.showroom.showrooms.DTO.request.ShowRoomRequestDTO;
import com.car.showroom.showrooms.DTO.response.ShowRoomDetailsResponse;
import com.car.showroom.showrooms.DTO.response.ShowroomsResponseDTO;
import com.car.showroom.showrooms.entity.ShowRooms;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShowRoomsMapper {
    @Mapping(source = "commercialRegistrationNumber",target = "commercialRegistrationNumber")
    ShowRooms mapToShowRoomsEntity(ShowRoomRequestDTO showRoomRequestDTO);

    ShowroomsResponseDTO toShowRoomsDTO(ShowRooms showRooms);

    ShowRoomDetailsResponse toShowRoomDetails(ShowRooms showRooms);


}
