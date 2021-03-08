package com.maryanto.dimas.bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupByDepartmentDto {

    private String departmentId;
    private String departmentName;
    private BigDecimal totalGaji;
    private Long jumlahKaryawan;
}
