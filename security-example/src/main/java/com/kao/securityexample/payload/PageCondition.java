package com.kao.securityexample.payload;

import lombok.Data;

/**
 * 分页请求参数
 */
@Data
public class PageCondition {
    /**
     * 当前页码
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageSize;

}
