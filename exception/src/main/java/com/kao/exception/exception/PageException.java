package com.kao.exception.exception;

import com.kao.exception.constant.Status;
import lombok.Getter;

@Getter
public class PageException extends BaseException{

    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
