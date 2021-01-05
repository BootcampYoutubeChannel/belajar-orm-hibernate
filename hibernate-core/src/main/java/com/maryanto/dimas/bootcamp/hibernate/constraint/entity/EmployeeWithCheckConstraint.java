package com.maryanto.dimas.bootcamp.hibernate.constraint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "employee_check",
        schema = "macam_constraint"
)
public class EmployeeWithCheckConstraint {

    @Id
    @Column(name = "kode")
    private String id;
    @Column(name = "nama", length = 10)
    private String name;
    @Column(name = "gaji", columnDefinition = "decimal check(gaji >= 2000000)")
    private BigDecimal salary;
    @Column(name = "created_by", length = 100, nullable = false)
    private String createdBy;
    @Column(name = "created_datetime", nullable = false)
    private LocalDateTime createdDateTime;
    @Column(name = "last_updated_by", length = 100)
    private String lastUpdateBy;
    @Column(name = "last_updated_datetime")
    private LocalDateTime lastUpdatedBy;
}
