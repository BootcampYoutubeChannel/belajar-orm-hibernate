package com.maryanto.dimas.bootcamp;

import com.maryanto.dimas.bootcamp.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.dao.hr.EmployeeDao;
import com.maryanto.dimas.bootcamp.dto.EmployeeManagerDto;
import com.maryanto.dimas.bootcamp.dto.EmployeeSalaryDto;
import com.maryanto.dimas.bootcamp.dto.GroupByDepartmentDto;
import com.maryanto.dimas.bootcamp.entity.hr.Employee;
import com.maryanto.dimas.bootcamp.entity.hr.EmployeeStatus;
import com.maryanto.dimas.bootcamp.entity.hr.Job;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestEmployeeDao extends TestCase {

    private Session session;
    private EmployeeDao dao;

    @Override
    protected void setUp() throws Exception {
        this.session = HibernateConfiguration.getSession();
        this.dao = new EmployeeDao(session);
    }

    @Test
    public void testNo3() {
        List<Employee> list = this.dao.findByFirstNameLikeOrSalaryLowerThenOrderCommission("n", new BigDecimal(5_000));
        log.info("data: {}", list);
    }

    @Test
    public void testNo4() {
        Transaction trx = this.session.beginTransaction();
        this.dao.updateCommissionPct("IT_PROG");
        trx.commit();
    }

    @Test
    public void testNo5() {
        List<EmployeeManagerDto> list = this.dao.findEmployeeManager();
        log.info("data: {}", list);
    }

    @Test
    public void testNo6() {
        List<EmployeeSalaryDto> list = this.dao.findBySalaryHigher(new BigDecimal(4000));
        log.info("data: {}", list);
    }

    @Test
    public void testNo7() {
        List<GroupByDepartmentDto> list = this.dao.totalSalariesByDepartments(Arrays.asList(EmployeeStatus.ACTIVE, EmployeeStatus.LEAVE));
        log.info("data: {}", list);
    }

    @Test
    public void testNo8() {
        List<Employee> list = this.dao.findSalarySubQueryByJobId("IT_PROG");
        log.info("data: {}", list);
    }

    @Test
    public void testNo9() {
        List<Job> list = this.dao.unqiueJobFromEmployees();
        log.info("data: {}", list);
    }

    @Test
    public void testNo10() {
        List<Employee> list = this.dao.employeeAddressEmpty();
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("hibernate session shutdown...");
        this.session.close();
    }
}
