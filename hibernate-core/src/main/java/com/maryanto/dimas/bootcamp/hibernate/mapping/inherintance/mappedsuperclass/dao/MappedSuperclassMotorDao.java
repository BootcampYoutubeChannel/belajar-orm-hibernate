package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity.MappedSuperclassMotorEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MappedSuperclassMotorDao implements CrudRepository<MappedSuperclassMotorEntity, String> {

    private Session session;

    public MappedSuperclassMotorDao(Session session) {
        this.session = session;
    }

    @Override
    public MappedSuperclassMotorEntity save(MappedSuperclassMotorEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MappedSuperclassMotorEntity update(MappedSuperclassMotorEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MappedSuperclassMotorEntity> findById(String value) throws HibernateException {
        MappedSuperclassMotorEntity mobil = this.session.find(MappedSuperclassMotorEntity.class, value);
        return mobil != null ? Optional.of(mobil) : Optional.empty();
    }

    @Override
    public List<MappedSuperclassMotorEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
