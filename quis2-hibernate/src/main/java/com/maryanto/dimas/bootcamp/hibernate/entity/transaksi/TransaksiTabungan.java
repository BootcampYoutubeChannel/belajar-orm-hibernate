package com.maryanto.dimas.bootcamp.hibernate.entity.transaksi;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transaksi_tabungan", schema = "transaksi")
@GenericGenerator(name = "uuid2_gen", strategy = "uuid2")
public class TransaksiTabungan {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2_gen")
    private String id;
    @Column(name = "tanggal")
    private LocalDateTime tanggal;
    @Column(name = "debit")
    private BigDecimal debit;
    @Column(name = "kredit")
    private BigDecimal kredit;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @FieldNameConstants.Exclude
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rekening_id")
    private RekeningTabungan rekening;
}
