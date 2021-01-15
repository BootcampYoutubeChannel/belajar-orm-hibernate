package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.AlamatOneToManyEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class AlamatOneToManyDao implements CrudRepository<AlamatOneToManyEntity, String> {

    private Session session;

    public AlamatOneToManyDao(Session session) {
        this.session = session;
    }

    @Override
    public AlamatOneToManyEntity save(AlamatOneToManyEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public AlamatOneToManyEntity update(AlamatOneToManyEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<AlamatOneToManyEntity> findById(String value) throws HibernateException {
        AlamatOneToManyEntity alamat = this.session.find(AlamatOneToManyEntity.class, value);
        return alamat != null ? Optional.of(alamat) : Optional.empty();
    }

    @Override
    public List<AlamatOneToManyEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
