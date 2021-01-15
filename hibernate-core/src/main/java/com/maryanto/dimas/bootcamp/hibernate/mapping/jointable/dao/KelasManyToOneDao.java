package com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.KelasManyToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class KelasManyToOneDao implements CrudRepository<KelasManyToOneEntity, String> {

    private Session session;

    public KelasManyToOneDao(Session session) {
        this.session = session;
    }

    @Override
    public KelasManyToOneEntity save(KelasManyToOneEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public KelasManyToOneEntity update(KelasManyToOneEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<KelasManyToOneEntity> findById(String value) throws HibernateException {
        KelasManyToOneEntity alamat = this.session.find(KelasManyToOneEntity.class, value);
        return alamat != null ? Optional.of(alamat) : Optional.empty();
    }

    @Override
    public List<KelasManyToOneEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
