package com.maryanto.dimas.bootcamp.latihan.dao;

import com.maryanto.dimas.bootcamp.latihan.entity.Jobs;
import com.maryanto.dimas.bootcamp.latihan.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class JobsDao implements CrudRepository<Jobs, Long> {

    private Session session;

    public JobsDao(Session session) {
        this.session = session;
    }

    @Override
    public Jobs save(Jobs value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public Jobs update(Jobs value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    public boolean removeBy(Jobs value) throws HibernateException {
        this.session.remove(value);
        return true;
    }

    @Override
    public Optional<Jobs> findById(Long value) {
        Jobs job = this.session.find(Jobs.class, value);
        return job != null ? Optional.of(job) : Optional.empty();
    }

    @Override
    public List<Jobs> findAll() {
        throw new UnsupportedOperationException();
    }
}
