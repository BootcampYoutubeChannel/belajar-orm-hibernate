package com.maryanto.dimas.bootcamp.entity.hr;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees", schema = "hr")
public class Employee {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "job_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private Job job;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "commission_pct")
    private Float commissionPct;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private Employee manager;
    @ManyToOne
    @JoinColumn(name = "department_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private Department department;
    @Column(name = "join_date")
    private LocalDateTime joinDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EmployeeStatus status;
    @OneToMany(mappedBy = "manager")
    @FieldNameConstants.Exclude
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> employees = new HashSet<>();
    @OneToMany(mappedBy = "employee")
    private List<EmployeeAddress> addresses = new ArrayList<>();
}
