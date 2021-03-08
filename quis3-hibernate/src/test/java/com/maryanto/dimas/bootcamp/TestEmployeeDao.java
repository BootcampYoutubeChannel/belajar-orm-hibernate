package com.maryanto.dimas.bootcamp;

import com.maryanto.dimas.bootcamp.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.dao.hr.EmployeeDao;
import com.maryanto.dimas.bootcamp.entity.hr.Employee;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
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

    @Override
    protected void tearDown() throws Exception {
        log.info("hibernate session shutdown...");
        this.session.close();
    }
}
