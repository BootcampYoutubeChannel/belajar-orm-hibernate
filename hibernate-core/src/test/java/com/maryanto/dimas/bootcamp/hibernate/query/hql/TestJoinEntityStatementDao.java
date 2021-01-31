package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.JoinEntityStatementDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestJoinEntityStatementDao extends TestCase {

    private Session session;
    private JoinEntityStatementDao joinDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.joinDao = new JoinEntityStatementDao(session);
    }

    @Test
    public void testJoinImplicit() {
        List<MahasiswaOneToOneEntity> data = this.joinDao.findByProvinsiWithImplicitJoin("Jawa Barat");
        log.info("data: {}", data);
        assertEquals("jumlah datanya ", 1, data.size());
    }

    @Test
    public void testJoinExplicitJoinON() {
        List<MahasiswaOneToOneEntity> data = this.joinDao.findByProvinsiWithExplicitJoinOn("Jawa Barat");
        log.info("data: {}", data);
        assertEquals("jumlah datanya ", 1, data.size());
    }

    @Test
    public void testJoinExplicitJoinWith() {
        List<MahasiswaOneToOneEntity> data = this.joinDao.findByProvinsiWithExplicitJoinWith("Jawa Barat");
        log.info("data: {}", data);
        assertEquals("jumlah datanya ", 1, data.size());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
