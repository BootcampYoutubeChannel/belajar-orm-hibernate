package com.maryanto.dimas.bootcamp.hibernate.simple.dao;

import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MahasiswaDao implements CrudRepository<Mahasiswa, Long> {

    private Session session;

    public MahasiswaDao(Session session) {
        this.session = session;
    }

    @Override
    public Mahasiswa save(Mahasiswa value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setKode(returnKey);
        return value;
    }

    @Override
    public Mahasiswa update(Mahasiswa value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    public boolean removeBy(Mahasiswa value) throws HibernateException {
        this.session.remove(value);
        return true;
    }

    @Override
    public Optional<Mahasiswa> findById(Long value) {
        Mahasiswa mhs = this.session.find(Mahasiswa.class, value);
        return mhs != null ? Optional.of(mhs) : Optional.empty();
    }

    @Override
    public List<Mahasiswa> findAll() {
        throw new UnsupportedOperationException();
    }
}
