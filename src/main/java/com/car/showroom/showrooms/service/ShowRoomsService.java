package com.car.showroom.showrooms.service;

import com.car.showroom.showrooms.DTO.request.ShowRoomRequestDTO;
import com.car.showroom.showrooms.DTO.request.ShowRoomUpdateRequest;
import com.car.showroom.showrooms.DTO.response.ShowRoomDetailsResponse;
import com.car.showroom.showrooms.DTO.response.ShowroomsResponseDTO;
import org.springframework.data.domain.Page;

public interface ShowRoomsService {

   public void saveShowRoom(ShowRoomRequestDTO showRoomRequestDTO);
   public Page<ShowroomsResponseDTO> getActiveShowRooms(int size , int page, String sortBy, String sortDir);

   public ShowRoomDetailsResponse getShowroom(long commercialRegistrationNumber);

   public void updateShowRoom(ShowRoomUpdateRequest showRoomUpdateRequest,long commercialRegistrationNumber);

   public void deleteShowRoom(long commercialRegistrationNumber);

}
