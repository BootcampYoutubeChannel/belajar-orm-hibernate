package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "mobil", schema = "inherintance_jointable")
@PrimaryKeyJoinColumn(
        name = "kendaraan_id",
        foreignKey = @ForeignKey(name = "fk_kendaraan_mobil_id")
)
public class JoinTableMobilEntity extends JoinTableKendaraanEntity {

    @Column(name = "jumlah_kursi", length = 1)
    private Integer jumlahKursi;

    @Column(name = "is_all_wheel_drive")
    private boolean allWheelDrive;
}
