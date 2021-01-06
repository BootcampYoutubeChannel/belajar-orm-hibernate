package com.maryanto.dimas.bootcamp.hibernate.generator.dao;

import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithUuidGenerator;
import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithUuidGenerator;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ClassRoomWithUuidGeneratorDao implements CrudRepository<ClassRoomWithUuidGenerator, String> {

    private Session session;

    public ClassRoomWithUuidGeneratorDao(Session session) {
        this.session = session;
    }

    @Override
    public ClassRoomWithUuidGenerator save(ClassRoomWithUuidGenerator value) throws HibernateException {
        String primaryKey = (String) this.session.save(value);
        value.setId(primaryKey);
        return value;
    }

    @Override
    public ClassRoomWithUuidGenerator update(ClassRoomWithUuidGenerator value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<ClassRoomWithUuidGenerator> findById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ClassRoomWithUuidGenerator> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
