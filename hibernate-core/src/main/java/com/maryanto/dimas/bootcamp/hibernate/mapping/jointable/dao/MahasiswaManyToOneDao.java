package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaManyToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaManyToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MahasiswaManyToOneDao implements CrudRepository<MahasiswaManyToOneEntity, String> {

    private Session session;

    public MahasiswaManyToOneDao(Session session) {
        this.session = session;
    }

    @Override
    public MahasiswaManyToOneEntity save(MahasiswaManyToOneEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MahasiswaManyToOneEntity update(MahasiswaManyToOneEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MahasiswaManyToOneEntity> findById(String value) throws HibernateException {
        MahasiswaManyToOneEntity msh = this.session.find(MahasiswaManyToOneEntity.class, value);
        return msh != null ? Optional.of(msh) : Optional.empty();
    }

    @Override
    public List<MahasiswaManyToOneEntity> findAll() throws HibernateException {
        return null;
    }
}
