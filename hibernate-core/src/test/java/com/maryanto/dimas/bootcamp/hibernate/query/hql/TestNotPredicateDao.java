package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.NotPredicateDao;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestNotPredicateDao extends TestCase {

    private Session session;
    private NotPredicateDao notDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.notDao = new NotPredicateDao(session);
    }

    @Test
    public void testNegation() {
        List<Mahasiswa> data = this.notDao.findByNotActive();
        log.info("data: {}", data);
        assertEquals("jumlah data", 1, data.size());
    }

    /**
     * data: 1999-09-09 ada 2 data
     */
    @Test
    public void testNotIn() {
        List<Mahasiswa> data = this.notDao.findByBirthDateNotIn(
                Arrays.asList(
                        LocalDate.of(1999, 9, 8)
                ));
        log.info("data: {}", data);
        assertEquals("jumlah data", 3, data.size());
    }

    @Test
    public void testNotNull() {
        List<Mahasiswa> data = this.notDao.findByBioNotNull();
        log.info("data: {}", data);
        assertEquals("jumlah data", 1, data.size());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
