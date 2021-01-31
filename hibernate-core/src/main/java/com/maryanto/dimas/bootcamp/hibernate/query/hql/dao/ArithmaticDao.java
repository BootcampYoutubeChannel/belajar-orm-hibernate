package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.dto.ArithmeticModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class ArithmaticDao {

    private Session session;

    public ArithmaticDao(Session session) {
        this.session = session;
    }

    public List<ArithmeticModel> selectWithArithmeticModel(String employeeId) {
        String hql = "select new com.maryanto.dimas.bootcamp.hibernate.query.dto.ArithmeticModel(id, name, salary * 12, salary + 10000)\n" +
                "from ParentChildEmployeeEntity\n" +
                "where id = :id";
        Query<ArithmeticModel> query = this.session.createQuery(hql, ArithmeticModel.class)
                .setParameter("id", employeeId);
        return query.getResultList();
    }

    public BigDecimal hitungTotalSalarySemuaEmployeeDalamSetahun() {
        Query<BigDecimal> query = this.session.createQuery(
                "select sum(salary * 12) \n" +
                        "from ParentChildEmployeeEntity ", BigDecimal.class);
        return query.getSingleResult();
    }

    public List<ParentChildEmployeeEntity> cariKaryawanYangSalaryDalamSetahunDiatas(BigDecimal salaryCompare) {
        Query<ParentChildEmployeeEntity> query = this.session.createQuery(
                "from ParentChildEmployeeEntity \n" +
                        "where (salary * 12) >= :salaryCompare", ParentChildEmployeeEntity.class);
        query.setParameter("salaryCompare", salaryCompare);
        return query.getResultList();
    }


}
