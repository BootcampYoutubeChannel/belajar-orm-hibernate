package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "alamat", schema = "jointable")
@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
public class AlamatOneToOneEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid_gen")
    private String id;
    @Column(name = "provinsi", length = 50)
    private String provinsi;
    @Column(name = "kota", length = 50)
    private String kota;
    @Column(name = "kelurahan", length = 100)
    private String kelurahan;
    @Column(name = "kecamatan", length = 100)
    private String kecamatan;
    @Column(name = "rw", length = 3)
    private Integer rw;
    @Column(name = "rt", length = 3)
    private Integer rt;
    @Column(name = "kode_pos", length = 6)
    private Integer kodePos;
    @Column(name = "nama_jalan", length = 100)
    private String namaJalan;
}
