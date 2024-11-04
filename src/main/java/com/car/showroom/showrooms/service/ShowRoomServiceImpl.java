package com.car.showroom.showrooms.service;

import com.car.showroom.exception.ErrorCode;
import com.car.showroom.exception.ShowRoomNotFound;
import com.car.showroom.showrooms.DTO.request.ShowRoomRequestDTO;
import com.car.showroom.showrooms.DTO.request.ShowRoomUpdateRequest;
import com.car.showroom.showrooms.DTO.response.ShowRoomDetailsResponse;
import com.car.showroom.showrooms.DTO.response.ShowroomsResponseDTO;
import com.car.showroom.showrooms.entity.ShowRooms;
import com.car.showroom.showrooms.mapper.ShowRoomsMapper;
import com.car.showroom.showrooms.repository.ShowRoomsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowRoomServiceImpl implements ShowRoomsService {

    private final Logger log = LoggerFactory.getLogger(ShowRoomServiceImpl.class);
    private final ShowRoomsRepository showRoomsRepository;
    private final ShowRoomsMapper showRoomsMapper;

    @Override
    public void saveShowRoom(ShowRoomRequestDTO showRoomRequestDTO) {
        log.info("creating new showroom {}",showRoomRequestDTO);
        ShowRooms showRooms = showRoomsMapper.mapToShowRoomsEntity(showRoomRequestDTO);
        showRoomsRepository.save(showRooms);
        log.info("showroom created successfully");
    }

    @Override
    public Page<ShowroomsResponseDTO> getActiveShowRooms(int size, int page, String sortBy, String sortDir) {
        log.info("fetching showrooms");
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<ShowRooms> showRooms = showRoomsRepository.findByDeletedFalse(pageable);
        Page<ShowroomsResponseDTO> showroomsResponseDTOS = mapToDTOPage(showRooms);
        return showroomsResponseDTOS;
    }
    private Page<ShowroomsResponseDTO> mapToDTOPage(Page<ShowRooms> showroomPage) {
        List<ShowroomsResponseDTO> dtoList = showroomPage.getContent().stream()
                .map(showRoomsMapper::toShowRoomsDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, showroomPage.getPageable(), showroomPage.getTotalElements());
    }

    @Override
    public ShowRoomDetailsResponse getShowroom(long commercialRegistrationNumber) {
        log.info("fetching showroom");
        ShowRooms showRooms = showRoomsRepository.findByCommercialRegistrationNumber(commercialRegistrationNumber).orElseThrow(()-> new ShowRoomNotFound(ErrorCode.SHOWROOM_NOT_FOUND));
        ShowRoomDetailsResponse showRoomDetailsResponse = showRoomsMapper.toShowRoomDetails(showRooms);
        return showRoomDetailsResponse;
    }

    @Override
    public void updateShowRoom(ShowRoomUpdateRequest showRoomUpdateRequest, long commercialRegistrationNumber) {
        log.info("updating showroom");
        ShowRooms showRooms = showRoomsRepository.findByCommercialRegistrationNumber(commercialRegistrationNumber).orElseThrow(()-> new ShowRoomNotFound(ErrorCode.SHOWROOM_NOT_FOUND));
        if (showRoomUpdateRequest.getContactNumber() != -1) {
            showRooms.setContactNumber(showRoomUpdateRequest.getContactNumber());
        }
        if (showRoomUpdateRequest.getMangerName() != null) {
            showRooms.setMangerName(showRoomUpdateRequest.getMangerName());
        }
        if (showRoomUpdateRequest.getAddress() != null) {
            showRooms.setAddress(showRoomUpdateRequest.getAddress());
        }

         showRoomsRepository.save(showRooms);


    }

    @Override
    public void deleteShowRoom(long commercialRegistrationNumber) {
        log.info("deleting showroom");
        ShowRooms showRooms = showRoomsRepository.findByCommercialRegistrationNumber(commercialRegistrationNumber).orElseThrow(()-> new ShowRoomNotFound(ErrorCode.SHOWROOM_NOT_FOUND));
        showRooms.setDeleted(true);
        showRoomsRepository.save(showRooms);
    }
}
