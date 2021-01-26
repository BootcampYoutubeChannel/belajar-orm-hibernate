package com.maryanto.dimas.bootcamp.hibernate.dao.nasabah;

import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.Nasabah;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.NasabahBadanUsaha;
import com.maryanto.dimas.bootcamp.hibernate.entity.nasabah.NasabahPerorangan;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.Optional;

public class NasabahDaoImpl implements NasabahDao {

    private Session session;

    public NasabahDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public Optional<NasabahBadanUsaha> findNasabahBadanUsahaById(String value) {
        try {
            NasabahBadanUsaha data = this.session.find(NasabahBadanUsaha.class, value);
            return data != null ? Optional.of(data) : Optional.empty();
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<NasabahPerorangan> findNasabahPeroranganById(String value) {
        try {
            NasabahPerorangan data = this.session.find(NasabahPerorangan.class, value);
            return data != null ? Optional.of(data) : Optional.empty();
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    @Override
    public Nasabah save(Nasabah value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public Nasabah update(Nasabah value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    @Deprecated
    public Optional<Nasabah> findById(String value) {
        throw new UnsupportedOperationException();
    }
}
