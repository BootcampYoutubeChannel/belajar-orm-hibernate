package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsEmbeddedMahasiswa;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.Optional;

public class ReadOnlyEntityDao {

    private Session session;

    public ReadOnlyEntityDao(Session session) {
        this.session = session;
    }

    public Optional<CollectionAsEmbeddedMahasiswa> findById(Long id) {
        String hql = "from CollectionAsEmbeddedMahasiswa\n" +
                "where id = :id";
        try {
            Query<CollectionAsEmbeddedMahasiswa> query = this.session
                    .createQuery(hql, CollectionAsEmbeddedMahasiswa.class)
                    .setParameter("id", id);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    public Optional<CollectionAsEmbeddedMahasiswa> findByIdReadOnly(Long id) {
        String hql = "from CollectionAsEmbeddedMahasiswa\n" +
                "where id = :id";
        try {
            Query<CollectionAsEmbeddedMahasiswa> query = this.session
                    .createQuery(hql, CollectionAsEmbeddedMahasiswa.class)
                    .setParameter("id", id)
                    .setReadOnly(true);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }
}


