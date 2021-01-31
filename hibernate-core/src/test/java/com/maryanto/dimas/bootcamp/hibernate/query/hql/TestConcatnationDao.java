package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.query.dto.ConcatnationModel;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.ConcatnationDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestConcatnationDao extends TestCase {

    private Session session;
    private ConcatnationDao concatnationDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.concatnationDao = new ConcatnationDao(session);
    }

    @Test
    public void testFunctionConcat() {
        List<ConcatnationModel> data = this.concatnationDao.functionConcat();
        log.info("data: {}", data);
    }

    @Test
    public void testOperatorConcat() {
        List<ConcatnationModel> data = this.concatnationDao.operatorConcat();
        log.info("data: {}", data);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
