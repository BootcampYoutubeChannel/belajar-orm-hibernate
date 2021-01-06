package com.maryanto.dimas.bootcamp.hibernate.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "kelas_uuid",
        schema = "generator"
)
@GenericGenerator(name = "kelas_uuid_gen", strategy = "uuid2")
public class ClassRoomWithUuidGenerator {

    @Id
    @Column(name = "kode")
    @GeneratedValue(generator = "kelas_uuid_gen")
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
