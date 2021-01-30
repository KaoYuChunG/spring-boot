package com.kao.jpa.entity.second;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "multi_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecondMultiTable {

    @Id
    private Long id;
    private String name;
}
