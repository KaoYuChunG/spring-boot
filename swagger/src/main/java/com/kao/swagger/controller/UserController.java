package com.kao.swagger.controller;


import com.kao.swagger.common.ApiResponse;
import com.kao.swagger.common.DataType;
import com.kao.swagger.common.ParamType;
import com.kao.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "1.0.0-SNAPSHOT", value = "controller")
@Slf4j
public class UserController {

    @GetMapping
    @ApiOperation(value = "條件查詢（DONE）", notes = "備註")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "name", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "kao")})
    public ApiResponse<User> getByUserName(String username) {
        log.info("多个參數用  @ApiImplicitParams");
        return ApiResponse.<User>builder().code(200)
                .message("success")
                .data(new User(1, username, "JAVA"))
                .build();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "主鍵查詢（DONE）", notes = "備註")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用戶編號", dataType = DataType.INT, paramType = ParamType.PATH)})
    public ApiResponse<User> get(@PathVariable Integer id) {
        log.info("單個參數用  @ApiImplicitParam");
        return ApiResponse.<User>builder().code(200)
                .message("操作成功")
                .data(new User(id, "u1", "p1"))
                .build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "刪除用戶（DONE）", notes = "備註")
    @ApiImplicitParam(name = "id", value = "用戶編號", dataType = DataType.INT, paramType = ParamType.PATH)
    public void delete(@PathVariable Integer id) {
        log.info("單個參數用 ApiImplicitParam");
    }

    @PostMapping
    @ApiOperation(value = "添加用戶（DONE）")
    public User post(@RequestBody User user) {
        log.info("如果是 POST PUT 就帶 @RequestBody 的可以不用寫 @ApiImplicitParam");
        return user;
    }

    @PostMapping("/multipar")
    @ApiOperation(value = "添加用戶（DONE）")
    public List<User> multipar(@RequestBody List<User> user) {
        log.info("如果是 POST PUT 就帶 @RequestBody 的可以不用寫 @ApiImplicitParam");

        return user;
    }

    @PostMapping("/array")
    @ApiOperation(value = "添加用戶（DONE）")
    public User[] array(@RequestBody User[] user) {
        log.info("如果是 POST PUT 就帶 @RequestBody 的可以不用寫 @ApiImplicitParam");
        return user;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改用戶（DONE）")
    public void put(@PathVariable Long id, @RequestBody User user) {
        log.info("如果不想寫 @ApiImplicitParam 那麼 swagger 也會使用默認的參數名作為描述信息 ");
    }

    @PostMapping("/{id}/file")
    @ApiOperation(value = "文件上傳（DONE）")
    public String file(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        log.info(file.getContentType());
        log.info(file.getName());
        log.info(file.getOriginalFilename());
        return file.getOriginalFilename();
    }
}
