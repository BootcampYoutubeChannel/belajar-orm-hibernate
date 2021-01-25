package com.maryanto.dimas.bootcamp.hibernate.entity.transaksi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "produk_tabungan", schema = "transaksi")
@GenericGenerator(name = "uuid2_gen", strategy = "uuid2")
public class ProdukTabungan {

    @Id
    @GeneratedValue(generator = "uuid2_gen")
    @Column(name = "id")
    private String id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "min_setoran_awal")
    private BigDecimal minSetoranAwal;
    @Column(name = "suku_bunga")
    private Float sukuBunga;
    @Column(name = "biaya_admin")
    private BigDecimal biayaAdmin;
}
