package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.SubQueryQualifierDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestSubQueryQualifierDao extends TestCase {

    private Session session;
    private SubQueryQualifierDao subqueryDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.subqueryDao = new SubQueryQualifierDao(session);
    }

    @Test
    public void testInOperator() {
        List<ParentChildEmployeeEntity> data = this.subqueryDao.findEmployeesWhenSalaryInEmployeeJob("Software Engineer");
        List<String> employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("data: {}", employeeNames);
        assertEquals("jumlah data", 7, data.size());
    }

    @Test
    public void testAllOperator() {
        List<ParentChildEmployeeEntity> data = this.subqueryDao.findEmployeesWhenSalaryEqualAllByAvgSalary("Software Engineer");
        List<String> employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("= ALL: {}", employeeNames);

        data = this.subqueryDao.findEmployeesWhenSalaryLowerAllByAvgSalary("Software Engineer");
        employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("< ALL: {}", employeeNames);

        data = this.subqueryDao.findEmployeesWhenSalaryHigherAllByAvgSalary("Software Engineer");
        employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("> ALL: {}", employeeNames);
    }


    @Test
    public void testAnyOperator() {
        List<ParentChildEmployeeEntity> data = this.subqueryDao.findEmployeesWhenSalaryEqualAnyByEmployeeJob("Software Engineer");
        List<String> employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("= ANY: {}", employeeNames);

        data = this.subqueryDao.findEmployeesWhenSalaryLowerAnyByEmployeeJob("Software Engineer");
        employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("< ANY: {}", employeeNames);

        data = this.subqueryDao.findEmployeesWhenSalaryHigherAnyByEmployeeJob("Software Engineer");
        employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("> ANY: {}", employeeNames);
    }

    @Test
    public void testSomeOperator() {
        List<ParentChildEmployeeEntity> data = this.subqueryDao.findEmployeesWhenSalaryEqualSomeByEmployeeJob("Software Engineer");
        List<String> employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("= SOME: {}", employeeNames);

        data = this.subqueryDao.findEmployeesWhenSalaryLowerSomeByEmployeeJob("Software Engineer");
        employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("< SOME: {}", employeeNames);

        data = this.subqueryDao.findEmployeesWhenSalaryHigherSomeByEmployeeJob("Software Engineer");
        employeeNames = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("> SOME: {}", employeeNames);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
