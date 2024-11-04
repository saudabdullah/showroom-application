package com.car.showroom.exception;

public class ShowRoomNotFound extends CodedException{
    public ShowRoomNotFound(ErrorCode code) {
        super(code);
    }
}
