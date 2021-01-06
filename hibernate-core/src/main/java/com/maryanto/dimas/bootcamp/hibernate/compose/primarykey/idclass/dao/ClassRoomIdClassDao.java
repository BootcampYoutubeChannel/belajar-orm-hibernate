package com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.dao;

import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.entity.ClassRoomIdClass;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.entity.KeyClassRoomIdClass;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.service.UnknownServiceException;

import java.util.List;
import java.util.Optional;

public class ClassRoomIdClassDao implements CrudRepository<ClassRoomIdClass, KeyClassRoomIdClass> {

    private Session session;

    public ClassRoomIdClassDao(Session session) {
        this.session = session;
    }

    @Override
    public ClassRoomIdClass save(ClassRoomIdClass value) throws HibernateException {
        KeyClassRoomIdClass primaryKey = (KeyClassRoomIdClass) this.session.save(value);
        value.setClassId(primaryKey.getClassId());
        value.setYear(primaryKey.getYear());
        return value;
    }

    @Override
    public ClassRoomIdClass update(ClassRoomIdClass value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(KeyClassRoomIdClass value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<ClassRoomIdClass> findById(KeyClassRoomIdClass value) {
        ClassRoomIdClass classRoom = this.session.find(ClassRoomIdClass.class, value);
        return classRoom != null ? Optional.of(classRoom) : Optional.empty();
    }

    @Override
    public List<ClassRoomIdClass> findAll() {
        throw new UnsupportedOperationException();
    }
}
