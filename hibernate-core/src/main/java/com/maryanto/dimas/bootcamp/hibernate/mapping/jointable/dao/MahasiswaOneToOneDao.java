package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MahasiswaOneToOneDao implements CrudRepository<MahasiswaOneToOneEntity, String> {

    private Session session;

    public MahasiswaOneToOneDao(Session session) {
        this.session = session;
    }

    @Override
    public MahasiswaOneToOneEntity save(MahasiswaOneToOneEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MahasiswaOneToOneEntity update(MahasiswaOneToOneEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MahasiswaOneToOneEntity> findById(String value) throws HibernateException {
        MahasiswaOneToOneEntity msh = this.session.find(MahasiswaOneToOneEntity.class, value);
        return msh != null ? Optional.of(msh) : Optional.empty();
    }

    @Override
    public List<MahasiswaOneToOneEntity> findAll() throws HibernateException {
        return null;
    }
}
