package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.SelectStatementHQLDao;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

@Slf4j
public class TestSelectStatementDao extends TestCase {

    private Session session;
    private SelectStatementHQLDao selectDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.selectDao = new SelectStatementHQLDao(session);
    }

    @Test
    public void testGetList() {
        List<Mahasiswa> list = this.selectDao.findAll();
        assertEquals("jumlah data: ", 2, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testFindById() {
        Optional<Mahasiswa> optional = this.selectDao.findById(1L);
        assertTrue("id 1 is present", optional.isPresent());
        log.info("data: {}", optional.get());

        optional = this.selectDao.findById(3L);
        assertFalse("id 3 is not present", optional.isPresent());
        log.info("data: {}", optional.orElse(null));
    }

    @Test
    public void testFindByNim() {
        Optional<Mahasiswa> optional = this.selectDao.findByNim("10511150");
        assertTrue("nim 10511150 is present", optional.isPresent());
        log.info("data: {}", optional.get());

        optional = this.selectDao.findByNim("10511159");
        assertFalse("id 3 is not present", optional.isPresent());
        log.info("data: {}", optional.orElse(null));
    }

    @Test
    public void testFindByNamaAtauTahunMasuk() {
        List<Mahasiswa> list = this.selectDao.findByNamaOrTahunMasuk("Dimas Maryanto", 2011);
        assertEquals("jumlah data: ", 2, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
