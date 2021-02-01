package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.query.dto.AggregationModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;

public class AggregateFunctionDao {

    private Session session;

    public AggregateFunctionDao(Session session) {
        this.session = session;
    }

    public AggregationModel getDataAggregation() {
        String hql = "select " +
                "new com.maryanto.dimas.bootcamp.hibernate.query.dto.AggregationModel(\n" +
                "    count (*),\n" +
                "    avg (salary),\n" +
                "    min (salary),\n" +
                "    max (salary),\n" +
                "    sum (salary)\n" +
                ")\n" +
                "from ParentChildEmployeeEntity ";
        Query<AggregationModel> query = this.session.createQuery(hql, AggregationModel.class);
        return query.getSingleResult();
    }

    public Object[] getDataAggregationObject() {
        String hql = "select \n" +
                "    count (*),\n" +
                "    avg (salary),\n" +
                "    min (salary),\n" +
                "    max (salary),\n" +
                "    sum (salary)\n" +
                "from ParentChildEmployeeEntity ";
        Query<Object[]> query = this.session.createQuery(hql, Object[].class);
        return query.getSingleResult();
    }

    public BigDecimal getTotalSalary() {
        //language=HQL
        String hql = "select sum (salary)\n" +
                "from ParentChildEmployeeEntity ";
        Query<BigDecimal> query = this.session.createQuery(hql, BigDecimal.class);
        return query.getSingleResult();
    }


}
