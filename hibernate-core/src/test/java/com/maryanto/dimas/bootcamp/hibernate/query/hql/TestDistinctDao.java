package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeStatus;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.KelasManyToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.DistinctStatementDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestDistinctDao extends TestCase {

    private Session session;
    private DistinctStatementDao distinctDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.distinctDao = new DistinctStatementDao(session);
    }

    @Test
    public void testDistinctProjection() {
        List<EmployeeStatus> data = this.distinctDao.findByDistinctProjectsSQL();
        log.info("data: {}", data);
        assertEquals("list data", 3, data.size());
    }

    @Test
    public void testDistinctEntityQuery() {
        List<KelasManyToOneEntity> data = this.distinctDao.findByDistinctEntityQuery();
        log.info("data: {}", data);
        assertEquals("list data", 3, data.size());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
