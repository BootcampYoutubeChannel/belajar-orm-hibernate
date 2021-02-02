package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.BetweenPredicateDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
public class TestBetweenPredicateDao extends TestCase {

    private Session session;
    private BetweenPredicateDao betweenDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.betweenDao = new BetweenPredicateDao(session);
    }

    @Test
    public void testBetweenNumber() {
        List<ParentChildEmployeeEntity> list = this.betweenDao.findSalaryBetween(
                new BigDecimal(3_000_000),
                new BigDecimal(5_000_000));
        assertEquals("list size", 2, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testBetweenDate() {
        List<EmployeeEnumString> list = this.betweenDao.findBirthDateBetween(
                LocalDate.of(1992, 1, 2),
                LocalDate.of(1993, 3, 2));
        assertEquals("list size", 3, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testBetweenCharacter(){
        List<ParentChildEmployeeEntity> list = this.betweenDao.findFirstCharacterBetween("a", "m");
        assertEquals("list size", 3, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
