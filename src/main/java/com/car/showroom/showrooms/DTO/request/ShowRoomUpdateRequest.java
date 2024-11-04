package com.car.showroom.showrooms.DTO.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ShowRoomUpdateRequest {

    @Size(max = 100)
    private String mangerName;
    @Max(value = 15)
    private long contactNumber = -1;
    @Size(max = 255)
    private String address;
}
