package com.maryanto.dimas.bootcamp.dao.hr;

import com.maryanto.dimas.bootcamp.dto.EmployeeManagerDto;
import com.maryanto.dimas.bootcamp.dto.EmployeeSalaryDto;
import com.maryanto.dimas.bootcamp.dto.GroupByDepartmentDto;
import com.maryanto.dimas.bootcamp.entity.hr.Employee;
import com.maryanto.dimas.bootcamp.entity.hr.EmployeeStatus;
import com.maryanto.dimas.bootcamp.entity.hr.Job;
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

    public void updateCommissionPct(String jobId) {
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

    public List<EmployeeManagerDto> findEmployeeManager() {
        //language=HQL
        String hql = "select  new com.maryanto.dimas.bootcamp.dto.EmployeeManagerDto(\n" +
                "            " +
                "empl.id, \n" +
                "            " +
                "concat(empl.firstName, ' ', empl.lastName),\n" +
                "            dep.name,\n" +
                "            case when empl.manager is null then 'Tidak Memiliki Manager'\n" +
                "            else concat(man.firstName, ' ', man.lastName) end, \n" +
                "            j.title)\n" +
                "from Employee empl left join \n" +
                "    " +
                "Employee man on (empl.manager = man) left join \n" +
                "    Job j on (empl.job = j) left join \n" +
                "    Department dep on (empl.department = dep)\n" +
                "order by man.firstName, empl.firstName";
        return this.session.createQuery(hql, EmployeeManagerDto.class).getResultList();
    }

    public List<EmployeeSalaryDto> findBySalaryHigher(BigDecimal salary) {
        //language=HQL
        String hql = "select  new com.maryanto.dimas.bootcamp.dto.EmployeeSalaryDto(" +
                "   \n" +
                "            " +
                "empl.id, \n" +
                "            " +
                "concat(empl.firstName, ' ', empl.lastName),\n" +
                "            dep.name,\n" +
                "            j.title,\n" +
                "            to_char(empl.salary, '999G999G999D00'),\n" +
                "            case when empl.commissionPct is null then 'Tidak memiliki komisi'\n" +
                "            else " +
                "to_char(coalesce(empl.commissionPct, 0) * empl.salary, '999G999G999D00') end,\n" +
                "            to_char(empl.salary + (coalesce(empl.commissionPct, 0) * empl.salary), '999G999G999D00')\n" +
                "        )\n" +
                "from Employee empl left join \n" +
                "    " +
                "Employee man on (empl.manager = man) left join \n" +
                "    Job j on (empl.job = j) left join \n" +
                "    Department dep on (empl.department = dep)\n" +
                "where empl.salary >= :salaryCompare\n" +
                "order by man.firstName, empl.firstName";
        return this.session.createQuery(hql, EmployeeSalaryDto.class)
                .setParameter("salaryCompare", salary)
                .getResultList();
    }

    public List<GroupByDepartmentDto> totalSalariesByDepartments(List<EmployeeStatus> status) {
        //language=HQL
        String hql = "select  new com.maryanto.dimas.bootcamp.dto.GroupByDepartmentDto(\n" +
                "            " +
                "dep.id, \n" +
                "            dep.name, \n" +
                "            sum(empl.salary), \n" +
                "            count(empl)\n" +
                "        )\n" +
                "from Employee empl left join Department dep on (dep = empl.department)\n" +
                "where empl.status in (:statusComparator)\n" +
                "group by dep.id, dep.name";
        return this.session.createQuery(hql, GroupByDepartmentDto.class)
                .setParameterList("statusComparator", status)
                .getResultList();
    }

    public List<Employee> findSalarySubQueryByJobId(String jobId) {
        String hql = "from Employee out\n" +
                "where \n" +
                "    " +
                "out.commissionPct is not null and\n" +
                "    out.salary < any (select inn.salary \n" +
                "                      from Employee inn join Job j on (inn.job = j)\n" +
                "                      where j.id = :jobCompare)";
        return this.session.createQuery(hql, Employee.class)
                .setParameter("jobCompare", jobId)
                .getResultList();
    }

    public List<Job> unqiueJobFromEmployees() {
        //language=HQL
        String hql = "select distinct j\n" +
                "from Employee empl left JOIN Job j on empl.job = j\n" +
                "order by j.minSalary ";
        return this.session.createQuery(hql, Job.class).getResultList();
    }

    public List<Employee> employeeAddressEmpty() {
        //language=HQL
        String hql = "select empl \n" +
                "from Employee empl \n" +
                "where empl.addresses is empty";
        return this.session.createQuery(hql, Employee.class).getResultList();
    }
}
