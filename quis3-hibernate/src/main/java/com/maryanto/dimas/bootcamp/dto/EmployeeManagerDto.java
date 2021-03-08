package com.maryanto.dimas.bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeManagerDto {

    private String kodeKaryawan;
    private String namaKaryawan;
    private String namaBagian;
    private String namaManager;
    private String namaJabatan;
}
