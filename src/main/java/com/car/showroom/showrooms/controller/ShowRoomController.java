package com.car.showroom.showrooms.controller;

import com.car.showroom.showrooms.DTO.request.ShowRoomRequestDTO;
import com.car.showroom.showrooms.DTO.request.ShowRoomUpdateRequest;
import com.car.showroom.showrooms.DTO.response.ShowRoomDetailsResponse;
import com.car.showroom.showrooms.DTO.response.ShowroomsResponseDTO;
import com.car.showroom.showrooms.service.ShowRoomsService;
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
@RequestMapping("/showroom")
@RequiredArgsConstructor
public class ShowRoomController {

    private final ShowRoomsService showRoomsService;
    private final Logger log = LoggerFactory.getLogger(ShowRoomController.class);
    @PostMapping
    public ResponseEntity<HttpEntity> createShowRoom(@RequestBody @Valid ShowRoomRequestDTO showRoomRequestDTO){

        log.info("received request to create new showroom");
        showRoomsService.saveShowRoom(showRoomRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/active")
    public ResponseEntity<Page<ShowroomsResponseDTO>> getActiveShowrooms(@RequestParam(defaultValue = "0") int page,
                                                                         @RequestParam(defaultValue = "10") int size,
                                                                         @RequestParam(defaultValue = "id") String sortBy,
                                                                         @RequestParam(defaultValue = "asc") String sortDir){
        log.info("received request to get active showrooms");
       Page<ShowroomsResponseDTO> responseDTOS = showRoomsService.getActiveShowRooms(size,page,sortBy,sortDir);
       return new ResponseEntity<>(responseDTOS,HttpStatus.OK);
    }

    @GetMapping("/{commercialRegistrationNumber}")
    public ResponseEntity<ShowRoomDetailsResponse> getShowrooms(@PathVariable long commercialRegistrationNumber){
        log.info("received request to get showroom");
        ShowRoomDetailsResponse responseDTOS = showRoomsService.getShowroom(commercialRegistrationNumber);
        return new ResponseEntity<>(responseDTOS,HttpStatus.OK);
    }

    @PatchMapping("/{commercialRegistrationNumber}")
    public ResponseEntity<HttpEntity> updateShowrooms(@PathVariable long commercialRegistrationNumber, @RequestBody ShowRoomUpdateRequest showRoomUpdateRequest){
        log.info("received request to update showroom");
        showRoomsService.updateShowRoom(showRoomUpdateRequest,commercialRegistrationNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{commercialRegistrationNumber}")
    public ResponseEntity<HttpEntity> deleteShowrooms(@PathVariable long commercialRegistrationNumber){
        log.info("received request to delete showroom");
        showRoomsService.deleteShowRoom(commercialRegistrationNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
