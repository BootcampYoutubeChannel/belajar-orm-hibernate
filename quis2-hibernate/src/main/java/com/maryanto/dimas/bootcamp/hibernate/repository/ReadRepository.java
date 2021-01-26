package com.maryanto.dimas.bootcamp.hibernate.repository;

import java.util.Optional;

public interface ReadRepository <T, PK> {

    Optional<T> findById(PK value);

//    List<T> findAll();
}
