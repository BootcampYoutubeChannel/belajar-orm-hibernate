package com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity;

import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.AlamatEmbeddable;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mahasiswa_collection_embedded", schema = "collections")
public class CollectionAsEmbeddedMahasiswa {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nim")
    private String nim;
    @Column(name = "nama", nullable = false)
    private String name;
    @ElementCollection
    @CollectionTable(
            name = "mahasiswa_address",
            schema = "collections",
            joinColumns = @JoinColumn(name = "mahasiswa_id", nullable = false),
            foreignKey = @ForeignKey(name = "fk_address_mahasiswa_id")
    )
    @AttributeOverrides(value = {
            @AttributeOverride(name = "provinsi",
                    column = @Column(name = "provinsi", length = 50, nullable = false)),
            @AttributeOverride(name = "kota",
                    column = @Column(name = "kota", length = 50, nullable = false)),
            @AttributeOverride(name = "kelurahan",
                    column = @Column(name = "kelurahan", length = 100, nullable = false)),
            @AttributeOverride(name = "kecamatan",
                    column = @Column(name = "kecamatan", length = 100, nullable = false)),
            @AttributeOverride(name = "rw",
                    column = @Column(name = "no_rw", length = 3, nullable = false)),
            @AttributeOverride(name = "rt",
                    column = @Column(name = "no_rt", length = 3, nullable = false)),
            @AttributeOverride(name = "kodePos",
                    column = @Column(name = "kode_pos", length = 6, nullable = false)),
            @AttributeOverride(name = "namaJalan",
                    column = @Column(name = "nama_jalan", length = 100)),

    })
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    @ToString.Exclude
    private List<AlamatEmbeddable> addresses = new ArrayList<>();
}
