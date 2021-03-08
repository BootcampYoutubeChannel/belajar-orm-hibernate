package com.maryanto.dimas.bootcamp.entity.hr;

import com.maryanto.dimas.bootcamp.entity.regions.District;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.jpamodelgen.xml.jaxb.EmptyType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_addresses", schema = "hr")
public class EmployeeAddress {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    private String id;
    @ManyToOne
    @JoinColumn(name = "district_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private District district;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private Employee employee;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AddressType type;
}
