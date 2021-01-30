package com.kao.exception.controller;

import com.kao.exception.constant.Status;
import com.kao.exception.exception.JsonException;
import com.kao.exception.model.ApiResponse;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonException() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView pageException() {
        throw new ParseException(Status.UNKNOWN_ERROR);
    }
}
