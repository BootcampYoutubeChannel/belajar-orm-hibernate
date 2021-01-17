package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableMotorEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class SingleTableKendaraanDao implements CrudRepository<SingleTableKendaraanEntity, String> {

    private Session session;

    public SingleTableKendaraanDao(Session session) {
        this.session = session;
    }

    @Override
    public SingleTableKendaraanEntity save(SingleTableKendaraanEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public SingleTableKendaraanEntity update(SingleTableKendaraanEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<SingleTableKendaraanEntity> findById(String value) throws HibernateException {
        SingleTableKendaraanEntity kendaraan = this.session.find(SingleTableKendaraanEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    public Optional<SingleTableMobilEntity> findByMobilId(String value) throws HibernateException {
        SingleTableMobilEntity kendaraan = this.session.find(SingleTableMobilEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    public Optional<SingleTableMotorEntity> findByMotorId(String value) throws HibernateException {
        SingleTableMotorEntity kendaraan = this.session.find(SingleTableMotorEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    @Override
    public List<SingleTableKendaraanEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
