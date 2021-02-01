package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableMobilEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RelationalComparisonBooleanDao {

    private Session session;

    public RelationalComparisonBooleanDao(Session session) {
        this.session = session;
    }

    public List<SingleTableMobilEntity> findEqualByStatusAllWheelDrive(Boolean status) {
        //language=HQL
        String hql = "from SingleTableMobilEntity where allWheelDrive = :status";
        Query<SingleTableMobilEntity> query = this.session.createQuery(hql, SingleTableMobilEntity.class)
                .setParameter("status", status);
        return query.getResultList();
    }

    public List<SingleTableMobilEntity> findNegationByStatusAllWheelDrive(Boolean status) {
        //language=HQL
        String hql = "from SingleTableMobilEntity where allWheelDrive != :status";
        Query<SingleTableMobilEntity> query = this.session.createQuery(hql, SingleTableMobilEntity.class)
                .setParameter("status", status);
        return query.getResultList();
    }

}
