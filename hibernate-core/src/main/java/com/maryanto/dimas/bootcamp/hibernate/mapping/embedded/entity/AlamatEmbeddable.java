package com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AlamatEmbeddable {

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
    private String kodePos;
    @Column(name = "nama_jalan", length = 100)
    private String namaJalan;
}
