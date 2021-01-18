package com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity;


import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees", schema = "parentchild")
@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
public class ParentChildEmployeeEntity {

    @Id
    @GeneratedValue(generator = "uuid_gen")
    private String id;
    @Column(name = "full_name", length = 50)
    private String name;
    @Column(name = "street_address", length = 100)
    private String address;
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
    @Column(name = "job_id", nullable = false)
    private String job;
    @ManyToOne
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "fk_employee_manager_id"))
    @FieldNameConstants.Exclude
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ParentChildEmployeeEntity manager;
    @OneToMany(mappedBy = "manager")
    @FieldNameConstants.Exclude
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ParentChildEmployeeEntity> employees = new HashSet<>();
}
