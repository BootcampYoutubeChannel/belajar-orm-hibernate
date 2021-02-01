package com.maryanto.dimas.bootcamp.hibernate.query.hql;


import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.KelasManyToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.RelationalConditionStringDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestRelataionalConditionStringDao extends TestCase {

    private Session session;
    private RelationalConditionStringDao stringDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.stringDao = new RelationalConditionStringDao(session);
    }

    @Test
    public void testStringComparison() {
        List<KelasManyToOneEntity> list = this.stringDao.findEqualBy("IS-01");
        assertEquals("equal operator", 3, list.size());
        log.info("data: {}", list);

        list = this.stringDao.findNotEqualBy("IS-01");
        assertEquals("equal operator", 2, list.size());
        log.info("data: {}", list);

        list = this.stringDao.findNotSameBy("IS-01");
        assertEquals("equal operator", 2, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
