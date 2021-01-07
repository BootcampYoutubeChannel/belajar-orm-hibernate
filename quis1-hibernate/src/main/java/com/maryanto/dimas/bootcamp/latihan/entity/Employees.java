package com.maryanto.dimas.bootcamp.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees", schema = "hrd")
@GenericGenerator(name = "employee_uuid_generator", strategy = "uuid2")
public class Employees {

    @Id
    @GeneratedValue(generator = "employee_uuid_generator")
    @Column(name = "kode", length = 64)
    private String id;

    @Column(name = "nip", length = 12, nullable = false, unique = true)
    private String nip;

    @Column(name = "nama_lengkap", length = 50, nullable = false)
    private String namaLengkap;

    @Column(name = "tanggal_lahir", nullable = false, columnDefinition = "date check(tanggal_lahir <= now())")
    private LocalDate tanggalLahir;

    @Column(name = "gaji_sebulan", nullable = false, columnDefinition = "decimal default 2000000 check(gaji_sebulan >= 2000000)")
    private BigDecimal gajiSebulan;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default false")
    private Boolean active;


}
