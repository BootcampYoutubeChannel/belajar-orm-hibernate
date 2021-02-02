package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SubQueryQualifierDao {

    private Session session;

    public SubQueryQualifierDao(Session session) {
        this.session = session;
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryInEmployeeJob(String jobName){
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary in  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryLowerAllByAvgSalary(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  > ALL  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryEqualAllByAvgSalary(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  = ALL  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryHigherAllByAvgSalary(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  > ALL  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryEqualAnyByEmployeeJob(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  = ANY  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryEqualSomeByEmployeeJob(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  = SOME  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryHigherAnyByEmployeeJob(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  > ANY  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryHigherSomeByEmployeeJob(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  > SOME  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryLowerAnyByEmployeeJob(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  < ANY  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findEmployeesWhenSalaryLowerSomeByEmployeeJob(String jobName) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity emp\n" +
                "where emp.salary  < SOME  (\n" +
                "    select emp_sub.salary \n" +
                "    from ParentChildEmployeeEntity emp_sub \n" +
                "    where emp_sub.job = :jobName\n" +
                ")";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("jobName", jobName);
        return query.getResultList();
    }
}
