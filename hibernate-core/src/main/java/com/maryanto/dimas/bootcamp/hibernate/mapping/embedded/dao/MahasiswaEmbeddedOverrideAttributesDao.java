package com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.MahasiswaEmbeddedOverrideAttributes;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MahasiswaEmbeddedOverrideAttributesDao implements CrudRepository<MahasiswaEmbeddedOverrideAttributes, Long> {

    private Session session;

    public MahasiswaEmbeddedOverrideAttributesDao(Session session) {
        this.session = session;
    }

    @Override
    public MahasiswaEmbeddedOverrideAttributes save(MahasiswaEmbeddedOverrideAttributes value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MahasiswaEmbeddedOverrideAttributes update(MahasiswaEmbeddedOverrideAttributes value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MahasiswaEmbeddedOverrideAttributes> findById(Long value) throws HibernateException {
        MahasiswaEmbeddedOverrideAttributes mhs = this.session.find(MahasiswaEmbeddedOverrideAttributes.class, value);
        return mhs != null ? Optional.of(mhs) : Optional.empty();
    }

    @Override
    public List<MahasiswaEmbeddedOverrideAttributes> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
