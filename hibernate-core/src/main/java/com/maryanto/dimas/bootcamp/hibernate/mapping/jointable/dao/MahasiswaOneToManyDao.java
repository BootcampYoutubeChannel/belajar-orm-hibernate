package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToManyEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MahasiswaOneToManyDao implements CrudRepository<MahasiswaOneToManyEntity, String> {

    private Session session;

    public MahasiswaOneToManyDao(Session session) {
        this.session = session;
    }

    @Override
    public MahasiswaOneToManyEntity save(MahasiswaOneToManyEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MahasiswaOneToManyEntity update(MahasiswaOneToManyEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MahasiswaOneToManyEntity> findById(String value) throws HibernateException {
        MahasiswaOneToManyEntity msh = this.session.find(MahasiswaOneToManyEntity.class, value);
        return msh != null ? Optional.of(msh) : Optional.empty();
    }

    @Override
    public List<MahasiswaOneToManyEntity> findAll() throws HibernateException {
        return null;
    }
}
