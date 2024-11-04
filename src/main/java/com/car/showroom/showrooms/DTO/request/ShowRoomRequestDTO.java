package com.car.showroom.showrooms.DTO.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShowRoomRequestDTO {
    @NotBlank
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Max(value = 10)
    private long commercialRegistrationNumber;
    @Size(max = 100)
    private String mangerName;
    @NotNull
    @Max(value = 15)
    private long contactNumber;
    @Size(max = 255)
    private String address;
}
