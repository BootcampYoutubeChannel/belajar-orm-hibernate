package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LimitOffsetDao {

    private Session session;

    public LimitOffsetDao(Session session) {
        this.session = session;
    }

    public List<ParentChildEmployeeEntity> limit(Integer max) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class);
        query.setMaxResults(max);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> offset(Integer offset) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class);
        query.setFirstResult(offset);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> offsetAndLimit(Integer max, Integer offset) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class);
        query.setFirstResult(offset);
        query.setMaxResults(max);
        return query.getResultList();
    }
}
