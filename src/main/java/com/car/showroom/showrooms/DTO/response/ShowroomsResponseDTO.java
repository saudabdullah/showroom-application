package com.car.showroom.showrooms.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowroomsResponseDTO {

    private String name;
    private long commercialRegistrationNumber;
    private long contactNumber;
}
