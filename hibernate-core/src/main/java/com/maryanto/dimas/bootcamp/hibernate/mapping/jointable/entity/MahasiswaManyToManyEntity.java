package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mahasiswa_manytomany", schema = "jointable")
public class MahasiswaManyToManyEntity {

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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mahasiswa_ambil_matakuliah", schema = "jointable",
            joinColumns = @JoinColumn(name = "mahasiswa_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "matakuliah_id", nullable = false),
            foreignKey = @ForeignKey(name = "fk_mahasiswa_kuliah_mahasiswa_id"),
            inverseForeignKey = @ForeignKey(name = "fk_mahasiswa_kuliah_matakuliah_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private Set<MatakuliahManyToManyEntity> listMatakuliah = new HashSet<>();
}
