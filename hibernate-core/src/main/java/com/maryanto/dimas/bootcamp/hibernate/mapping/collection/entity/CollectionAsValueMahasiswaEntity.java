package com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity;

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
@Table(name = "mahasiswa", schema = "collections")
public class CollectionAsValueMahasiswaEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nim")
    private String nim;
    @Column(name = "nama", nullable = false)
    private String name;
    @Column(name = "alamat", nullable = false)
    private String address;
    @ElementCollection
    @CollectionTable(
            name = "mahasiswa_contacts",
            schema = "collections",
            joinColumns = @JoinColumn(name = "mahasiswa_id", nullable = false),
            foreignKey = @ForeignKey(name = "fk_contacts_mahasiswa_id")
    )
    @Column(name = "no_contact")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @FieldNameConstants.Exclude
    private List<String> contacts = new ArrayList<>();
}
