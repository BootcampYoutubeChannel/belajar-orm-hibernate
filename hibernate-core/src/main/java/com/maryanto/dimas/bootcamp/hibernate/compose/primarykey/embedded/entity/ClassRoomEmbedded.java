package com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "kelas_embedded", schema = "embeddable")
public class ClassRoomEmbedded {

    @EmbeddedId
    private ClassRoomEmbeddable id;
    //    @Id
//    private String id1;
//    @Id
//    private String id2;
    @Column(name = "kelas_name")
    private String name;
    @Column(name = "prodi")
    private String programStudy;
    @Column(name = "description")
    private String description;
}
