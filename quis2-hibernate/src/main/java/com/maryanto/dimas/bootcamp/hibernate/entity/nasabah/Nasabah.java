package com.maryanto.dimas.bootcamp.hibernate.entity.nasabah;

import com.maryanto.dimas.bootcamp.hibernate.entity.wilayah.Kecamatan;
import com.maryanto.dimas.bootcamp.hibernate.entity.wilayah.Kelurahan;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "nasabah", schema = "nasabah")
@GenericGenerator(name = "uuid2_gen", strategy = "uuid2")
@Inheritance(strategy = InheritanceType.JOINED)
public class Nasabah {

    @Id
    @GeneratedValue(generator = "uuid2_gen")
    private String id;
    @Column(name = "nama_kepemilikan")
    private String namaKepemilikan;
    private String cif;
    @Column(name = "no_identitas")
    private String noIdentitas;
    @FieldNameConstants.Exclude
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kelurahan_id")
    private Kelurahan kelurahan;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;
    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdatedDate;
}
