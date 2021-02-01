package com.maryanto.dimas.bootcamp.hibernate.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AggregationModel {

    private Long countFunction;
    private Double avgFunction;
    private BigDecimal minFunction;
    private BigDecimal maxFunction;
    private BigDecimal sumFunction;
}
