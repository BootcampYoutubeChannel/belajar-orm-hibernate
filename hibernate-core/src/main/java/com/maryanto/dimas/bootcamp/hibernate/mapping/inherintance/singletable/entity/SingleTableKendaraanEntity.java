package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "kendraan", schema = "singletable")
@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SingleTableKendaraanEntity {

    @Id
    @GeneratedValue(generator = "uuid_gen")
    private String id;
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
