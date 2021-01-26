package com.maryanto.dimas.bootcamp.hibernate.dao.wilayah;

import com.maryanto.dimas.bootcamp.hibernate.entity.wilayah.Kelurahan;
import org.hibernate.Session;

import java.util.Optional;

public class KelurahanDaoImpl implements KelurahanDao {

    private Session session;

    public KelurahanDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Kelurahan> findById(String value) {
        Kelurahan data = this.session.find(Kelurahan.class, value);
        return data != null ? Optional.of(data) : Optional.empty();
    }
}
