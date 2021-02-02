package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class CombinePredicateDao {

    private Session session;

    public CombinePredicateDao(Session session) {
        this.session = session;
    }

    public List<ParentChildEmployeeEntity> findBySalaryHigherThanAndJobName(
            BigDecimal salary, String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where salary >= :salary and job = :jobName";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("salary", salary)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findBySalaryHigherThanOrJobName(
            BigDecimal salary, String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where salary >= :salary or job = :jobName";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("salary", salary)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findBySalaryHigherThanAndJobNameOrManagerIsNotNull(
            BigDecimal salary, String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where salary >= :salary and job = :jobName or manager is null";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("salary", salary)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findBySalaryHigherThanOrJobNameAndManagerIsNotNullPriority(
            BigDecimal salary, String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where salary >= :salary or (job = :jobName and manager is null)";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("salary", salary)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }
}
