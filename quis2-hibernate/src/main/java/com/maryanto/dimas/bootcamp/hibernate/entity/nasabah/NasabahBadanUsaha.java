package com.maryanto.dimas.bootcamp.hibernate.entity.nasabah;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "nasabah_badan_usaha", schema = "nasabah")
@GenericGenerator(name = "uuid2_gen", strategy = "uuid2")
@PrimaryKeyJoinColumn(name = "nasabah_id")
public class NasabahBadanUsaha extends Nasabah {

    @Column(name = "no_siup")
    private String noSiup;
    @Column(name = "no_akta_terakhir")
    private String noAktaTerakhir;
    @Column(name = "no_telp")
    private String noTelp;
}
