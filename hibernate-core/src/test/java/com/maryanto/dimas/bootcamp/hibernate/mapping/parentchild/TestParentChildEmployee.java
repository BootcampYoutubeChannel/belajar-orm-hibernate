package com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.dao.ParentChildEmployeeDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Ignore
public class TestParentChildEmployee extends TestCase {

    private Session session;
    private ParentChildEmployeeDao employeeDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.employeeDao = new ParentChildEmployeeDao(session);
    }

    @Test
    public void testSave() {
        Transaction trx = this.session.beginTransaction();
        ParentChildEmployeeEntity manager = ParentChildEmployeeEntity.builder()
                .name("Hari Sapto Adi")
                .job("Chief Technology Officer")
                .address("Cicalengka Raya")
                .salary(new BigDecimal(10_000_000))
                .build();

        manager = this.employeeDao.save(manager);

        ParentChildEmployeeEntity employee1 = ParentChildEmployeeEntity.builder()
                .name("Dimas Maryanto")
                .job("Principal Software Engineer")
                .salary(new BigDecimal(3_500_000))
                .address("Cinunuk")
                .manager(manager)
                .build();

        employee1 = this.employeeDao.save(employee1);

        ParentChildEmployeeEntity employee2 = ParentChildEmployeeEntity.builder()
                .name("Muhamad Yusuf")
                .job("Software Engineer")
                .salary(new BigDecimal(3_000_000))
                .address("Ujung Berung")
                .manager(manager)
                .build();

        employee2 = this.employeeDao.save(employee2);
        trx.commit();

    }

    @Test
    public void testFindByIdWithListEmployee() {
        this.session.beginTransaction();
        Optional<ParentChildEmployeeEntity> optional = this.employeeDao.findById("365eb4fc-d0b8-4d9b-98e9-8c51c9e10d4b");
        assertTrue("employee is present", optional.isPresent());
        ParentChildEmployeeEntity employee = optional.get();
        log.info("karyawan: {}", employee);

        log.info("daftar karyawan yang pimpin manager {}: \n{}",
                employee.getName(), employee.getEmployees());
    }

    @Test
    public void testFindByIdWithManager() {
        this.session.beginTransaction();
        Optional<ParentChildEmployeeEntity> optional = this.employeeDao.findById("365eb4fc-d0b8-4d9b-98e9-8c51c9e10d4b");
        assertTrue("employee is present", optional.isPresent());
        ParentChildEmployeeEntity employee = optional.get();
        log.info("karyawan: {}", employee);

        log.info("karyawan dengan nama {} managernya adalah: {}",
                employee.getName(), employee.getManager());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
