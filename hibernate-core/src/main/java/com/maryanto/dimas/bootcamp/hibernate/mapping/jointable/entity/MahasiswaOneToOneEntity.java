package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mahasiswa_onetoone", schema = "jointable")
@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
public class MahasiswaOneToOneEntity {

    @Id
    @GeneratedValue(generator = "uuid_gen")
    private String id;
    @Column(name = "nim", length = 8, nullable = false, unique = true)
    private String nim;
    @Column(name = "nama", length = 50, nullable = false)
    private String nama;
    @Column(name = "tanggal_lahir", nullable = false)
    private LocalDate tanggalLahir;
    @Column(name = "tahun_masuk", length = 4, nullable = false)
    private Integer tahunMasuk;
    @OneToOne
    @JoinColumn(name = "alamat_id", nullable = false, unique = true)
    private AlamatOneToOneEntity alamat;
}
