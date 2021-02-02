package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeStatus;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.InPredicateDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestInPredicateDao extends TestCase {

    private Session session;
    private InPredicateDao inDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.inDao = new InPredicateDao(session);
    }

    @Test
    public void testInPredicateAsString() {
        List<ParentChildEmployeeEntity> list = this.inDao.findJobIn(
                Arrays.asList("Software Engineer", "Chief Technology Officer"));
        assertEquals("in string", 2, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testInPredicateAsDate() {
        List<EmployeeEnumString> list = this.inDao.findBirthDateIn(
                Arrays.asList(
                        LocalDate.of(1993, 3, 1),
                        LocalDate.of(1994, 1, 7),
                        LocalDate.of(2021, 1, 1))
        );
        assertEquals("in date", 3, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testInPredicateAsEnum() {
        List<EmployeeEnumString> list = this.inDao.findStatusIn(
                Arrays.asList(EmployeeStatus.LEAVE, EmployeeStatus.RESIGN));
        assertEquals("in enum", 2, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testInPredicateAsNumber() {
        List<ParentChildEmployeeEntity> list = this.inDao.findSalaryIn(Arrays.asList(
                BigDecimal.ZERO,
                new BigDecimal(3_000_000))
        );
        assertEquals("in number", 1, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
