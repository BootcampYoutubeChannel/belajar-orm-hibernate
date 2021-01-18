package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.entity.TablePerClassKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.entity.TablePerClassMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.entity.TablePerClassMotorEntity;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class TablePerClassKendaraanDao implements CrudRepository<TablePerClassKendaraanEntity, String> {

    private Session session;

    public TablePerClassKendaraanDao(Session session) {
        this.session = session;
    }

    @Override
    public TablePerClassKendaraanEntity save(TablePerClassKendaraanEntity value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public TablePerClassKendaraanEntity update(TablePerClassKendaraanEntity value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<TablePerClassKendaraanEntity> findById(String value) throws HibernateException {
        TablePerClassKendaraanEntity kendaraan = this.session.find(TablePerClassKendaraanEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    public Optional<TablePerClassMobilEntity> findByMobilId(String value) throws HibernateException {
        TablePerClassMobilEntity kendaraan = this.session.find(TablePerClassMobilEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    public Optional<TablePerClassMotorEntity> findByMotorId(String value) throws HibernateException {
        TablePerClassMotorEntity kendaraan = this.session.find(TablePerClassMotorEntity.class, value);
        return kendaraan != null ? Optional.of(kendaraan) : Optional.empty();
    }

    @Override
    public List<TablePerClassKendaraanEntity> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
