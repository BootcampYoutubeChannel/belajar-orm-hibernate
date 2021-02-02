package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class NotPredicateDao {

    private Session session;

    public NotPredicateDao(Session session) {
        this.session = session;
    }

    public List<Mahasiswa> findByNotActive() {
        //language=HQL
        String hql = "from Mahasiswa\n" +
                "where not (active = true) ";
        Query<Mahasiswa> query = this.session.createQuery(hql, Mahasiswa.class);
        return query.getResultList();
    }

    public List<Mahasiswa> findByBirthDateNotIn(List<LocalDate> birthDates) {
        //language=HQL
        String hql = "from Mahasiswa\n" +
                "where tglLahir not in (:tanggalLahir)";
        Query<Mahasiswa> query = this.session.createQuery(hql, Mahasiswa.class)
                .setParameterList("tanggalLahir", birthDates);
        return query.getResultList();
    }

    public List<Mahasiswa> findByBioNotNull() {
        //language=HQL
        String hql = "from Mahasiswa \n" +
                "where biodata is not null";
        Query<Mahasiswa> query = this.session.createQuery(hql, Mahasiswa.class);
        return query.getResultList();
    }
}
