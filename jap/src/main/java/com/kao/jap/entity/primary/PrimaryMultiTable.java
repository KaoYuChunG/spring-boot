package com.kao.jpa.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "multi_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrimaryMultiTable {

    @Id
    private Long id;
    private String name;
}
