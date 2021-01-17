package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "motor", schema = "mapped_superclass")
@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
public class MappedSuperclassMotorEntity extends MappedSuperclassKendaraanEntity {

    @Id
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", length = 64)
    private String id;

    @Column(name = "jenis_rantai")
    private String jenisRantai;
}
