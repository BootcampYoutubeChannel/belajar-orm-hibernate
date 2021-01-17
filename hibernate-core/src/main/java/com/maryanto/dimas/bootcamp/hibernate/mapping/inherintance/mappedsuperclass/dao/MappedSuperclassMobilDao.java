package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity.MappedSuperclassMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MappedSuperclassMobilDao implements CrudRepository<MappedSuperclassMobilEntity, String> {

    private Session session;

    public MappedSuperclassMobilDao(Session session) {
        this.session = session;
    }

    @Override
    public MappedSuperclassMobilEntity save(MappedSuperclassMobilEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MappedSuperclassMobilEntity update(MappedSuperclassMobilEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MappedSuperclassMobilEntity> findById(String value) throws HibernateException {
        MappedSuperclassMobilEntity mobil = this.session.find(MappedSuperclassMobilEntity.class, value);
        return mobil != null ? Optional.of(mobil) : Optional.empty();
    }

    @Override
    public List<MappedSuperclassMobilEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
