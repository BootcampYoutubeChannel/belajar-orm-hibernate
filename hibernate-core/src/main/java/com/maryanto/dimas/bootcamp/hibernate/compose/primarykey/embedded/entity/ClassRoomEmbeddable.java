package com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassRoomEmbeddable implements Serializable {

    @Column(name = "tahun_angkatan", length = 4, columnDefinition = "int check(tahun_angkatan >= 1999)")
    private Integer year;
    @Column(name = "class_id")
    private String classId;
}
