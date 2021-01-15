package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mahasiswa_manytoone", schema = "jointable")
public class MahasiswaManyToOneEntity {

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
    @ManyToOne
    @JoinColumn(name = "kelas_id", nullable = false)
    private KelasManyToOneEntity kelas;

}
