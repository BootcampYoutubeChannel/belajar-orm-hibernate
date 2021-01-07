package com.maryanto.dimas.bootcamp.latihan.dao;

import com.maryanto.dimas.bootcamp.latihan.entity.Employees;
import com.maryanto.dimas.bootcamp.latihan.entity.Employees;
import com.maryanto.dimas.bootcamp.latihan.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeesDao implements CrudRepository<Employees, String> {

    private Session session;

    public EmployeesDao(Session session) {
        this.session = session;
    }

    @Override
    public Employees save(Employees value) throws HibernateException {
        String returnKey = (String) this.session.save(value);
        value.setId(returnKey);
        return value;
    }

    @Override
    public Employees update(Employees value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    public boolean removeBy(Employees value) throws HibernateException {
        this.session.remove(value);
        return true;
    }

    @Override
    public Optional<Employees> findById(String value) {
        Employees employee = this.session.find(Employees.class, value);
        return employee != null ? Optional.of(employee) : Optional.empty();
    }

    @Override
    public List<Employees> findAll() {
        throw new UnsupportedOperationException();
    }
}
