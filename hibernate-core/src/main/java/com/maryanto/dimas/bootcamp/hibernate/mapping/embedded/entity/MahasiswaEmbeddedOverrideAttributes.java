package com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mahasiswa_override_att", schema = "embedded")
public class MahasiswaEmbeddedOverrideAttributes {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nim", length = 8, nullable = false, unique = true)
    private String nim;
    @Column(name = "nama", length = 50, nullable = false)
    private String nama;
    @Column(name = "tanggal_lahir", nullable = false)
    private LocalDate tanggalLahir;
    @Column(name = "tahun_masuk", length = 4, nullable = false)
    private Integer tahunMasuk;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "provinsi",
                    column = @Column(name = "rumah_provinsi", length = 50, nullable = false)),
            @AttributeOverride(name = "kota",
                    column = @Column(name = "rumah_kota", length = 50, nullable = false)),
            @AttributeOverride(name = "kelurahan",
                    column = @Column(name = "rumah_kelurahan", length = 100, nullable = false)),
            @AttributeOverride(name = "kecamatan",
                    column = @Column(name = "rumah_kecamatan", length = 100, nullable = false)),
            @AttributeOverride(name = "rw",
                    column = @Column(name = "rumah_rw", length = 3, nullable = false)),
            @AttributeOverride(name = "rt",
                    column = @Column(name = "rumah_rt", length = 3, nullable = false)),
            @AttributeOverride(name = "kodePos",
                    column = @Column(name = "rumah_kode_pos", length = 6, nullable = false)),
            @AttributeOverride(name = "namaJalan",
                    column = @Column(name = "rumah_jalan", length = 100)),

    })
    private AlamatEmbeddable alamatRumah;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "provinsi",
                    column = @Column(name = "ortu_provinsi", length = 50)),
            @AttributeOverride(name = "kota",
                    column = @Column(name = "ortu_kota", length = 50)),
            @AttributeOverride(name = "kelurahan",
                    column = @Column(name = "ortu_kelurahan", length = 100)),
            @AttributeOverride(name = "kecamatan",
                    column = @Column(name = "ortu_kecamatan", length = 100)),
            @AttributeOverride(name = "rw",
                    column = @Column(name = "ortu_rw", length = 3)),
            @AttributeOverride(name = "rt",
                    column = @Column(name = "ortu_rt", length = 3)),
            @AttributeOverride(name = "kodePos",
                    column = @Column(name = "ortu_kode_pos", length = 6)),
            @AttributeOverride(name = "namaJalan",
                    column = @Column(name = "ortu_jalan", length = 100)),

    })
    private AlamatEmbeddable alamatOrangtua;
}
