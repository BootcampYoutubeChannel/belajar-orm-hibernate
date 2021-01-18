package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "motor", schema = "inherintance_tableperclass")
public class TablePerClassMotorEntity extends TablePerClassKendaraanEntity {

    @Column(name = "jenis_rantai")
    private String jenisRantai;
}
