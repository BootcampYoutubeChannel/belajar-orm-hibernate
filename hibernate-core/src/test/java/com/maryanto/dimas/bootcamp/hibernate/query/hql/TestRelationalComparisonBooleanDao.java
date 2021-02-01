package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.RelationalComparisonBooleanDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestRelationalComparisonBooleanDao extends TestCase {

    private Session session;
    private RelationalComparisonBooleanDao booleanDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.booleanDao = new RelationalComparisonBooleanDao(session);
    }


    @Test
    public void testBoolean() {
        List<SingleTableMobilEntity> list = this.booleanDao.findEqualByStatusAllWheelDrive(false);
        assertEquals("equal", 1, list.size());
        log.info("data: {}", list);

        list = this.booleanDao.findEqualByStatusAllWheelDrive(null);
        assertEquals("equal", 0, list.size());
        log.info("data: {}", list);

        list = this.booleanDao.findNegationByStatusAllWheelDrive(true);
        assertEquals("equal", 1, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
