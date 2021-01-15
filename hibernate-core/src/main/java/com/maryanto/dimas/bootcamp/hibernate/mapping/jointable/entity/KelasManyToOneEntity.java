package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "kelas_manytoone", schema = "jointable")
@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
public class KelasManyToOneEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid_gen")
    private String id;
    @Column(name = "nama_kelas", nullable = false)
    private String nama;
    @Column(name = "tahun_angkatan", nullable = false)
    private Integer angkatan;
    @Column(name = "program_studi")
    private String programStudi;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @OneToMany(mappedBy = "kelas")
    private List<MahasiswaManyToOneEntity> listMahasiswa = new ArrayList<>();
}
