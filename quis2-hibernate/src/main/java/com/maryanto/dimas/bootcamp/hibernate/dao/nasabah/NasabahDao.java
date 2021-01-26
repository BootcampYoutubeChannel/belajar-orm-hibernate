package com.maryanto.dimas.bootcamp.hibernate.dao.nasabah;

import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.Nasabah;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.NasabahBadanUsaha;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.NasabahPerorangan;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;

import java.util.Optional;

public interface NasabahDao extends CrudRepository<Nasabah, String> {

    Optional<NasabahBadanUsaha> findNasabahBadanUsahaById(String value);

    Optional<NasabahPerorangan> findNasabahPeroranganById(String value);
}
