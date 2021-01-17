package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class SingleTableMotorEntity extends SingleTableKendaraanEntity{

    @Column(name = "jenis_rantai")
    private String jenisRantai;

}
