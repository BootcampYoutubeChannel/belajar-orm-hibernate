package com.maryanto.dimas.bootcamp.hibernate.simple.entity.master;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mhs", schema = "simple")
public class Mahasiswa {

    @Id
    private Long kode;
    @Column(name = "nim_mahasiswa", nullable = false, unique = true, length = 8)
    private String nim;
    @Column(name = "nama_mahasiswa", nullable = false, length = 25)
    private String nama;
    @Column(name = "tahun_masuk", length = 4)
    private Integer thnMasuk;
    @Column(name = "tanggal_lahir", nullable = false)
    private LocalDate tglLahir;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "is_active")
    private Boolean active;
    @Type(type = "text")
    @Column(name = "bio")
    private String biodata;
}
