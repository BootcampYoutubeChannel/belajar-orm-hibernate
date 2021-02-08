package com.maryanto.dimas.bootcamp.entity.regions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provinces", schema = "regions")
public class Province {

    @Id
    @Column
    private String id;
    private Long code;
    private String name;
}
