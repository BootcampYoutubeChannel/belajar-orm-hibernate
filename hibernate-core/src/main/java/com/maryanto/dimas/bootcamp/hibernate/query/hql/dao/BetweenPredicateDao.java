package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BetweenPredicateDao {

    private Session session;

    public BetweenPredicateDao(Session session) {
        this.session = session;
    }

    public List<ParentChildEmployeeEntity> findFirstCharacterBetween(String from, String to) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity \n" +
                "where substring(lower(name) , 1, 1) between :from and :to";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("from", from)
                .setParameter("to", to);
        return query.getResultList();
    }

    public List<ParentChildEmployeeEntity> findSalaryBetween(BigDecimal from, BigDecimal to) {
        //language=HQL
        String hql = "from ParentChildEmployeeEntity\n" +
                "where coalesce(salary, 0) between :from and :to";
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(hql, ParentChildEmployeeEntity.class)
                .setParameter("to", to)
                .setParameter("from", from);
        return query.getResultList();
    }

    public List<EmployeeEnumString> findBirthDateBetween(LocalDate from, LocalDate to){
        //language=HQL
        String hql = "from EmployeeEnumString \n" +
                "where birthDate between :dateFrom and :dateTo";
        Query<EmployeeEnumString> query = this.session.createQuery(hql, EmployeeEnumString.class)
                .setParameter("dateFrom", from)
                .setParameter("dateTo", to);
        return query.getResultList();
    }
}
