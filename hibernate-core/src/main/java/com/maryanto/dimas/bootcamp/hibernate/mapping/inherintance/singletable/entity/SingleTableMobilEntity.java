package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class SingleTableMobilEntity extends SingleTableKendaraanEntity {

    @Column(name = "jumlah_kursi", length = 1)
    private Integer jumlahKursi;

    @Column(name = "is_all_wheel_drive")
    private boolean allWheelDrive;
}
