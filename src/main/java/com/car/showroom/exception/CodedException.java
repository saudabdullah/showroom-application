package com.car.showroom.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class CodedException extends RuntimeException {

    @Getter
    private final ErrorCode code;
    @Getter
    private final HttpStatus httpStatus;

    @Override
    public String getMessage() {
        return getCode().getMessage();
    }

    public CodedException(ErrorCode code) {
        this(code, HttpStatus.BAD_REQUEST);
    }

}
