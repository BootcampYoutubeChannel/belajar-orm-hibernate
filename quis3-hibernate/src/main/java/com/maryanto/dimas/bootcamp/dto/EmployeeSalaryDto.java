package com.maryanto.dimas.bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalaryDto {

    private String kodeKaryawan;
    private String namaKaryawan;
    private String namaBagian;
    private String namaJabatan;
    private String gajiSebulan;
    private String jumlahKomisi;
    private String gajiTerima;
}
