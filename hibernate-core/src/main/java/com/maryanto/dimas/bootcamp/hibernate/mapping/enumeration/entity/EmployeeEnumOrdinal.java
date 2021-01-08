package com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_ordinal", schema = "enumeration")
public class EmployeeEnumOrdinal {

    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "employee_name", length = 25, nullable = false)
    private String name;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Enumerated
    @Column(name = "employee_status")
    private EmployeeStatus status;
}
