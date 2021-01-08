package com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mahasiswa_override_att", schema = "embedded")
public class MahasiswaEmbeddedOverrideAttr {
}
