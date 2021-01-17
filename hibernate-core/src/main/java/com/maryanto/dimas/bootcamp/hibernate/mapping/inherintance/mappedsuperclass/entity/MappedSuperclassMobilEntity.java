package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "mobil", schema = "mapped_superclass")
@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
public class MappedSuperclassMobilEntity extends MappedSuperclassKendaraanEntity {

    @Id
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", length = 64)
    private String id;

    @Column(name = "jumlah_kursi", length = 1)
    private Integer jumlahKursi;

    @Column(name = "is_all_wheel_drive", nullable = false)
    private boolean allWheelDrive;
}
