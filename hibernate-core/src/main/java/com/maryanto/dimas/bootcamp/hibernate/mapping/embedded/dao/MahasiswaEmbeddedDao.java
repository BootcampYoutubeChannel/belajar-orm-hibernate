package com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.MahasiswaEmbedded;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MahasiswaEmbeddedDao implements CrudRepository<MahasiswaEmbedded, Long> {

    private Session session;

    public MahasiswaEmbeddedDao(Session session) {
        this.session = session;
    }

    @Override
    public MahasiswaEmbedded save(MahasiswaEmbedded value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public MahasiswaEmbedded update(MahasiswaEmbedded value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<MahasiswaEmbedded> findById(Long value) {
        MahasiswaEmbedded msh = this.session.find(MahasiswaEmbedded.class, value);
        return msh != null ? Optional.of(msh) : Optional.empty();
    }

    @Override
    public List<MahasiswaEmbedded> findAll() {
        throw new UnsupportedOperationException();
    }
}
