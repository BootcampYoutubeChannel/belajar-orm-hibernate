package com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.dao.EmployeeEnumStringDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeStatus;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Ignore
public class TestEmployeeEnumString extends TestCase {

    private Session session;
    private EmployeeEnumStringDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new EmployeeEnumStringDao(session);
    }

    @Test
    public void testInsertValid() {
        EmployeeEnumString ordinal = EmployeeEnumString.builder()
                .name("Dimas Maryanto")
                .status(EmployeeStatus.LEAVE)
                .birthDate(LocalDate.of(1993, 3, 1))
                .build();

        this.session.beginTransaction();
        ordinal = this.dao.save(ordinal);
        this.session.getTransaction().commit();

        Optional<EmployeeEnumString> employeeOptional = this.dao.findById(ordinal.getId());
        assertTrue("employee is present", employeeOptional.isPresent());
        log.info("employee: {}", employeeOptional.get());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }


}
