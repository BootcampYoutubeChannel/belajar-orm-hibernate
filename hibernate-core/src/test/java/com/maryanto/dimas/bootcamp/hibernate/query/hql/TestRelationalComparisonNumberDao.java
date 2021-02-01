package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.KelasManyToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.RelationalComparisonNumberDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestRelationalComparisonNumberDao extends TestCase {

    private Session session;
    private RelationalComparisonNumberDao numberDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.numberDao = new RelationalComparisonNumberDao(session);
    }

    @Test
    public void testEqualNumberComparison() {
        List<KelasManyToOneEntity> list = this.numberDao.findEqualByTahunAngkatan(2011);
        assertEquals("equal", 1, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testNotEqualNumberComparison() {
        List<KelasManyToOneEntity> list = this.numberDao.findNotEqualByTahunAngkatan(2011);
        assertEquals("not equal", 4, list.size());
        log.info("data: {}", list);

        list = this.numberDao.findNotSameByTahunAngkatan(2011);
        assertEquals("not same", 4, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testHigherNumberComparison() {
        List<KelasManyToOneEntity> list = this.numberDao.findHigherByTahunAngkatan(2011);
        assertEquals("higher", 4, list.size());
        log.info("data: {}", list);

        list = this.numberDao.findHigherThenByTahunAngkatan(2011);
        assertEquals("higher than", 5, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testLowerNumberComparison() {
        List<KelasManyToOneEntity> list = this.numberDao.findLowerByTahunAngkatan(2012);
        assertEquals("lower", 1, list.size());
        log.info("data: {}", list);

        list = this.numberDao.findLowerThanByTahunAngkatan(2012);
        assertEquals("lower than", 2, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
