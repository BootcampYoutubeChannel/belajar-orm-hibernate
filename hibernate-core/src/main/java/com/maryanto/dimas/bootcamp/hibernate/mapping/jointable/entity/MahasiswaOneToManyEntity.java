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
@Table(name = "mahasiswa_onetomany", schema = "jointable")
public class MahasiswaOneToManyEntity {

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
    @OneToMany
    @JoinTable(
            name = "mahasiswa_onetomany_alamat_list",
            schema = "jointable",
            joinColumns = @JoinColumn(name = "mahasiswa_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "alamat_id", nullable = false),
            foreignKey = @ForeignKey(name = "fk_mahasiswa_id"),
            inverseForeignKey = @ForeignKey(name = "fk_alamat_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private List<AlamatOneToManyEntity> listAlamat = new ArrayList<>();
}
