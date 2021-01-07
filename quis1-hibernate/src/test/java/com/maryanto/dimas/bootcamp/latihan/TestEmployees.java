package com.maryanto.dimas.bootcamp.latihan;

import com.maryanto.dimas.bootcamp.latihan.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.latihan.dao.EmployeesDao;
import com.maryanto.dimas.bootcamp.latihan.dao.EmployeesDao;
import com.maryanto.dimas.bootcamp.latihan.entity.Employees;
import com.maryanto.dimas.bootcamp.latihan.entity.Employees;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Slf4j
public class TestEmployees extends TestCase {

    private Session session;
    private EmployeesDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new EmployeesDao(session);
    }

    @Test
    public void testSaveJob() {
        this.session.beginTransaction();
        Employees dimas = Employees.builder()
                .namaLengkap("Dimas Maryanto")
                .active(true)
                .gajiSebulan(new BigDecimal(3_000_000))
                .tanggalLahir(LocalDate.of(1991, 1, 1))
                .nip("10511148")
                .build();
        dimas = this.dao.save(dimas);
        this.session.getTransaction().commit();
        assertNotNull("employee id was return", dimas.getId());
    }

    @Test
    public void testUpdateJob() {
        this.session.beginTransaction();
        Employees dimas = Employees.builder()
                .id("586d203f-ee9b-4ea7-909f-24769810e13e")
                .namaLengkap("Dimas Maryanto")
                .active(true)
                .gajiSebulan(new BigDecimal(3_000_000))
                .tanggalLahir(LocalDate.of(1993, 3, 3))
                .nip("10511148")
                .build();
        dimas = this.dao.update(dimas);
        this.session.getTransaction().commit();
    }

    @Test
    public void testFindById() {
        this.session.beginTransaction();
        Optional<Employees> employeeOptional = this.dao.findById("586d203f-ee9b-4ea7-909f-24769810e13e");
        assertTrue("employee id present", employeeOptional.isPresent());
        log.info("employee => {}", employeeOptional.get());
    }

    @Test
    public void testDeleteById() {
        this.session.beginTransaction();
        Optional<Employees> employeeOptional = this.dao.findById("586d203f-ee9b-4ea7-909f-24769810e13e");
        assertTrue("employee id present", employeeOptional.isPresent());
        log.info("employee => {}", employeeOptional.get());
        this.dao.removeBy(employeeOptional.get());
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
