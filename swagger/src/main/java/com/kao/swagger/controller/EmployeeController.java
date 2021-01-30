package com.kao.swagger.controller;

import com.kao.swagger.common.ApiResponse;
import com.kao.swagger.common.DataType;
import com.kao.swagger.common.ParamType;
import com.kao.swagger.entity.Employee;
import com.kao.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Api(tags = "1.0.0-SNAPSHOT", value = "controller")
@Slf4j
public class EmployeeController {

    @GetMapping
    @ApiOperation(value = "條件查詢（DONE）", notes = "備註")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "name", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "kao")})
    public ApiResponse<Employee> getByEmployeeName(String username) {
        log.info("多个參數用  @ApiImplicitParams");
        return ApiResponse.<Employee>builder().code(200)
                .message("success")
                .data(new Employee(1, username, "Manager"))
                .build();
    }
}
