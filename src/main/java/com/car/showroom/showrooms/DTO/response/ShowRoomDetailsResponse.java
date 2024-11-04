package com.car.showroom.showrooms.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowRoomDetailsResponse {

    private String name;
    private long commercialRegistrationNumber;
    private String mangerName;
    private long contactNumber;
    private String address;
}
