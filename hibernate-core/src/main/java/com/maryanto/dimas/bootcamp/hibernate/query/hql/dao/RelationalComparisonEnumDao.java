package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumOrdinal;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeStatus;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RelationalComparisonEnumDao {

    private Session session;

    public RelationalComparisonEnumDao(Session session) {
        this.session = session;
    }

    public List<EmployeeEnumOrdinal> findEqualByEmployeeStatus(EmployeeStatus status) {
        //language=HQL
        String hql = "from EmployeeEnumOrdinal where status = :status";
        Query<EmployeeEnumOrdinal> query = this.session.createQuery(hql, EmployeeEnumOrdinal.class)
                .setParameter("status", status);
        return query.getResultList();
    }

    public List<EmployeeEnumOrdinal> findNotSameByEmployeeStatus(EmployeeStatus status) {
        //language=HQL
        String hql = "from EmployeeEnumOrdinal where status != :status";
        Query<EmployeeEnumOrdinal> query = this.session.createQuery(hql, EmployeeEnumOrdinal.class)
                .setParameter("status", status);
        return query.getResultList();
    }

    public List<EmployeeEnumOrdinal> findNotEqualByEmployeeStatus(EmployeeStatus status) {
        //language=HQL
        String hql = "from EmployeeEnumOrdinal where status <> :status";
        Query<EmployeeEnumOrdinal> query = this.session.createQuery(hql, EmployeeEnumOrdinal.class)
                .setParameter("status", status);
        return query.getResultList();
    }
}
