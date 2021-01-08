package com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumOrdinal;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeeEnumOrdinalDao implements CrudRepository<EmployeeEnumOrdinal, Long> {

    private Session session;

    public EmployeeEnumOrdinalDao(Session session) {
        this.session = session;
    }

    @Override
    public EmployeeEnumOrdinal save(EmployeeEnumOrdinal value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public EmployeeEnumOrdinal update(EmployeeEnumOrdinal value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<EmployeeEnumOrdinal> findById(Long value) {
        EmployeeEnumOrdinal empl = this.session.find(EmployeeEnumOrdinal.class, value);
        return empl != null ? Optional.of(empl) : Optional.empty();
    }

    @Override
    public List<EmployeeEnumOrdinal> findAll() {
        throw new UnsupportedOperationException();
    }
}
