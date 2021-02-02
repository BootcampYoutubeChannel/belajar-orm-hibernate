package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.query.dto.GroupByModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class GroupByDao {
    private Session session;

    public GroupByDao(Session session) {
        this.session = session;
    }

    public List<GroupByModel> findGroupByJob(){
        //language=HQL
        String hql = "select new com.maryanto.dimas.bootcamp.hibernate.query.dto.GroupByModel(job, sum(salary))\n" +
                "from ParentChildEmployeeEntity \n" +
                "group by job";
        Query<GroupByModel> query = this.session.createQuery(hql, GroupByModel.class);
        return query.getResultList();
    }

    public List<GroupByModel> findGroupByJobWithHaving(BigDecimal salary){
        //language=HQL
        String hql = "select new com.maryanto.dimas.bootcamp.hibernate.query.dto.GroupByModel(job, sum(salary))\n" +
                "from ParentChildEmployeeEntity \n" +
                "group by job\n" +
                "having sum(salary) >= :salary";
        Query<GroupByModel> query = this.session.createQuery(hql, GroupByModel.class)
                .setParameter("salary", salary);
        return query.getResultList();
    }

}
