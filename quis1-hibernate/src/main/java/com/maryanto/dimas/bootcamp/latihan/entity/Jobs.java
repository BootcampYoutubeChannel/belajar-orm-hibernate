package com.maryanto.dimas.bootcamp.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs", schema = "hrd")
@SequenceGenerator(
        name = "job_seq_generator",
        sequenceName = "seq_jobs",
        initialValue = 1,
        allocationSize = 1,
        schema = "hrd")
public class Jobs {

    @Id
    @GeneratedValue(generator = "job_seq_generator")
    private Long id;

    @Column(name = "nama", length = 50, nullable = false)
    private String nama;

    @Type(type = "text")
    @Column(name = "keterangan")
    private String keterangan;
}

