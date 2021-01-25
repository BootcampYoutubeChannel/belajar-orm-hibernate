package com.maryanto.dimas.bootcamp.hibernate.entity.wilayah;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "provinsi", schema = "wilayah")
@GenericGenerator(name = "uuid2_gen", strategy = "uuid2")
public class Provinsi {

    @Id
    @GeneratedValue(generator = "uuid2_gen")
    private String id;
    private Long kode;
    private String nama;
}
