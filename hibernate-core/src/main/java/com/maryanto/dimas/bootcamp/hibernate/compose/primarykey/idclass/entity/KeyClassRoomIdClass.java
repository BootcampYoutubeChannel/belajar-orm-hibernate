package com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KeyClassRoomIdClass implements Serializable {

    private Integer year;
    private String classId;
}
