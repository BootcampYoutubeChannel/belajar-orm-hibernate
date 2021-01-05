package com.maryanto.dimas.bootcamp.hibernate.constraint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "kelas_unique",
        schema = "macam_constraint",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_kelas",
                        columnNames = {"nama", "angkatan"}
                )
        }
)
public class ClassRoomWithUniquesConstraint {

    @Id
    @Column(name = "kode")
    private String id;
    @Column(name = "nama", length = 10)
    private String name;
    @Column(name = "angkatan", length = 4)
    private Integer year;
    @Column(name = "created_by", length = 100, nullable = false)
    private String createdBy;
    @Column(name = "created_datetime", nullable = false)
    private LocalDateTime createdDateTime;
    @Column(name = "last_updated_by", length = 100)
    private String lastUpdateBy;
    @Column(name = "last_updated_datetime")
    private LocalDateTime lastUpdatedBy;
}
