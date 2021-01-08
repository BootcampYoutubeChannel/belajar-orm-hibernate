package com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeeEnumStringDao implements CrudRepository<EmployeeEnumString, Long> {

    private Session session;

    public EmployeeEnumStringDao(Session session) {
        this.session = session;
    }

    @Override
    public EmployeeEnumString save(EmployeeEnumString value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public EmployeeEnumString update(EmployeeEnumString value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<EmployeeEnumString> findById(Long value) {
        EmployeeEnumString empl = this.session.find(EmployeeEnumString.class, value);
        return empl != null ? Optional.of(empl) : Optional.empty();
    }

    @Override
    public List<EmployeeEnumString> findAll() {
        throw new UnsupportedOperationException();
    }
}
