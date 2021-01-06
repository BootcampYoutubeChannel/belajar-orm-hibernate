package com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(KeyClassRoomIdClass.class)
@Table(name = "kelas_idclass", schema = "idclass")
public class ClassRoomIdClass {

    @Id
    @Column(name = "tahun_angkatan", length = 4, columnDefinition = "int check(tahun_angkatan >= 1999)")
    private Integer year;
    @Id
    @Column(name = "class_id", length = 50)
    private String classId;
    @Column(name = "kelas_name")
    private String name;
    @Column(name = "prodi")
    private String programStudy;
    @Column(name = "description")
    private String description;
}
