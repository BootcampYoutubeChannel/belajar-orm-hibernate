package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaManyToManyEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MahasiswaManyToManyDao implements CrudRepository<MahasiswaManyToManyEntity, String> {
    private Session session;

    public MahasiswaManyToManyDao(Session session) {
        this.session = session;
    }

    @Override
    public MahasiswaManyToManyEntity save(MahasiswaManyToManyEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MahasiswaManyToManyEntity update(MahasiswaManyToManyEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MahasiswaManyToManyEntity> findById(String value) throws HibernateException {
        MahasiswaManyToManyEntity msh = this.session.find(MahasiswaManyToManyEntity.class, value);
        return msh != null ? Optional.of(msh) : Optional.empty();
    }

    @Override
    public List<MahasiswaManyToManyEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
