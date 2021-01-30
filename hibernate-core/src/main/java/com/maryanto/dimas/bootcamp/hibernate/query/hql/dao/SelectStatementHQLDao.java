package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.repository.ReadRepository;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SelectStatementHQLDao implements ReadRepository<Mahasiswa, Long> {

    private Session session;

    public SelectStatementHQLDao(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Mahasiswa> findById(Long value) {
        String hql = "from Mahasiswa where id = ?1";
        try {
            Query<Mahasiswa> query = this.session.createQuery(hql, Mahasiswa.class);
            query.setParameter(1, value);
            Mahasiswa data = query.getSingleResult();
            return data != null ? Optional.of(data) : Optional.empty();
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    @Override
    public List<Mahasiswa> findAll() {
        //language=HQL
        String hql = "from Mahasiswa";
        Query<Mahasiswa> query = this.session.createQuery(hql, Mahasiswa.class);
        return query.getResultList();
    }
}
