package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeStatus;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.KelasManyToOneEntity;
import org.hibernate.Session;

import java.util.List;

public class DistinctStatementDao {

    private Session session;

    public DistinctStatementDao(Session session) {
        this.session = session;
    }

    public List<EmployeeStatus> findByDistinctProjectsSQL() {
        //language=HQL
        String hql = "select distinct status \n" +
                "from EmployeeEnumString ";
        return this.session.createQuery(hql, EmployeeStatus.class)
                .getResultList();
    }

    public List<KelasManyToOneEntity> findByDistinctEntityQuery() {
        //language=HQL
        String hql = "select distinct kls from MahasiswaManyToOneEntity mhs join \n" +
                "KelasManyToOneEntity kls on mhs.kelas = kls";
        return this.session.createQuery(hql, KelasManyToOneEntity.class)
                .getResultList();
    }
}
