package com.maryanto.dimas.bootcamp.dao.hr;

import com.maryanto.dimas.bootcamp.entity.hr.Employee;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDao {

    private Session session;

    public EmployeeDao(Session session) {
        this.session = session;
    }

    public List<Employee> findByFirstNameLikeOrSalaryLowerThenOrderCommission(String firstName, BigDecimal salary) {
        String hql = "from Employee \n" +
                "where firstName like :firstNameCompare or \n" +
                "salary < :salaryCompare\n" +
                "order by commissionPct";
        return this.session.createQuery(hql, Employee.class)
                .setParameter("firstNameCompare", new StringBuilder("%")
                        .append(firstName)
                        .append("%").toString())
                .setParameter("salaryCompare", salary)
                .getResultList();
    }

    public void updateCommissionPct(String jobId){
        //language=HQL
        String hql =
                "update Employee set\n" +
                        "commissionPct = coalesce(commissionPct, 0)  + 0.2\n" +
                        "where id in (select empl.id \n" +
                        "                 from Employee empl join Job j on (empl.job = j)\n" +
                        "                 where extract(day from current_timestamp - empl.joinDate) >= 365 and \n" +
                        "                j.id = :jobIdCompare)";
        this.session.createQuery(hql)
                .setParameter("jobIdCompare", jobId)
                .executeUpdate();
    }
}
