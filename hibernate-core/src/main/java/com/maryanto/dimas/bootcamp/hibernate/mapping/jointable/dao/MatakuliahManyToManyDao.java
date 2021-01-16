package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MatakuliahManyToManyEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MatakuliahManyToManyDao implements CrudRepository<MatakuliahManyToManyEntity, String> {

    private Session session;

    public MatakuliahManyToManyDao(Session session) {
        this.session = session;
    }

    @Override
    public MatakuliahManyToManyEntity save(MatakuliahManyToManyEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MatakuliahManyToManyEntity update(MatakuliahManyToManyEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MatakuliahManyToManyEntity> findById(String value) throws HibernateException {
        MatakuliahManyToManyEntity msh = this.session.find(MatakuliahManyToManyEntity.class, value);
        return msh != null ? Optional.of(msh) : Optional.empty();
    }

    @Override
    public List<MatakuliahManyToManyEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
