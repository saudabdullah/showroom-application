package com.car.showroom.exception;

import lombok.Getter;

public enum ErrorCode {
    SHOWROOM_NOT_FOUND("showroom not found");
    @Getter
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    String getCode() {
        return this.name();
    }

    @Override
    public String toString() {
        return "ErrorCode{" + "code='" + message + '\'' + '}';
    }
}
