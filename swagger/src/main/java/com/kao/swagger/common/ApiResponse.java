package com.kao.swagger.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 通用API接口返回
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "return interface of PI", description = "Common Api Response")
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -8987146499044811408L;
    /**
     * 通用返回狀態
     */
    @ApiModelProperty(value = "return status", required = true)
    private Integer code;
    /**
     * 通用返回信息
     */
    @ApiModelProperty(value = "return information", required = true)
    private String message;
    /**
     * 通用返回數據
     */
    @ApiModelProperty(value = "return data", required = true)
    private T data;
}
