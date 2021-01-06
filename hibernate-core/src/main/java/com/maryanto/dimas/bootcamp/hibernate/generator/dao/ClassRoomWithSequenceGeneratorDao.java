package com.maryanto.dimas.bootcamp.hibernate.generator.dao;

import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithSequenceGenerator;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ClassRoomWithSequenceGeneratorDao implements CrudRepository<ClassRoomWithSequenceGenerator, Long> {

    private Session session;

    public ClassRoomWithSequenceGeneratorDao(Session session) {
        this.session = session;
    }

    @Override
    public ClassRoomWithSequenceGenerator save(ClassRoomWithSequenceGenerator value) throws HibernateException {
        Long primaryKey = (Long) this.session.save(value);
        value.setId(primaryKey);
        return value;
    }

    @Override
    public ClassRoomWithSequenceGenerator update(ClassRoomWithSequenceGenerator value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<ClassRoomWithSequenceGenerator> findById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ClassRoomWithSequenceGenerator> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
