package com.maryanto.dimas.bootcamp.hibernate.entity.transaksi;

import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.Nasabah;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rekening_tabungan", schema = "transaksi")
@GenericGenerator(name = "uuid2_gen", strategy = "uuid2")
public class RekeningTabungan {

    @Id
    @GeneratedValue(generator = "uuid2_gen")
    @Column(name = "id")
    private String id;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produk_id")
    private ProdukTabungan produk;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nasabah_id")
    private Nasabah nasabah;
    @Column(name = "suku_bunga")
    private Float sukuBunga;
    @Column(name = "biaya_admin")
    private BigDecimal biayaAdmin;
    @Column(name = "saldo_current")
    private BigDecimal saldoCurrent;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;
    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdatedDate;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @OneToMany(mappedBy = "rekening")
    private List<TransaksiTabungan> listTransaksi = new ArrayList<>();
}
