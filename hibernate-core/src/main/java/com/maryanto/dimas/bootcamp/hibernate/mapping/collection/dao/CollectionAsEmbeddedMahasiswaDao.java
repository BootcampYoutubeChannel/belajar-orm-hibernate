package com.maryanto.dimas.bootcamp.hibernate.mapping.collection.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsEmbeddedMahasiswa;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsEmbeddedMahasiswa;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class CollectionAsEmbeddedMahasiswaDao implements CrudRepository<CollectionAsEmbeddedMahasiswa, Long> {

    private Session session;

    public CollectionAsEmbeddedMahasiswaDao(Session session) {
        this.session = session;
    }

    @Override
    public CollectionAsEmbeddedMahasiswa save(CollectionAsEmbeddedMahasiswa value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public CollectionAsEmbeddedMahasiswa update(CollectionAsEmbeddedMahasiswa value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<CollectionAsEmbeddedMahasiswa> findById(Long value) throws HibernateException {
        CollectionAsEmbeddedMahasiswa mahasiswa = this.session.find(CollectionAsEmbeddedMahasiswa.class, value);
        return mahasiswa != null ? Optional.of(mahasiswa) : Optional.empty();
    }

    @Override
    public List<CollectionAsEmbeddedMahasiswa> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
