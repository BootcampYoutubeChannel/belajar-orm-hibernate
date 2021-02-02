package com.maryanto.dimas.bootcamp.hibernate.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupByModel {

    private String jobName;
    private BigDecimal salary;
}
