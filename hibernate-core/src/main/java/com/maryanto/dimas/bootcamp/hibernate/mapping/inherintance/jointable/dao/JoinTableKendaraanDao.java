package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableMotorEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class JoinTableKendaraanDao implements CrudRepository<JoinTableKendaraanEntity, String> {

    private Session session;

    public JoinTableKendaraanDao(Session session) {
        this.session = session;
    }

    @Override
    public JoinTableKendaraanEntity save(JoinTableKendaraanEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public JoinTableKendaraanEntity update(JoinTableKendaraanEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<JoinTableKendaraanEntity> findById(String value) throws HibernateException {
        JoinTableKendaraanEntity kendaraan = this.session.find(JoinTableKendaraanEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    public Optional<JoinTableMobilEntity> findByMobilId(String value) throws HibernateException {
        JoinTableMobilEntity kendaraan = this.session.find(JoinTableMobilEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    public Optional<JoinTableMotorEntity> findByMotorId(String value) throws HibernateException {
        JoinTableMotorEntity kendaraan = this.session.find(JoinTableMotorEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    @Override
    public List<JoinTableKendaraanEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
