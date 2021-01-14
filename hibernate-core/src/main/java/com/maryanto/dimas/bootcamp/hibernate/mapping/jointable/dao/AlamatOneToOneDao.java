package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.AlamatOneToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class AlamatOneToOneDao implements CrudRepository<AlamatOneToOneEntity, String> {

    private Session session;

    public AlamatOneToOneDao(Session session) {
        this.session = session;
    }

    @Override
    public AlamatOneToOneEntity save(AlamatOneToOneEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public AlamatOneToOneEntity update(AlamatOneToOneEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<AlamatOneToOneEntity> findById(String value) throws HibernateException {
        AlamatOneToOneEntity alamat = this.session.find(AlamatOneToOneEntity.class, value);
        return alamat != null ? Optional.of(alamat) : Optional.empty();
    }

    @Override
    public List<AlamatOneToOneEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
