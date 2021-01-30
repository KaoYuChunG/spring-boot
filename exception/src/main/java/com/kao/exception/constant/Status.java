package com.kao.exception.constant;

import lombok.Getter;

@Getter
public enum Status {

    OK(200, "success"),

    UNKNOWN_ERROR(500, "error server");

    private Integer code;

    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
