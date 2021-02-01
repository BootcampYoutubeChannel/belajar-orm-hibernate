package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToOneEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.RelationalComparisonDateAndTimeDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

@Slf4j
public class TestRelationalComparisonDateAndTimeDao extends TestCase {

    private Session session;
    private RelationalComparisonDateAndTimeDao dateAndTimeDao;


    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dateAndTimeDao = new RelationalComparisonDateAndTimeDao(session);
    }

    @Test
    public void testEqualDate() {
        List<MahasiswaOneToOneEntity> list = this.dateAndTimeDao
                .findEqualByTanggalLahir(LocalDate.of(1993, 3, 1));
        assertEquals("equal", 2, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testNotEqualDate() {
        List<MahasiswaOneToOneEntity> list = this.dateAndTimeDao
                .findNotEqualByTanggalLahir(LocalDate.of(1993, 3, 1));
        assertEquals("not equal", 0, list.size());
        log.info("data: {}", list);

        list = this.dateAndTimeDao
                .findNotSameByTanggalLahir(LocalDate.of(1992, 3, 1));
        assertEquals("not same", 2, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testHigherDate() {
        List<MahasiswaOneToOneEntity> list = this.dateAndTimeDao
                .findHigherByTanggalLahir(LocalDate.of(1993, 3, 1));
        assertEquals("higher", 0, list.size());
        log.info("data: {}", list);

        list = this.dateAndTimeDao
                .findHigherThanByTanggalLahir(LocalDate.of(1993, 3, 1));
        assertEquals("higher than", 2, list.size());
        log.info("data: {}", list);
    }

    @Test
    public void testLowerDate() {
        List<MahasiswaOneToOneEntity> list = this.dateAndTimeDao
                .findLowerByTanggalLahir(LocalDate.of(1993, 3, 1));
        assertEquals("higher", 0, list.size());
        log.info("data: {}", list);

        list = this.dateAndTimeDao
                .findLowerThanByTanggalLahir(LocalDate.of(1993, 3, 1));
        assertEquals("higher than", 2, list.size());
        log.info("data: {}", list);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}

