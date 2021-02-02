package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LikePredicateDao {

    private Session session;

    public LikePredicateDao(Session session) {
        this.session = session;
    }

    public List<ParentChildEmployeeEntity> likeOperator(String employeeName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity where name like :nameExpression";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("nameExpression", employeeName);
        return query.getResultList();
    }
}
