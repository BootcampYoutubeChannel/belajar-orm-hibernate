package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class MappedSuperclassKendaraanEntity {

    @Column(name = "nama", length = 50)
    private String nama;
    @Column(name = "jumlah_roda", length = 2)
    private Integer jumlahRoda;
    @Column(name = "jumlah_cylinder", length = 3)
    private Integer jumlahCylinder;
    @Column(name = "cc", length = 4)
    private Integer cc;
    @Column(name = "nama_pabrikan", nullable = false, length = 50)
    private String namaPabrikan;
}
