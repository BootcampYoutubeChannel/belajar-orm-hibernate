package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "matakuliah_manytomany", schema = "jointable")
@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
public class MatakuliahManyToManyEntity {

    @Id
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id")
    private String id;
    @Column(name = "nama_kuliah")
    private String nama;
    @Column(name = "jumlah_sks")
    private Integer sks;
    @ManyToMany(mappedBy = "listMatakuliah")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private Set<MahasiswaManyToManyEntity> listMahasiswa = new HashSet<>();
}
