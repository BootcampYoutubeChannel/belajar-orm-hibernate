package com.maryanto.dimas.bootcamp.hibernate.entity.wilayah;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kelurahan", schema = "wilayah")
@GenericGenerator(name = "uuid2_gen", strategy = "uuid2")
public class Kelurahan {

    @Id
    @GeneratedValue(generator = "uuid2_gen")
    private String id;
    private Long kode;
    private String nama;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kecamatan_id")
    private Kecamatan kecamatan;
}
