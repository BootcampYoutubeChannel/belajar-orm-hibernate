package com.maryanto.dimas.bootcamp.hibernate.mapping.collection.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsValueMahasiswaEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class CollectionAsValueMahasiswaDao implements CrudRepository<CollectionAsValueMahasiswaEntity, Long> {

    private Session session;

    public CollectionAsValueMahasiswaDao(Session session) {
        this.session = session;
    }

    @Override
    public CollectionAsValueMahasiswaEntity save(CollectionAsValueMahasiswaEntity value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public CollectionAsValueMahasiswaEntity update(CollectionAsValueMahasiswaEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<CollectionAsValueMahasiswaEntity> findById(Long value) throws HibernateException {
        CollectionAsValueMahasiswaEntity mahasiswa = this.session.find(CollectionAsValueMahasiswaEntity.class, value);
        return mahasiswa != null ? Optional.of(mahasiswa) : Optional.empty();
    }

    @Override
    public List<CollectionAsValueMahasiswaEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
