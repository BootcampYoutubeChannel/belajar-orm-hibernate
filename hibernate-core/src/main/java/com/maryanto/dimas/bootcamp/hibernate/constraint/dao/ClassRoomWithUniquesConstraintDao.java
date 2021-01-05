package com.maryanto.dimas.bootcamp.hibernate.constraint.dao;

import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.ClassRoomWithUniquesConstraint;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ClassRoomWithUniquesConstraintDao implements CrudRepository<ClassRoomWithUniquesConstraint, String> {

    private Session session;

    public ClassRoomWithUniquesConstraintDao(Session session) {
        this.session = session;
    }

    @Override
    public ClassRoomWithUniquesConstraint save(ClassRoomWithUniquesConstraint value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public ClassRoomWithUniquesConstraint update(ClassRoomWithUniquesConstraint value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<ClassRoomWithUniquesConstraint> findById(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ClassRoomWithUniquesConstraint> findAll() {
        throw new UnsupportedOperationException();
    }
}
