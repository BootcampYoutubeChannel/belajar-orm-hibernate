package com.maryanto.dimas.bootcamp.hibernate.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArithmeticModel {

    private String id;
    private String nama;
    private BigDecimal salarySetahun;
    private BigDecimal salaryPlusBonus;
}
