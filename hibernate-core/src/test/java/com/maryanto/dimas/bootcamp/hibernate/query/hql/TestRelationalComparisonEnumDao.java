package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumOrdinal;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeStatus;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.RelationalComparisonEnumDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestRelationalComparisonEnumDao extends TestCase {

    private Session session;
    private RelationalComparisonEnumDao enumDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.enumDao = new RelationalComparisonEnumDao(session);
    }

    @Test
    public void testEqualEnumeration() {
        List<EmployeeEnumOrdinal> list = this.enumDao.findEqualByEmployeeStatus(EmployeeStatus.LEAVE);
        assertEquals("equal", 1, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testNotEqualEnumeration() {
        List<EmployeeEnumOrdinal> list = this.enumDao.findNotEqualByEmployeeStatus(EmployeeStatus.LEAVE);
        assertEquals("equal", 0, list.size());
        log.info("data: {}", list);

        list = this.enumDao.findNotSameByEmployeeStatus(EmployeeStatus.LEAVE);
        assertEquals("equal", 0, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
