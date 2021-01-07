package com.maryanto.dimas.bootcamp.latihan.repository;

import java.util.List;
import java.util.Optional;

public interface ReadRepository<T, PK> {

    Optional<T> findById(PK value);

    List<T> findAll();
}
