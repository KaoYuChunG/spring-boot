package com.kao.swagger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "employee", description = "employee Entity")
public class Employee {

    private static final long serialVersionUID = 5057954049311281251L;

    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "name", required = true)
    private String name;

    @ApiModelProperty(value = "cargo", required = true)
    private String cargo;
}
