package com.kao.exception.model;

import com.kao.exception.constant.Status;
import com.kao.exception.exception.BaseException;
import lombok.Data;

@Data
public class ApiResponse {

    private Integer code;

    private String message;

    private Object data;

    private ApiResponse() {

    }

    private ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 構造一个自定義的API返回
     *
     * @param code    狀態碼
     * @param message 返回内容
     * @param data    返回數據
     * @return ApiResponse
     */
    public static ApiResponse of(Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }

    /**
     * 構造一个成功且带數據的API返回
     *
     * @param data 返回數據
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(Object data) {
        return ofStatus(Status.OK, data);
    }

    /**
     * 構造一个成功且自定義消息的API返回
     *
     * @param message 返回内容
     * @return ApiResponse
     */
    public static ApiResponse ofMessage(String message) {
        return of(Status.OK.getCode(), message, null);
    }

    /**
     * 構造一個有狀態的API返回
     *
     * @param status 狀態 {@link Status}
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status) {
        return ofStatus(status, null);
    }

    /**
     * 構造一個異常且带數據的API返回
     *
     * @param status 狀態 {@link Status}
     * @param data   返回數據
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status, Object data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    /**
     * 構造一個異常且带数据的API返回
     *
     * @param t    Exception
     * @param data 返回數據
     * @param <T>  {@link BaseException} 的子類
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t, Object data) {
        return of(t.getCode(), t.getMessage(), data);
    }

    /**
     * 構造一個異常且带數據的API返回
     *
     *
     * @param t   Exception
     * @param <T> {@link BaseException} 的子類
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return ofException(t, null);
    }
}
