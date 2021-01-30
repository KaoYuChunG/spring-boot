package com.kao.swagger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "user", description = "User Entity")
public class User implements Serializable {

    private static final long serialVersionUID = 5057954049311281252L;

    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "name", required = true)
    private String name;

    @ApiModelProperty(value = "job", required = true)
    private String job;
}
