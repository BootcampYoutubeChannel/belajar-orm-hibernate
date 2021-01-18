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
@Table(name = "mobil", schema = "inherintance_tableperclass")
public class TablePerClassMobilEntity extends TablePerClassKendaraanEntity {

    @Column(name = "jumlah_kursi", length = 1)
    private Integer jumlahKursi;

    @Column(name = "is_all_wheel_drive")
    private boolean allWheelDrive;
}
