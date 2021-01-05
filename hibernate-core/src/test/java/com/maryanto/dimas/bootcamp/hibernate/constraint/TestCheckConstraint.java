package com.maryanto.dimas.bootcamp.hibernate.constraint;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.constraint.dao.ClassRoomWithUniquesConstraintDao;
import com.maryanto.dimas.bootcamp.hibernate.constraint.dao.EmployeeWithCheckConstraintDao;
import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.ClassRoomWithUniquesConstraint;
import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.EmployeeWithCheckConstraint;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class TestCheckConstraint extends TestCase {

    private Session session;
    private EmployeeWithCheckConstraintDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new EmployeeWithCheckConstraintDao(session);
    }

    @Test
    public void testInsertValid() {
        EmployeeWithCheckConstraint employeeCheck = EmployeeWithCheckConstraint.builder()
                .id(UUID.randomUUID().toString())
                .name("Dimas")
                .salary(new BigDecimal(4_500_000))
                .createdBy("admin")
                .createdDateTime(LocalDateTime.now()).build();
        this.session.beginTransaction();
        this.dao.save(employeeCheck);
        this.session.getTransaction().commit();
    }

    @Test
    public void testInsertInValid() {
        EmployeeWithCheckConstraint employeeCheck = EmployeeWithCheckConstraint.builder()
                .id(UUID.randomUUID().toString())
                .name("Dimas")
                .salary(new BigDecimal(1_500_000))
                .createdBy("admin")
                .createdDateTime(LocalDateTime.now()).build();
        this.session.beginTransaction();
        this.dao.save(employeeCheck);
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
