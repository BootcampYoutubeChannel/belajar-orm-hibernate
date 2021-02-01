package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import org.hibernate.Session;

import java.util.List;

public class NullessPredicateDao {

    private Session session;

    public NullessPredicateDao(Session session) {
        this.session = session;
    }

    public List<ParentChildEmployeeEntity> employeesWithoutManager() {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where manager is null";
        return this.session.createQuery(hql, ParentChildEmployeeEntity.class).getResultList();
    }

    public List<ParentChildEmployeeEntity> employeeHaveAManager(){
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where manager is not null ";
        return this.session.createQuery(hql, ParentChildEmployeeEntity.class).getResultList();
    }
}
