package com.kao.elasticsearchhighlevel.common;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1696194043024336235L;

    private int errcode;

    private String errmsg;

    private T data;

    public Result() {
    }

    private Result(ResultCode resultCode) {
        this(resultCode.code, resultCode.msg);
    }

    private Result(ResultCode resultCode, T data) {
        this(resultCode.code, resultCode.msg, data);
    }

    private Result(int errcode, String errmsg) {
        this(errcode, errmsg, null);
    }

    private Result(int errcode, String errmsg, T data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(@Nullable T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

}
