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
@Table(name = "motor", schema = "inherintance_jointable")
@PrimaryKeyJoinColumn(
        name = "kendaraan_id",
        foreignKey = @ForeignKey(name = "fk_kendaraan_motor_id")
)
public class JoinTableMotorEntity extends JoinTableKendaraanEntity{

    @Column(name = "jenis_rantai")
    private String jenisRantai;

}
