package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.NullessPredicateDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestNullessPredicateDao extends TestCase {

    private Session session;
    private NullessPredicateDao nullessDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.nullessDao = new NullessPredicateDao(session);
    }

    @Test
    public void testOperatorIsNotNull() {
        List<ParentChildEmployeeEntity> list = this.nullessDao.employeeHaveAManager();
        assertEquals("list employee not null", 2, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testOperatorIsNull() {
        List<ParentChildEmployeeEntity> list = this.nullessDao.employeesWithoutManager();
        assertEquals("list employee not null", 1, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
