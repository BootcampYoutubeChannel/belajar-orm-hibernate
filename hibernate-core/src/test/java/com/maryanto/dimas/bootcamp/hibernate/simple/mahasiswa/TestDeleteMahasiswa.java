package com.maryanto.dimas.bootcamp.hibernate.simple.mahasiswa;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.simple.dao.MahasiswaDao;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

@Slf4j
@Ignore
public class TestDeleteMahasiswa extends TestCase {

    private Session session;
    private MahasiswaDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new MahasiswaDao(session);
    }

    @Test
    public void testDeleteMahasiswa() {
        this.session.beginTransaction();
        Optional<Mahasiswa> mahasiswaOptional = this.dao.findById(2L);
        assertTrue("mahasiswa is present", mahasiswaOptional.isPresent());
        this.dao.removeBy(mahasiswaOptional.get());
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
