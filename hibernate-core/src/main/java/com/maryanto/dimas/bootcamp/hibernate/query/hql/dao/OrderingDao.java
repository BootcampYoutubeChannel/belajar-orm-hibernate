package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderingDao {

    private Session session;

    public OrderingDao(Session session) {
        this.session = session;
    }

    public List<ParentChildEmployeeEntity> findAllSortBySalaryAsc() {
        String hql = "from ParentChildEmployeeEntity \n" +
                "order by salary asc";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findAllSortBySalaryDesc() {
        String hql = "from ParentChildEmployeeEntity \n" +
                "order by salary desc";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class);
        return query.getResultList();
    }
}
