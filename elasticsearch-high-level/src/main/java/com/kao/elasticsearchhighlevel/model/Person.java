package com.kao.elasticsearchhighlevel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 8510634155374943623L;
    
    private Long id;

    private String name;

    private String country;

    private Integer age;

    private Date birthday;

    private String remark;
}
