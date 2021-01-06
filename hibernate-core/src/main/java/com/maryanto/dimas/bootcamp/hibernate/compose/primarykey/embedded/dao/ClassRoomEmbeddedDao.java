package com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.dao;

import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity.ClassRoomEmbeddable;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity.ClassRoomEmbedded;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.util.List;
import java.util.Optional;

public class ClassRoomEmbeddedDao implements CrudRepository<ClassRoomEmbedded, ClassRoomEmbeddable> {

    private Session session;

    public ClassRoomEmbeddedDao(Session session) {
        this.session = session;
    }

    @Override
    public ClassRoomEmbedded save(ClassRoomEmbedded value) throws HibernateException {
        ClassRoomEmbeddable primaryKey = (ClassRoomEmbeddable) this.session.save(value);
        value.setId(primaryKey);
        return value;
    }

    @Override
    public ClassRoomEmbedded update(ClassRoomEmbedded value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(ClassRoomEmbeddable value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<ClassRoomEmbedded> findById(ClassRoomEmbeddable value) {
        ClassRoomEmbedded classRoom = this.session.find(ClassRoomEmbedded.class, value);
        return classRoom != null ? Optional.of(classRoom) : Optional.empty();

    }

    @Override
    public List<ClassRoomEmbedded> findAll() {
        throw new UnsupportedOperationException();
    }
}
