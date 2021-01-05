package com.maryanto.dimas.bootcamp.hibernate.constraint.dao;

import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.EmployeeWithCheckConstraint;
import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeeWithCheckConstraintDao implements CrudRepository<EmployeeWithCheckConstraint, String> {

    private Session session;

    public EmployeeWithCheckConstraintDao(Session session) {
        this.session = session;
    }

    @Override
    public EmployeeWithCheckConstraint save(EmployeeWithCheckConstraint value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public EmployeeWithCheckConstraint update(EmployeeWithCheckConstraint value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<EmployeeWithCheckConstraint> findById(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<EmployeeWithCheckConstraint> findAll() {
        throw new UnsupportedOperationException();
    }
}
