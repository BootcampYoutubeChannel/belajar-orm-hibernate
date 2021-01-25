package com.maryanto.dimas.bootcamp.hibernate.entity.nasabah;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "nasabah_perorangan", schema = "nasabah")
@GenericGenerator(name = "uuid2_gen", strategy = "uuid2")
@PrimaryKeyJoinColumn(name = "nasabah_id")
public class NasabahPerorangan extends Nasabah {

    @Column(name = "nama_ibu_kandung")
    private String namaIbuKandung;
    @Column(name = "tanggal_lahir")
    private LocalDate tanggalLahir;
    @Column(name = "no_telp")
    private String noTelp;
}
