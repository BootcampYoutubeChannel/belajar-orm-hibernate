package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeStatus;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InPredicateDao {

    private Session session;

    public InPredicateDao(Session session) {
        this.session = session;
    }

    public List<ParentChildEmployeeEntity> findSalaryIn(List<BigDecimal> salaries) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where salary in (:salaries)";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameterList("salaries", salaries);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findJobIn(List<String> jobs) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where job in (:jobs)";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameterList("jobs", jobs);
        return query.getResultList();
    }

    public List<EmployeeEnumString> findBirthDateIn(List<LocalDate> dates) {
        //language=HQL
        String hql = "from EmployeeEnumString \n" +
                "where birthDate in (:dates)";
        Query<EmployeeEnumString> query = this.session.createQuery(hql, EmployeeEnumString.class)
                .setParameterList("dates", dates);
        return query.getResultList();
    }

    public List<EmployeeEnumString> findStatusIn(List<EmployeeStatus> statuses) {
        //language=HQL
        String hql = "from EmployeeEnumString \n" +
                "where status in (:statuses)";
        Query<EmployeeEnumString> query = this.session.createQuery(hql, EmployeeEnumString.class)
                .setParameterList("statuses", statuses);
        return query.getResultList();
    }
}
