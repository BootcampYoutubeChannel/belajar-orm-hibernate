package com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ParentChildEmployeeDao implements CrudRepository<ParentChildEmployeeEntity, String> {

    private Session session;

    public ParentChildEmployeeDao(Session session) {
        this.session = session;
    }

    @Override
    public ParentChildEmployeeEntity save(ParentChildEmployeeEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public ParentChildEmployeeEntity update(ParentChildEmployeeEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<ParentChildEmployeeEntity> findById(String value) throws HibernateException {
        ParentChildEmployeeEntity empl = this.session.find(ParentChildEmployeeEntity.class, value);
        return empl != null ? Optional.of(empl) : Optional.empty();
    }

    @Override
    public List<ParentChildEmployeeEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
